package me.greefox.greefox.me.Greefox.KatanasTypes.Strong;

import me.greefox.greefox.me.Greefox.Katanas;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static me.greefox.greefox.me.Greefox.Inits.config;

public class Wooden extends JavaPlugin {
    public static ItemStack woodenKatana;

    public static void init() {
        createStoneKatana();
    }
    private static void createStoneKatana() {
        ItemStack item = new ItemStack(Material.WOODEN_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + Katanas.getCurrentLang().getString("katanas.wooden"));
        im.setLocalizedName("wooden_katana");
        im.setCustomModelData(8);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(ChatColor.GRAY + Katanas.getCurrentLang().getString("item_description.in_main_hand"));
        String attackDamage = String.valueOf(config.getDouble("katanas.wooden.attack-damage"));
        String attackSpeed = String.valueOf(config.getDouble("katanas.wooden.attack-speed"));
        lore.add(ChatColor.DARK_GREEN + " " + attackDamage + Katanas.getCurrentLang().getString("item_description.att_damage"));
        lore.add(ChatColor.DARK_GREEN + " " + attackSpeed + Katanas.getCurrentLang().getString("item_description.att_speed"));
        im.setLore(lore);

        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4 + config.getDouble("katanas.wooden.attack-speed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", config.getDouble("katanas.wooden.attack-damage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(im);
        woodenKatana = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana"), item);
        sr.shape("X  ", " X ", "  Z");
        sr.setIngredient('X', Material.ACACIA_LOG);
        sr.setIngredient('Z', Material.STICK);
        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana1"), item);
        sr2.shape("X  ", " X ", "  Z");
        sr2.setIngredient('X', Material.BIRCH_LOG);
        sr2.setIngredient('Z', Material.STICK);
        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana2"), item);
        sr3.shape("X  ", " X ", "  Z");
        sr3.setIngredient('X', Material.DARK_OAK_LOG);
        sr3.setIngredient('Z', Material.STICK);
        ShapedRecipe sr4 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana3"), item);
        sr4.shape("X  ", " X ", "  Z");
        sr4.setIngredient('X', Material.BAMBOO_MOSAIC);
        sr4.setIngredient('Z', Material.STICK);
        ShapedRecipe sr5 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana4"), item);
        sr5.shape("X  ", " X ", "  Z");
        sr5.setIngredient('X', Material.CHERRY_LOG);
        sr5.setIngredient('Z', Material.STICK);
        ShapedRecipe sr6 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana5"), item);
        sr6.shape("X  ", " X ", "  Z");
        sr6.setIngredient('X', Material.SPRUCE_LOG);
        sr6.setIngredient('Z', Material.STICK);
        ShapedRecipe sr7 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana6"), item);
        sr7.shape("X  ", " X ", "  Z");
        sr7.setIngredient('X', Material.MANGROVE_LOG);
        sr7.setIngredient('Z', Material.STICK);
        ShapedRecipe sr8 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana7"), item);
        sr8.shape("X  ", " X ", "  Z");
        sr8.setIngredient('X', Material.OAK_LOG);
        sr8.setIngredient('Z', Material.STICK);
        ShapedRecipe sr9 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana8"), item);
        sr9.shape("X  ", " X ", "  Z");
        sr9.setIngredient('X', Material.JUNGLE_LOG);
        sr9.setIngredient('Z', Material.STICK);
        try {
            Bukkit.addRecipe(sr);
            Bukkit.addRecipe(sr2);
            Bukkit.addRecipe(sr3);
            Bukkit.addRecipe(sr4);
            Bukkit.addRecipe(sr5);
            Bukkit.addRecipe(sr6);
            Bukkit.addRecipe(sr7);
            Bukkit.addRecipe(sr8);
            Bukkit.addRecipe(sr9);
        } catch (IllegalStateException ignored) {}
    }
}
