package me.greefox.greefox.me.Greefox.Commands;

import me.greefox.greefox.me.Greefox.Katanas;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.*;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Give implements CommandExecutor, TabCompleter {
    private static final String[] ARGS = {"copper_katana", "diamond_katana", "golden_katana", "iron_katana", "netherite_katana", "stone_katana", "wooden_katana" ,"light_copper_katana", "light_diamond_katana", "light_golden_katana", "light_iron_katana", "light_netherite_katana", "light_stone_katana", "light_wooden_katana"};
    Katanas plugin;

    public Give(Katanas plugin) {
        this.plugin = plugin;
    }
    private void addItemToInventory(Player player, ItemStack item) {
        player.getInventory().addItem(item);
    }
    private void dropItem(Player player, ItemStack itemStack) {
        player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("givekatana")) {
            if (args.length == 1) {
                if (sender instanceof BlockCommandSender) {
                    Location loc = ((BlockCommandSender) sender).getBlock().getLocation();
                    Entity closestEntity = null;
                    double lowestDistSoFar = Double.MAX_VALUE;
                    for (Entity entity : loc.getWorld().getNearbyEntities(loc, 100, 100, 100)) {
                        if (entity instanceof Player) {
                            double distance = entity.getLocation().distance(loc);
                            if (distance < lowestDistSoFar) {
                                lowestDistSoFar = distance;
                                closestEntity = entity;

                            }
                        }
                    }
                    if (closestEntity != null) {
                        switch (args[0]){
                            case "copper_katana": addItemToInventory((Player) closestEntity, Copper.copperKatana); break;
                            case "diamond_katana": addItemToInventory((Player) closestEntity, Diamond.diamondKatana); break;
                            case "golden_katana": addItemToInventory((Player) closestEntity, Gold.goldKatana); break;
                            case "iron_katana": addItemToInventory((Player) closestEntity, Iron.ironKatana); break;
                            case "netherite_katana": addItemToInventory((Player) closestEntity, Netherite.netheriteKatana); break;
                            case "stone_katana": addItemToInventory((Player) closestEntity, Stone.stoneKatana); break;
                            case "wooden_katana": addItemToInventory((Player) closestEntity, Wooden.woodenKatana); break;

                            case "light_copper_katana": addItemToInventory((Player) closestEntity, CopperLight.lightCopperKatana); break;
                            case "light_diamond_katana": addItemToInventory((Player) closestEntity, DiamondLight.lightDiamondKatana); break;
                            case "light_golden_katana": addItemToInventory((Player) closestEntity, GoldLight.lightGoldKatana); break;
                            case "light_iron_katana": addItemToInventory((Player) closestEntity, IronLight.lightIronKatana); break;
                            case "light_netherite_katana": addItemToInventory((Player) closestEntity, NetheriteLight.lightNetheriteKatana); break;
                            case "light_stone_katana": addItemToInventory((Player) closestEntity, StoneLight.lightStoneKatana); break;
                            case "light_wooden_katana": addItemToInventory((Player) closestEntity, WoodenLight.lightWoodenKatana); break;
                        }

                    }
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.isOp()) {
                        sender.sendMessage("Gave 1 [" + args[0] + "] to player " + sender.getName());
                        switch (args[0]){
                            case "copper_katana": addItemToInventory(player, Copper.copperKatana); break;
                            case "diamond_katana": addItemToInventory(player, Diamond.diamondKatana); break;
                            case "golden_katana": addItemToInventory(player, Gold.goldKatana); break;
                            case "iron_katana": addItemToInventory(player, Iron.ironKatana); break;
                            case "netherite_katana": addItemToInventory(player, Netherite.netheriteKatana); break;
                            case "stone_katana": addItemToInventory(player, Stone.stoneKatana); break;
                            case "wooden_katana": addItemToInventory(player, Wooden.woodenKatana); break;

                            case "light_copper_katana": addItemToInventory(player, CopperLight.lightCopperKatana); break;
                            case "light_diamond_katana": addItemToInventory(player, DiamondLight.lightDiamondKatana); break;
                            case "light_golden_katana": addItemToInventory(player, GoldLight.lightGoldKatana); break;
                            case "light_iron_katana": addItemToInventory(player, IronLight.lightIronKatana); break;
                            case "light_netherite": addItemToInventory(player, NetheriteLight.lightNetheriteKatana); break;
                            case "light_stone_katana": addItemToInventory(player, StoneLight.lightStoneKatana); break;
                            case "light_wooden_katana": addItemToInventory(player, WoodenLight.lightWoodenKatana); break;

                        }
                    } else sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                }
            } else if (args.length == 2) {
                String playerName = args[1];
                Player chosenPlayer = Bukkit.getPlayer(playerName);
                assert chosenPlayer != null;
                if (Arrays.toString(Bukkit.getOnlinePlayers().toArray()).contains(playerName)) {
                    if (sender instanceof Player || sender instanceof BlockCommandSender) {
                        if (sender.isOp()) {
                            sender.sendMessage("Gave 1 [" + args[0] + "] to player " + args[1]);
                            if (!(chosenPlayer.getInventory().firstEmpty() == -1)) {
                                switch (args[0]){
                                    case "copper_katana": addItemToInventory(chosenPlayer, Copper.copperKatana); break;
                                    case "diamond_katana": addItemToInventory(chosenPlayer, Diamond.diamondKatana); break;
                                    case "golden_katana": addItemToInventory(chosenPlayer, Gold.goldKatana); break;
                                    case "iron_katana": addItemToInventory(chosenPlayer, Iron.ironKatana); break;
                                    case "netherite_katana": addItemToInventory(chosenPlayer, Netherite.netheriteKatana); break;
                                    case "stone_katana": addItemToInventory(chosenPlayer, Stone.stoneKatana); break;
                                    case "wooden_katana": addItemToInventory(chosenPlayer, Wooden.woodenKatana); break;

                                    case "light_copper_katana": addItemToInventory(chosenPlayer, CopperLight.lightCopperKatana); break;
                                    case "light_diamond_katana": addItemToInventory(chosenPlayer, DiamondLight.lightDiamondKatana); break;
                                    case "light_golden_katana": addItemToInventory(chosenPlayer, GoldLight.lightGoldKatana); break;
                                    case "light_iron_katana": addItemToInventory(chosenPlayer, IronLight.lightIronKatana); break;
                                    case "light_netherite": addItemToInventory(chosenPlayer, NetheriteLight.lightNetheriteKatana); break;
                                    case "light_stone_katana": addItemToInventory(chosenPlayer, StoneLight.lightStoneKatana); break;
                                    case "light_wooden_katana": addItemToInventory(chosenPlayer, WoodenLight.lightWoodenKatana); break;

                                }

                            } else if (chosenPlayer.getInventory().firstEmpty() == -1) {
                                switch (args[0]){
                                    case "copper_katana": dropItem(chosenPlayer, Copper.copperKatana); break;
                                    case "diamond_katana": dropItem(chosenPlayer, Diamond.diamondKatana); break;
                                    case "golden_katana": dropItem(chosenPlayer, Gold.goldKatana); break;
                                    case "iron_katana": dropItem(chosenPlayer, Iron.ironKatana); break;
                                    case "netherite_katana": dropItem(chosenPlayer, Netherite.netheriteKatana); break;
                                    case "stone_katana": dropItem(chosenPlayer, Stone.stoneKatana); break;
                                    case "wooden_katana": dropItem(chosenPlayer, Wooden.woodenKatana); break;

                                    case "light_copper_katana": dropItem(chosenPlayer, CopperLight.lightCopperKatana); break;
                                    case "light_diamond_katana": dropItem(chosenPlayer, DiamondLight.lightDiamondKatana); break;
                                    case "light_golden_katana": dropItem(chosenPlayer, GoldLight.lightGoldKatana); break;
                                    case "light_iron_katana": dropItem(chosenPlayer, IronLight.lightIronKatana); break;
                                    case "light_netherite": dropItem(chosenPlayer, NetheriteLight.lightNetheriteKatana); break;
                                    case "light_stone_katana": dropItem(chosenPlayer, StoneLight.lightStoneKatana); break;
                                    case "light_wooden_katana": dropItem(chosenPlayer, WoodenLight.lightWoodenKatana); break;
                                }
                            }
                        } else sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                    } else if (sender instanceof ConsoleCommandSender) {
                        sender.sendMessage("Player only command!");
                    }
                } else if (!(args[1].equals("@a"))) {
                    sender.sendMessage(ChatColor.RED + "Unable to find player " + args[1]);
                }
                if ((sender instanceof Player || sender instanceof BlockCommandSender) && args[1].equalsIgnoreCase("@a")) {
                    if (sender.isOp()) {
                        sender.sendMessage("Gave [" + args[0] + "] to all players.");
                        for (Player allOnlinePlayers : Bukkit.getOnlinePlayers()) {
                            if (!(allOnlinePlayers.getInventory().firstEmpty() == -1)) {
                                switch (args[0]){
                                    case "copper_katana": addItemToInventory(allOnlinePlayers, Copper.copperKatana); break;
                                    case "diamond_katana": addItemToInventory(allOnlinePlayers, Diamond.diamondKatana); break;
                                    case "golden_katana": addItemToInventory(allOnlinePlayers, Gold.goldKatana); break;
                                    case "iron_katana": addItemToInventory(allOnlinePlayers, Iron.ironKatana); break;
                                    case "netherite_katana": addItemToInventory(allOnlinePlayers, Netherite.netheriteKatana); break;
                                    case "stone_katana": addItemToInventory(allOnlinePlayers, Stone.stoneKatana); break;
                                    case "wooden_katana": addItemToInventory(allOnlinePlayers, Wooden.woodenKatana); break;

                                    case "light_copper_katana": addItemToInventory(allOnlinePlayers, CopperLight.lightCopperKatana); break;
                                    case "light_diamond_katana": addItemToInventory(allOnlinePlayers, DiamondLight.lightDiamondKatana); break;
                                    case "light_golden_katana": addItemToInventory(allOnlinePlayers, GoldLight.lightGoldKatana); break;
                                    case "light_iron_katana": addItemToInventory(allOnlinePlayers, IronLight.lightIronKatana); break;
                                    case "light_netherite": addItemToInventory(allOnlinePlayers, NetheriteLight.lightNetheriteKatana); break;
                                    case "light_stone_katana": addItemToInventory(allOnlinePlayers, StoneLight.lightStoneKatana); break;
                                    case "light_wooden_katana": addItemToInventory(allOnlinePlayers, WoodenLight.lightWoodenKatana); break;
                                }
                            } else if (allOnlinePlayers.getInventory().firstEmpty() == -1) {
                                switch (args[0]){
                                    case "copper_katana": dropItem(allOnlinePlayers, Copper.copperKatana); break;
                                    case "diamond_katana": dropItem(allOnlinePlayers, Diamond.diamondKatana); break;
                                    case "golden_katana": dropItem(allOnlinePlayers, Gold.goldKatana); break;
                                    case "iron_katana": dropItem(allOnlinePlayers, Iron.ironKatana); break;
                                    case "netherite_katana": dropItem(allOnlinePlayers, Netherite.netheriteKatana); break;
                                    case "stone_katana": dropItem(allOnlinePlayers, Stone.stoneKatana); break;
                                    case "wooden_katana": dropItem(allOnlinePlayers, Wooden.woodenKatana); break;

                                    case "light_copper_katana": dropItem(allOnlinePlayers, CopperLight.lightCopperKatana); break;
                                    case "light_diamond_katana": dropItem(allOnlinePlayers, DiamondLight.lightDiamondKatana); break;
                                    case "light_golden_katana": dropItem(allOnlinePlayers, GoldLight.lightGoldKatana); break;
                                    case "light_iron_katana": dropItem(allOnlinePlayers, IronLight.lightIronKatana); break;
                                    case "light_netherite": dropItem(allOnlinePlayers, NetheriteLight.lightNetheriteKatana); break;
                                    case "light_stone_katana": dropItem(allOnlinePlayers, StoneLight.lightStoneKatana); break;
                                    case "light_wooden_katana": dropItem(allOnlinePlayers, WoodenLight.lightWoodenKatana); break;
                                }
                            }
                        }
                    } else sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                }
            }
        }
        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final List<String> katanas = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], Arrays.asList(ARGS), katanas);
        Collections.sort(katanas);
        if (args.length == 1) {
            return katanas;
        }

        final ArrayList<String> finalNames = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        names.add("@a");

        String[] ARGS1 = new String[names.size()];
        for (Player p : Bukkit.getOnlinePlayers()) {
            String name = p.getName();
            names.add(name);
        }
        ARGS1 = names.toArray(ARGS1);
        StringUtil.copyPartialMatches(args[1], Arrays.asList(ARGS1), finalNames);
        if (args.length == 2) {
            return finalNames;
        }
        return new ArrayList<>();
    }
}
