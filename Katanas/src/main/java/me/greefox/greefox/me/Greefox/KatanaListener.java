package me.greefox.greefox.me.Greefox;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class KatanaListener implements Listener {
    Katanas plugin;

    public KatanaListener(Katanas plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onApplyDiamond(@NotNull InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                if (event.getCurrentItem().getItemMeta().getLocalizedName().equals("diamond_katana")) {
                    ItemStack item = event.getCurrentItem();
                    ItemMeta im = item.getItemMeta();
                    List<String> lore = im.getLore();
                    if (item.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
                        int enchLevel = im.getEnchantLevel(Enchantment.DAMAGE_ALL);
                        int finalDamage = (int) (8.5 + enchLevel);
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
            }
        }
    }

    @EventHandler
    public void onApplyLightDiamond(@NotNull InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                if (event.getCurrentItem().getItemMeta() != null) {
                    if (event.getCurrentItem().getItemMeta().getLocalizedName().equals("light_diamond_katana")) {
                        ItemStack item = event.getCurrentItem();
                        ItemMeta im = item.getItemMeta();
                        List<String> lore = im.getLore();
                        if (item.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
                            int enchLevel = im.getEnchantLevel(Enchantment.DAMAGE_ALL);
                            int finalDamage = (int) (7.5 + enchLevel);
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
                }
            }
        }
    }

    @EventHandler
    public void onApplyIron(@NotNull InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                if (event.getCurrentItem().getItemMeta() != null) {
                    if (event.getCurrentItem().getItemMeta().getLocalizedName().equals("iron_katana")) {
                        ItemStack item = event.getCurrentItem();
                        ItemMeta im = item.getItemMeta();
                        List<String> lore = im.getLore();
                        if (item.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
                            int enchLevel = im.getEnchantLevel(Enchantment.DAMAGE_ALL);
                            int finalDamage = (7 + enchLevel);
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
                }
            }
        }
    }

    @EventHandler
    public void onApplyLightIron(@NotNull InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                if (event.getCurrentItem().getItemMeta() != null) {
                    if (event.getCurrentItem().getItemMeta().getLocalizedName().equals("light_iron_katana")) {
                        ItemStack item = event.getCurrentItem();
                        ItemMeta im = item.getItemMeta();
                        List<String> lore = im.getLore();
                        if (item.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
                            int enchLevel = im.getEnchantLevel(Enchantment.DAMAGE_ALL);
                            int finalDamage = (int) (6.5 + enchLevel);
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
                }
            }
        }
    }

    @EventHandler
    public void onApplyGold(@NotNull InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                if (event.getCurrentItem().getItemMeta() != null) {
                    if (event.getCurrentItem().getItemMeta().getLocalizedName().equals("gold_katana")) {
                        ItemStack item = event.getCurrentItem();
                        ItemMeta im = item.getItemMeta();
                        List<String> lore = im.getLore();
                        if (item.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
                            int enchLevel = im.getEnchantLevel(Enchantment.DAMAGE_ALL);
                            int finalDamage = (7 + enchLevel);
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
                }
            }
        }
    }

    @EventHandler
    public void onApplyLightGold(@NotNull InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                if (event.getCurrentItem().getItemMeta() != null) {
                    if (event.getCurrentItem().getItemMeta().getLocalizedName().equals("light_gold_katana")) {
                        ItemStack item = event.getCurrentItem();
                        ItemMeta im = item.getItemMeta();
                        List<String> lore = im.getLore();
                        if (item.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
                            int enchLevel = im.getEnchantLevel(Enchantment.DAMAGE_ALL);
                            int finalDamage = (7 + enchLevel);
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
                }
            }
        }
    }

    @EventHandler
    public void onApplyCopper(@NotNull InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                if (event.getCurrentItem().getItemMeta() != null) {
                    if (event.getCurrentItem().getItemMeta().getLocalizedName().equals("copper_katana")) {
                        ItemStack item = event.getCurrentItem();
                        ItemMeta im = item.getItemMeta();
                        List<String> lore = im.getLore();
                        if (item.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
                            int enchLevel = im.getEnchantLevel(Enchantment.DAMAGE_ALL);
                            int finalDamage = (8 + enchLevel);
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
                }
            }
        }
    }

    @EventHandler
    public void onApplyLightCopper(@NotNull InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                if (event.getCurrentItem().getItemMeta() != null) {
                    if (event.getCurrentItem().getItemMeta().getLocalizedName().equals("light_copper_katana")) {
                        ItemStack item = event.getCurrentItem();
                        ItemMeta im = item.getItemMeta();
                        List<String> lore = im.getLore();
                        if (item.getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)) {
                            int enchLevel = im.getEnchantLevel(Enchantment.DAMAGE_ALL);
                            int finalDamage = (7 + enchLevel);
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
                }
            }
        }
    }
}
