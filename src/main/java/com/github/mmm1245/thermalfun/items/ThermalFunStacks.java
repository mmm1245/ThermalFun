package com.github.mmm1245.thermalfun.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class ThermalFunStacks {
    private static final String BLAZE_HEAD_TEXTURE = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjIwNjU3ZTI0YjU2ZTFiMmY4ZmMyMTlkYTFkZTc4OGMwYzI0ZjM2Mzg4YjFhNDA5ZDBjZDJkOGRiYTQ0YWEzYiJ9fX0=";

    public static final SlimefunItemStack INACTIVE_THERMAL_WAND = new SlimefunItemStack("INACTIVE_THERMAL_WAND", Material.STICK, "&0Inactive Thermal Wand", "Active by killing blaze while in offhand.");
    public static final SlimefunItemStack THERMAL_WAND = new SlimefunItemStack("THERMAL_WAND", Material.BLAZE_ROD, "&cThermal Wand", "Unlock abilites by finding upgrades in fortress chests", "Change ability using Shift+Right Click", "Increase you max heat by killing blazes and magma cubes", "Increase your heat by eating blazing apple and blazing soup");
    public static final SlimefunItemStack KILL_BLAZE_HEAD = new SlimefunItemStack("BLAZE_HEAD", BLAZE_HEAD_TEXTURE, "&cKill Blaze while in offhand");
    public static final SlimefunItemStack FORTRESS_LOOTTABLE_CHEST = new SlimefunItemStack("FORTRESS_LOOTTABLE", Material.CHEST, "&0Find this item in nether fortress chest");
}
