package me.greefox.greefox.me.Greefox.KatanasTypes.Strong;

import me.greefox.greefox.me.Greefox.Katanas;
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

import static me.greefox.greefox.me.Greefox.Inits.config;
import static me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Diamond.diamondKatana;

public class Netherite extends JavaPlugin {
    public static ItemStack netheriteKatana;

    public static void init() {
        createNetheriteKatana();
    }

    private static void createNetheriteKatana() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + Katanas.getCurrentLang().getString("katanas.netherite"));
        im.setLocalizedName("netherite_katana");
        im.setCustomModelData(8);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(ChatColor.GRAY + Katanas.getCurrentLang().getString("item_description.in_main_hand"));
        String attackDamage = String.valueOf(config.getDouble("katanas.netherite.attack-damage"));
        String attackSpeed = String.valueOf(config.getDouble("katanas.netherite.attack-speed"));
        lore.add(ChatColor.DARK_GREEN + " " + attackDamage + Katanas.getCurrentLang().getString("item_description.att_damage"));
        lore.add(ChatColor.DARK_GREEN + " " + attackSpeed + Katanas.getCurrentLang().getString("item_description.att_speed"));
        im.setLore(lore);

        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4 + config.getDouble("katanas.netherite.attack-speed"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", config.getDouble("katanas.netherite.attack-damage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(im);
        netheriteKatana = item;
        SmithingTransformRecipe smtr = new SmithingTransformRecipe(NamespacedKey.minecraft("netherite_katana"), item, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.ExactChoice(diamondKatana), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        if (config.getBoolean("katanas.netherite.enable")) {
            try {
                Bukkit.addRecipe(smtr);
            } catch (IllegalStateException ignored) {
            }
        } else {
        }
    }

}
