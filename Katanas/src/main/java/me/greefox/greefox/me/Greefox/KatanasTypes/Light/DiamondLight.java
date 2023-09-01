package me.greefox.greefox.me.Greefox.KatanasTypes.Light;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DiamondLight extends JavaPlugin {
    public static ItemStack lightDiamondKatana;

    public static void init() {
        createLightDiamondKatana();
    }
    private static void createLightDiamondKatana() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fLight Diamond Katana");
        im.setLocalizedName("light_diamond_katana");
        im.setCustomModelData(9);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "When in Main Hand:");
        lore.add(ChatColor.DARK_GREEN + " 7.5 Attack Damage");
        lore.add(ChatColor.DARK_GREEN + " 1.4 Attack Speed");
        im.setLore(lore);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -2.4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 7.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(im);
        lightDiamondKatana = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("diamond_katana_light"), item);
        sr.shape("  X", " X ", "Z  ");
        sr.setIngredient('X', Material.DIAMOND);
        sr.setIngredient('Z', Material.STICK);
        SmithingRecipe smr = new SmithingRecipe(NamespacedKey.minecraft("light_netherite_katana"), item, new RecipeChoice.ExactChoice(lightDiamondKatana), //base on upgrade gear
                new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        try {
            Bukkit.addRecipe(sr);
            Bukkit.addRecipe(smr);
        } catch (IllegalStateException ignored) {}
    }
}
