package me.nick1666.shaddy.items;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack TestTube;

    public static void init() { createTestTube(); }

    public static void createTestTube() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§rTest Tube");
        item.setItemMeta(meta);

        TestTube = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("test_tube"), item.asQuantity(5));
        sr.shape("GBG",
                 "G G",
                 " G ");
        sr.setIngredient('B', new RecipeChoice.MaterialChoice(Tag.WOODEN_BUTTONS));
        sr.setIngredient('G', Material.TINTED_GLASS);




        Bukkit.addRecipe(sr);
    }
}
