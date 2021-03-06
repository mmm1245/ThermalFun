package com.github.mmm1245.thermalfun.items;

import com.github.mmm1245.thermalfun.ThermalFunMain;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ThermalFunRecipes {
    public static final RecipeType TYPE_KILL_BLAZE = new RecipeType(ThermalFunMain.createKey("kill_blaze"), ThermalFunStacks.KILL_BLAZE_HEAD);
    public static final RecipeType TYPE_FORTRESS_LOOTTABLE = new RecipeType(ThermalFunMain.createKey("fortress_loottable"), ThermalFunStacks.FORTRESS_LOOTTABLE_CHEST);


    public static final ItemStack[] INACTIVE_THERMAL_WAND = {
            null, SlimefunItems.CARBONADO, null,
            null, new ItemStack(Material.STICK), null,
            null, new ItemStack(Material.STICK), null
    };
    public static final ItemStack[] THERMAL_WAND = {
            null, null, null,
            null, ThermalFunStacks.INACTIVE_THERMAL_WAND, null,
            null, null, null
    };
    public static final ItemStack[] BLAZING_SOUP = {
            new ItemStack(Material.MAGMA_CREAM), new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.MAGMA_CREAM),
            new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.CRIMSON_FUNGUS), new ItemStack(Material.BLAZE_ROD),
            new ItemStack(Material.MAGMA_CREAM), new ItemStack(Material.BOWL), new ItemStack(Material.MAGMA_CREAM)
    };
    public static final ItemStack[] BLAZING_APPLE = {
            null, new ItemStack(Material.CRIMSON_FUNGUS), null,
            new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.APPLE), new ItemStack(Material.MAGMA_CREAM),
            null, new ItemStack(Material.CRIMSON_FUNGUS), null
    };
}
