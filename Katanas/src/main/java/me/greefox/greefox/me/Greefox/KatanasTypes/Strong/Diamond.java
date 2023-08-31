package me.greefox.greefox.me.Greefox.KatanasTypes.Strong;

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

public class Diamond extends JavaPlugin {
    public static ItemStack diamondKatana;
    public static void init() {
        createDiamondKatana();
    }
    private static void createDiamondKatana() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fDiamond Katana");
        im.setLocalizedName("diamond_katana");
        im.setCustomModelData(8);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "When in Main Hand:");
        lore.add(ChatColor.DARK_GREEN + " 8.5 Attack Damage");
        lore.add(ChatColor.DARK_GREEN + " 1.25 Attack Speed");
        im.setLore(lore);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -2.7, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 8.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(im);
        diamondKatana = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("diamond_katana"), item);
        sr.shape("  X", " Y ", "Z  ");
        sr.setIngredient('X', Material.DIAMOND);
        sr.setIngredient('Y', Material.DIAMOND_BLOCK);
        sr.setIngredient('Z', Material.STICK);
        SmithingRecipe smr = new SmithingRecipe(NamespacedKey.minecraft("netherite_katana"), item, new RecipeChoice.ExactChoice(diamondKatana), //base on upgrade gear
                new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT)); //addiction
        try {
            Bukkit.addRecipe(sr);
            Bukkit.addRecipe(smr);
        } catch (IllegalStateException ignored) {}
    }
}