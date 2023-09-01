package me.greefox.greefox.me.Greefox.KatanasTypes.Light;

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

public class GoldLight extends JavaPlugin {
    public static ItemStack lightGoldKatana;

    public static void init() {
        createLightGoldKatana();
    }
    private static void createLightGoldKatana() {
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fLight Gold Katana");
        im.setLocalizedName("light_diamond_katana");
        im.setCustomModelData(9);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "When in Main Hand:");
        lore.add(ChatColor.DARK_GREEN + " 5.5 Attack Damage");
        lore.add(ChatColor.DARK_GREEN + " 1.4 Attack Speed");
        im.setLore(lore);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -2.4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 5.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(im);
        lightGoldKatana = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("gold_katana_light"), item);
        sr.shape("  X", " X ", "Z  ");
        sr.setIngredient('X', Material.GOLD_INGOT);
        sr.setIngredient('Z', Material.STICK);
        try {
            Bukkit.addRecipe(sr);
        } catch (IllegalStateException ignored) {}
    }
}
