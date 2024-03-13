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

public class Stone extends JavaPlugin {
    public static ItemStack stoneKatana;

    public static void init() {
        createStoneKatana();
    }
    private static void createStoneKatana() {
        ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + Katanas.getCurrentLang().getString("katanas.stone"));
        im.setLocalizedName("stone_katana");
        im.setCustomModelData(8);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(ChatColor.GRAY + Katanas.getCurrentLang().getString("item_description.in_main_hand"));
        String attackDamage = String.valueOf(config.getDouble("katanas.stone.attack-damage"));
        String attackSpeed = String.valueOf(config.getDouble("katanas.stone.attack-speed"));
        lore.add(ChatColor.DARK_GREEN + " " + attackDamage + Katanas.getCurrentLang().getString("item_description.att_damage"));
        lore.add(ChatColor.DARK_GREEN + " " + attackSpeed + Katanas.getCurrentLang().getString("item_description.att_speed"));
        im.setLore(lore);

        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4 + config.getDouble("katanas.stone.attack-speed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", config.getDouble("katanas.stone.attack-damage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(im);
        stoneKatana = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("stone_katana"), item);
        sr.shape("X  ", " X ", "  Z");
        sr.setIngredient('X', Material.CHISELED_STONE_BRICKS);
        sr.setIngredient('Z', Material.STICK);
        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("stone_katana2"), item);
        sr2.shape("X  ", " X ", "  Z");
        sr2.setIngredient('X', Material.CHISELED_DEEPSLATE);
        sr2.setIngredient('Z', Material.STICK);
        try {
            Bukkit.addRecipe(sr);
            Bukkit.addRecipe(sr2);
        } catch (IllegalStateException ignored) {}
    }
}
