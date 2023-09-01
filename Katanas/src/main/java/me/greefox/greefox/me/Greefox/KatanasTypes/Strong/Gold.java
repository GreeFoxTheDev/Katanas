package me.greefox.greefox.me.Greefox.KatanasTypes.Strong;

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

public class Gold extends JavaPlugin {
    public static ItemStack goldKatana;

    public static void init() {
        createGoldKatana();
    }

    private static void createGoldKatana() {
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fGold Katana");
        im.setLocalizedName("gold_katana");
        im.setCustomModelData(8);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "When in Main Hand:");
        lore.add(ChatColor.DARK_GREEN + " 7 Attack Damage");
        lore.add(ChatColor.DARK_GREEN + " 1.25 Attack Speed");
        im.setLore(lore);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -2.7, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 7, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(im);
        goldKatana = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("katana_gold"), item);
        sr.shape("  X", " Y ", "Z  ");
        sr.setIngredient('X', Material.GOLD_INGOT);
        sr.setIngredient('Y', Material.GOLD_BLOCK);
        sr.setIngredient('Z', Material.STICK);
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {}
    }

}
