package me.greefox.greefox.me.Greefox.KatanasTypes.Light;

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

public class WoodenLight extends JavaPlugin {
    public static ItemStack lightWoodenKatana;

    public static void init() {
        createLightWoodenKatana();
    }
    private static void createLightWoodenKatana() {
        ItemStack item = new ItemStack(Material.WOODEN_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + Katanas.getCurrentLang().getString("light-katanas.wooden"));
        im.setLocalizedName("light_wooden_katana");
        im.setCustomModelData(9);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(ChatColor.GRAY + Katanas.getCurrentLang().getString("item_description.in_main_hand"));
        String attackDamage = String.valueOf(config.getDouble("light-katanas.wooden.attack-damage"));
        String attackSpeed = String.valueOf(config.getDouble("light-katanas.wooden.attack-speed"));
        lore.add(ChatColor.DARK_GREEN + " " + attackDamage + Katanas.getCurrentLang().getString("item_description.att_damage"));
        lore.add(ChatColor.DARK_GREEN + " " + attackSpeed + Katanas.getCurrentLang().getString("item_description.att_speed"));
        im.setLore(lore);

        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4 + config.getDouble("light-katanas.wooden.attack-speed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", config.getDouble("light-katanas.wooden.attack-damage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(im);
        lightWoodenKatana = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana_light"), item);
        sr.shape("X  ", " X ", "  Z");
        sr.setIngredient('X', Material.ACACIA_PLANKS);
        sr.setIngredient('Z', Material.STICK);
        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana_light1"), item);
        sr2.shape("X  ", " X ", "  Z");
        sr2.setIngredient('X', Material.BIRCH_PLANKS);
        sr2.setIngredient('Z', Material.STICK);
        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana_light2"), item);
        sr3.shape("X  ", " X ", "  Z");
        sr3.setIngredient('X', Material.DARK_OAK_PLANKS);
        sr3.setIngredient('Z', Material.STICK);
        ShapedRecipe sr4 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana_light3"), item);
        sr4.shape("X  ", " X ", "  Z");
        sr4.setIngredient('X', Material.BAMBOO_PLANKS);
        sr4.setIngredient('Z', Material.STICK);
        ShapedRecipe sr5 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana_light4"), item);
        sr5.shape("X  ", " X ", "  Z");
        sr5.setIngredient('X', Material.CHERRY_PLANKS);
        sr5.setIngredient('Z', Material.STICK);
        ShapedRecipe sr6 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana_light5"), item);
        sr6.shape("X  ", " X ", "  Z");
        sr6.setIngredient('X', Material.SPRUCE_PLANKS);
        sr6.setIngredient('Z', Material.STICK);
        ShapedRecipe sr7 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana_light6"), item);
        sr7.shape("X  ", " X ", "  Z");
        sr7.setIngredient('X', Material.MANGROVE_PLANKS);
        sr7.setIngredient('Z', Material.STICK);
        ShapedRecipe sr8 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana_light7"), item);
        sr8.shape("X  ", " X ", "  Z");
        sr8.setIngredient('X', Material.OAK_PLANKS);
        sr8.setIngredient('Z', Material.STICK);
        ShapedRecipe sr9 = new ShapedRecipe(NamespacedKey.minecraft("wooden_katana_light8"), item);
        sr9.shape("X  ", " X ", "  Z");
        sr9.setIngredient('X', Material.JUNGLE_PLANKS);
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
