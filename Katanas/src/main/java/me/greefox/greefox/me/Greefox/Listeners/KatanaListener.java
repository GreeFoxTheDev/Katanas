package me.greefox.greefox.me.Greefox.Listeners;

import me.greefox.greefox.me.Greefox.Katanas;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static me.greefox.greefox.me.Greefox.Inits.config;

public class KatanaListener implements Listener {
    Katanas plugin;

    public KatanaListener(Katanas plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onApplyDamage(@NotNull InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();

        if (item != null && item.hasItemMeta() && item.getItemMeta().hasLocalizedName()) {
            String localizedName = item.getItemMeta().getLocalizedName();

            switch (localizedName) {
                case "copper_katana": applyKatanaDamage(item, config.getDouble("katanas.copper.attack-damage")); break;
                case "diamond_katana": applyKatanaDamage(item, config.getDouble("katanas.diamond.attack-damage")); break;
                case "golden_katana": applyKatanaDamage(item, config.getDouble("katanas.golden.attack-damage")); break;
                case "netherite_katana": applyKatanaDamage(item, config.getDouble("katanas.netherite.attack-damage")); break;
                case "iron_katana": applyKatanaDamage(item, config.getDouble("katanas.iron.attack-damage")); break;
                case "light_copper_katana": applyKatanaDamage(item, config.getDouble("light-katanas.copper.attack-damage")); break;
                case "light_diamond_katana": applyKatanaDamage(item, config.getDouble("light-katanas.diamond.attack-damage")); break;
                case "light_golden_katana": applyKatanaDamage(item, config.getDouble("light-katanas.golden.attack-damage")); break;
                case "light_netherite_katana": applyKatanaDamage(item, config.getDouble("light-katanas.netherite.attack-damage")); break;
                case "light_iron_katana": applyKatanaDamage(item, config.getDouble("light-katanas.iron.attack-damage")); break;
            }
        } if (item != null && item.hasItemMeta() && item.getItemMeta().hasLocalizedName() && item.getItemMeta().getLocalizedName().contains("katana")) {
            enchantKatana(item);
        }
    }

    private void applyKatanaDamage(ItemStack item, double baseDamage) {
        ItemMeta im = item.getItemMeta();
        List<String> lore = im.getLore();

        if (item.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
            int enchLevel = im.getEnchantLevel(Enchantment.DAMAGE_ALL);
            double sharpDamage = 0.5 * enchLevel + 0.5;
            double finalDamage = baseDamage + sharpDamage;
            String finalDamageString = String.valueOf(finalDamage);

            assert lore != null;
            String lore0 = lore.get(0);
            String lore1 = lore.get(1);
            String lore3 = lore.get(3);

            lore.clear();
            lore.add(lore0);
            lore.add(lore1);
            lore.add(ChatColor.DARK_GREEN + " " + finalDamageString + " Attack Damage");
            lore.add(lore3);
            im.setLore(lore);
            item.setItemMeta(im);
        }
    }

    private void enchantKatana(ItemStack item) {
        ItemMeta im = item.getItemMeta();

        if (item.getItemMeta().hasEnchants()) {
            String itemName = im.getDisplayName();
            String normalItemName = itemName.replace("§f", "");
            im.setDisplayName(ChatColor.AQUA + normalItemName);
            item.setItemMeta(im);
        }
    }
}
