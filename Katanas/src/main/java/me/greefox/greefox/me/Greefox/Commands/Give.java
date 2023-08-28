package me.greefox.greefox.me.Greefox.Commands;

import me.greefox.greefox.me.Greefox.Katanas;
import me.greefox.greefox.me.Greefox.KatanasTypes.Copper;
import me.greefox.greefox.me.Greefox.KatanasTypes.Diamond;
import me.greefox.greefox.me.Greefox.KatanasTypes.Gold;
import me.greefox.greefox.me.Greefox.KatanasTypes.Iron;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Give implements CommandExecutor, TabCompleter {
    private static final String[] ARGS = {"copper_katana", "diamond_katana", "golden_katana", "iron_katana", "light_copper_katana", "light_diamond_katana", "light_golden_katana", "light_iron_katana"};
    private static final String[] ARGS1 = {Arrays.toString(Bukkit.getServer().getOnlinePlayers().toArray())};
    Katanas plugin;

    public Give(Katanas plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
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
                        if (args[0].equalsIgnoreCase("copper_katana")) {
                            ((Player) closestEntity).getInventory().addItem(Copper.copperKatana);
                        }
                        if (args[0].equalsIgnoreCase("iron_katana")) {
                            ((Player) closestEntity).getInventory().addItem(Iron.ironKatana);
                        }
                        if (args[0].equalsIgnoreCase("diamond_katana")) {
                            ((Player) closestEntity).getInventory().addItem(Diamond.diamondKatana);
                        }
                        if (args[0].equalsIgnoreCase("golden_katana")) {
                            ((Player) closestEntity).getInventory().addItem(Gold.goldKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_copper_katana")) {
                            ((Player) closestEntity).getInventory().addItem(Copper.lightCopperKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_iron_katana")) {
                            ((Player) closestEntity).getInventory().addItem(Iron.lightIronKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                            ((Player) closestEntity).getInventory().addItem(Diamond.lightDiamondKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_golden_katana")) {
                            ((Player) closestEntity).getInventory().addItem(Gold.lightGoldKatana);
                        }
                    }
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.isOp()) {
                        if (args[0].equalsIgnoreCase("copper_katana")) {
                            player.getInventory().addItem(Copper.copperKatana);
                        }
                        if (args[0].equalsIgnoreCase("iron_katana")) {
                            player.getInventory().addItem(Iron.ironKatana);
                        }
                        if (args[0].equalsIgnoreCase("diamond_katana")) {
                            player.getInventory().addItem(Diamond.diamondKatana);
                        }
                        if (args[0].equalsIgnoreCase("golden_katana")) {
                            player.getInventory().addItem(Gold.goldKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_copper_katana")) {
                            player.getInventory().addItem(Copper.lightCopperKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_iron_katana")) {
                            player.getInventory().addItem(Iron.lightIronKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                            player.getInventory().addItem(Diamond.lightDiamondKatana);
                        }
                    }
                }
            } else if (args.length == 2) {
                String playerName = args[1];
                Player chosenPlayer = Bukkit.getPlayer(playerName);
                assert chosenPlayer != null;
                if (Arrays.toString(Bukkit.getOnlinePlayers().toArray()).contains(playerName)) {
                    if (sender instanceof Player) {
                        if (args[0].equalsIgnoreCase("copper_katana")) {
                            chosenPlayer.getInventory().addItem(Copper.copperKatana);
                        }
                        if (args[0].equalsIgnoreCase("iron_katana")) {
                            chosenPlayer.getInventory().addItem(Iron.ironKatana);
                        }
                        if (args[0].equalsIgnoreCase("diamond_katana")) {
                            chosenPlayer.getInventory().addItem(Diamond.diamondKatana);
                        }
                        if (args[0].equalsIgnoreCase("golden_katana")) {
                            chosenPlayer.getInventory().addItem(Gold.goldKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_copper_katana")) {
                            chosenPlayer.getInventory().addItem(Copper.lightCopperKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_iron_katana")) {
                            chosenPlayer.getInventory().addItem(Iron.lightIronKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                            chosenPlayer.getInventory().addItem(Diamond.lightDiamondKatana);
                        }
                        sender.sendMessage("Gave 1 [" + args[0] + "] to player " + args[1]);
                    }
                } else if (sender instanceof Player){
                    sender.sendMessage(ChatColor.RED + "Unable to find player " + args[1]);
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
        //final List<String> players = new ArrayList<>();
        //StringUtil.copyPartialMatches(args[1], Arrays.asList(ARGS1), players);
        //Collections.sort(players);
        final ArrayList<String> names = new ArrayList<>();
        Collections.sort(names);
        for (Player p : Bukkit.getOnlinePlayers()) {
            String name = p.getName();
            names.add(name);
        }
        if (args.length == 2) {
            return names;
        }
        return new ArrayList<>();
    }
}
