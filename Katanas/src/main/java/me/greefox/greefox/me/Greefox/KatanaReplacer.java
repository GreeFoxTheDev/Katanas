package me.greefox.greefox.me.Greefox;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

import static org.bukkit.inventory.ItemFlag.HIDE_ATTRIBUTES;

public class KatanaReplacer implements Listener {
    Katanas plugin;

    public KatanaReplacer(Katanas plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getCurrentItem().getItemMeta() != null) {
            if (event.getWhoClicked().getInventory().contains(Material.DIAMOND_SWORD) || (event.getWhoClicked().getInventory().contains(Material.IRON_SWORD)) || (event.getWhoClicked().getInventory().contains(Material.GOLDEN_SWORD))) {
                Player player = (Player) event.getWhoClicked();
                ItemStack item = event.getCurrentItem();
                ItemMeta im = item.getItemMeta();
                List<String> lore = im.getLore();
                //getting numbers

                assert item != null;
                double data = item.getItemMeta().getCustomModelData();
                if (!(item.getItemMeta().getItemFlags().contains(HIDE_ATTRIBUTES))) {
                    if (data == 8) {
                        if (item.getType().equals(Material.DIAMOND_SWORD)) {
                            ItemMeta diamondMeta = item.getItemMeta();
                            event.getCurrentItem().setItemMeta(diamondMeta);
                        }
                        if (item.getType().equals(Material.IRON_SWORD)) {
                            ItemMeta ironMeta = item.getItemMeta();
                            event.getCurrentItem().setItemMeta(ironMeta);
                        }
                        if (item.getType().equals(Material.GOLDEN_SWORD)) {
                            ItemMeta goldenMeta = item.getItemMeta();
                            event.getCurrentItem().setItemMeta(goldenMeta);
                        }
                    }
                    if (data == 10) {
                        if (item.getType().equals(Material.DIAMOND_SWORD)) {
                            ItemMeta diamondMetaLight = item.getItemMeta();
                            event.getCurrentItem().setItemMeta(diamondMetaLight);
                        }
                        if (item.getType().equals(Material.IRON_SWORD)) {
                            ItemMeta ironMetaLight = item.getItemMeta();
                            event.getCurrentItem().setItemMeta(ironMetaLight);
                        }
                        if (item.getType().equals(Material.GOLDEN_SWORD)) {
                            ItemMeta goldenMetaLight = item.getItemMeta();
                            event.getCurrentItem().setItemMeta(goldenMetaLight);
                        }

                    }
                    if (data == 11) {
                        if (item.getType().equals(Material.IRON_SWORD)) {
                            ItemMeta copperMeta = item.getItemMeta();
                            event.getCurrentItem().setItemMeta(copperMeta);
                        }

                    }
                    if (data == 12) {
                        if (item.getType().equals(Material.IRON_SWORD)) {
                            ItemMeta copperMetaLight = item.getItemMeta();
                            event.getCurrentItem().setItemMeta(copperMetaLight);
                        }

                    }
                }
            }
        }
    }
}
