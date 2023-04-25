package me.greefox.greefox.me.Greefox;

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

public class Iron extends JavaPlugin {
    public static void init(){
        createIronKatana();
        createLightIronKatana();
    }
    public static ItemStack ironKatana;
    private static void createIronKatana(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fIron Katana");
        im.setLocalizedName("iron_katana");
        im.setCustomModelData(8);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "When in Main Hand:");
        lore.add(ChatColor.DARK_GREEN + " 7 Attack Damage");
        lore.add(ChatColor.DARK_GREEN + " 1.25 Attack Speed");
        im.setLore(lore);

        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(),
                "generic.attackSpeed", -2.7, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(),
                "generic.attackDamage", 7, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(im);
        ironKatana = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("iron_katana"), item);
        sr.shape("  X", " Y ", "Z  ");
        sr.setIngredient('X', Material.IRON_INGOT);
        sr.setIngredient('Y', Material.IRON_BLOCK);
        sr.setIngredient('Z', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

    }
    public static ItemStack lightIronKatana;
    private static void createLightIronKatana(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fLight Iron Katana");
        im.setLocalizedName("light_iron_katana");
        im.setCustomModelData(9);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "When in Main Hand:");
        lore.add(ChatColor.DARK_GREEN + " 6.5 Attack Damage");
        lore.add(ChatColor.DARK_GREEN + " 1.4 Attack Speed");
        im.setLore(lore);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(),
                "generic.attackSpeed", -2.4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(),
                "generic.attackDamage", 6.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(im);
        lightIronKatana = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("iron_katana_light"), item);
        sr.shape("X  ", " X ", "  Z");
        sr.setIngredient('X', Material.IRON_INGOT);
        sr.setIngredient('Z', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }
}
