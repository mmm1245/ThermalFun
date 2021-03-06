package com.github.mmm1245.thermalfun;

import com.github.mmm1245.thermalfun.abilities.ThermalFunAbilities;
import com.github.mmm1245.thermalfun.abilities.AbilityRegistry;
import com.github.mmm1245.thermalfun.abilities.PlayerAbilityStorage;
import com.github.mmm1245.thermalfun.commands.Commands;
import com.github.mmm1245.thermalfun.items.ItemManager;
import com.github.mmm1245.thermalfun.listeners.ListenerManager;
import com.github.mmm1245.thermalfun.listeners.PlayerJoinQuitListener;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public final class ThermalFunMain extends JavaPlugin implements SlimefunAddon {
    private ItemManager itemManager;
    private ListenerManager listenerManager;
    private Random random;
    private Keys keys;
    private PlayerHeatStorage heatStorage;
    private PlayerAbilityStorage abilityStorage;
    private Commands commands;
    private AbilityRegistry abilityRegistry = new AbilityRegistry();
    private ThermalFunAbilities abilities;

    @Override
    public void onEnable() {
        Config cfg = new Config(this);

        this.random = new Random();
        this.keys = new Keys(this);
        this.heatStorage = new PlayerHeatStorage();
        this.abilityStorage = new PlayerAbilityStorage();

        this.abilities = new ThermalFunAbilities(cfg);
        this.abilities.register();

        for(Player player : getServer().getOnlinePlayers()){
            PlayerJoinQuitListener.onJoin(player);
        }

        this.itemManager = new ItemManager(cfg);
        this.itemManager.register(this);

        this.listenerManager = new ListenerManager();
        this.listenerManager.register(this);

        this.commands = new Commands();
        this.commands.register(this);

        getServer().getScheduler().runTaskTimer(this, new PlayerUIUpdater(), 5, 5);
    }

    @Override
    public void onDisable() {
        for(Player player : getServer().getOnlinePlayers()){
            PlayerJoinQuitListener.onQuit(player);
        }
        abilityRegistry.clear();
    }


    public static ThermalFunMain getInstance() {
        return JavaPlugin.getPlugin(ThermalFunMain.class);
    }
    public static NamespacedKey createKey(String key){
        return new NamespacedKey(getInstance(), key);
    }
    public static Random getRandom(){
        return getInstance().random;
    }
    public static ItemManager getItemManager(){
        return getInstance().itemManager;
    }
    public static ListenerManager getListenerManager(){
        return getInstance().listenerManager;
    }
    public static Keys getKeys(){
        return getInstance().keys;
    }
    public static PlayerHeatStorage getHeatStorage(){
        return getInstance().heatStorage;
    }
    public static PlayerAbilityStorage getAbilityStorage(){
        return getInstance().abilityStorage;
    }
    public static Commands getCommands() {
        return getInstance().commands;
    }
    public static AbilityRegistry getAbilityRegistery() {
        return getInstance().abilityRegistry;
    }
    public static ThermalFunAbilities getAbilities() {
        return getInstance().abilities;
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return "https://github.com/mmm1245/ThermalFun/issues";
    }
}
