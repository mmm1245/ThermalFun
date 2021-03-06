package com.github.mmm1245.thermalfun;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.UUID;

public class PlayerHeatStorage {
    private final HashMap<UUID, HeatValues> db;
    public PlayerHeatStorage() {
        this.db = new HashMap<>();
    }
    public void loadPlayer(Player player){
        int max = player.getPersistentDataContainer().getOrDefault(ThermalFunMain.getKeys().HEAT_MAX, PersistentDataType.INTEGER, 1);
        int current = player.getPersistentDataContainer().getOrDefault(ThermalFunMain.getKeys().HEAT_CURRENT, PersistentDataType.INTEGER, 1);
        db.put(player.getUniqueId(), new HeatValues(player, max, current));
    }
    public void savePlayer(Player player){
        HeatValues values = db.get(player.getUniqueId());
        player.getPersistentDataContainer().set(ThermalFunMain.getKeys().HEAT_MAX, PersistentDataType.INTEGER, values.max);
        player.getPersistentDataContainer().set(ThermalFunMain.getKeys().HEAT_CURRENT, PersistentDataType.INTEGER, values.current);
        values.removePlayerFromBar();
        db.remove(player.getUniqueId());
    }
    public HeatValues forPlayer(Player player){
        return db.get(player.getUniqueId());
    }

    public class HeatValues {
        private int max;
        private int current;
        private BossBar bossBar;
        private int fakeCurrentModifier;
        private HeatValues(Player player, int max, int current) {
            this.max = max;
            this.current = current;
            this.bossBar = ThermalFunMain.getInstance().getServer().createBossBar("", BarColor.RED, BarStyle.SOLID);
            this.bossBar.addPlayer(player);
            this.fakeCurrentModifier = 0;
            update();
            setShown(false);
        }
        private void update(){
            this.bossBar.setProgress(current/((float)max));
            String modifier = "";
            if(fakeCurrentModifier != 0){
                modifier = "(" + (fakeCurrentModifier>0?"+":"") + fakeCurrentModifier + ")";
            }
            this.bossBar.setTitle("heat: " + current + modifier + "/" + max);
        }

        public void increaseMax(int inc){
            setMax(getMax()+inc);
        }
        public void increaseCurrent(int inc){
            setCurrent(getCurrent()+inc);
        }
        public void setMaxAnd(int max) {
            this.max = max;
            update();
        }
        public void setMax(int max) {
            this.max = max;
            if(this.max < 1)
                this.max = 1;
            if(this.current > this.max)
                this.current = this.max;
            update();
        }
        public void setCurrent(int current) {
            this.current = current;
            if(this.current > this.max)
                this.current = this.max;
            if(this.current < 0)
                this.current = 0;
            update();
        }

        public int getFakeCurrentModifier() {
            return fakeCurrentModifier;
        }
        public void setFakeCurrentModifier(int fakeCurrentModifier) {
            this.fakeCurrentModifier = fakeCurrentModifier;
            update();
        }
        public int getMax() {
            return max;
        }
        public int getCurrent() {
            return current;
        }
        public void setShown(boolean shown){
            bossBar.setVisible(shown);
        }

        private void removePlayerFromBar(){
            this.bossBar.removeAll();
        }
    }
}
