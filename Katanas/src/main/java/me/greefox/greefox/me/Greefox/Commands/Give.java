package me.greefox.greefox.me.Greefox.Commands;

import me.greefox.greefox.me.Greefox.Katanas;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.CopperLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.DiamondLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.GoldLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.IronLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Copper;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Diamond;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Gold;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Iron;
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
    Katanas plugin;

    public Give(Katanas plugin) {
        this.plugin = plugin;
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
                            ((Player) closestEntity).getInventory().addItem(CopperLight.lightCopperKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_iron_katana")) {
                            ((Player) closestEntity).getInventory().addItem(IronLight.lightIronKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                            ((Player) closestEntity).getInventory().addItem(DiamondLight.lightDiamondKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_golden_katana")) {
                            ((Player) closestEntity).getInventory().addItem(GoldLight.lightGoldKatana);
                        }
                    }
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.isOp()) {
                        sender.sendMessage("Gave 1 [" + args[0] + "] to player " + sender.getName());
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
                            player.getInventory().addItem(CopperLight.lightCopperKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_iron_katana")) {
                            player.getInventory().addItem(IronLight.lightIronKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                            player.getInventory().addItem(DiamondLight.lightDiamondKatana);
                        }
                        if (args[0].equalsIgnoreCase("light_golden_katana")) {
                            player.getInventory().addItem(GoldLight.lightGoldKatana);
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
                                    chosenPlayer.getInventory().addItem(CopperLight.lightCopperKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_iron_katana")) {
                                    chosenPlayer.getInventory().addItem(IronLight.lightIronKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_golden_katana")) {
                                    chosenPlayer.getInventory().addItem(GoldLight.lightGoldKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                                    chosenPlayer.getInventory().addItem(DiamondLight.lightDiamondKatana);
                                }

                            } else if (chosenPlayer.getInventory().firstEmpty() == -1) {
                                if (args[0].equalsIgnoreCase("copper_katana")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Copper.copperKatana);
                                }
                                if (args[0].equalsIgnoreCase("iron_katana")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Iron.ironKatana);
                                }
                                if (args[0].equalsIgnoreCase("diamond_katana")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Diamond.diamondKatana);
                                }
                                if (args[0].equalsIgnoreCase("golden_katana")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), Gold.goldKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_copper_katana")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), CopperLight.lightCopperKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_iron_katana")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), IronLight.lightIronKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_golden_katana")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), GoldLight.lightGoldKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(), DiamondLight.lightDiamondKatana);
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
                                if (args[0].equalsIgnoreCase("copper_katana")) {
                                    allOnlinePlayers.getInventory().addItem(Copper.copperKatana);
                                }
                                if (args[0].equalsIgnoreCase("iron_katana")) {
                                    allOnlinePlayers.getInventory().addItem(Iron.ironKatana);
                                }
                                if (args[0].equalsIgnoreCase("diamond_katana")) {
                                    allOnlinePlayers.getInventory().addItem(Diamond.diamondKatana);
                                }
                                if (args[0].equalsIgnoreCase("golden_katana")) {
                                    allOnlinePlayers.getInventory().addItem(Gold.goldKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_copper_katana")) {
                                    allOnlinePlayers.getInventory().addItem(CopperLight.lightCopperKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_golden_katana")) {
                                    allOnlinePlayers.getInventory().addItem(GoldLight.lightGoldKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_iron_katana")) {
                                    allOnlinePlayers.getInventory().addItem(IronLight.lightIronKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                                    allOnlinePlayers.getInventory().addItem(DiamondLight.lightDiamondKatana);
                                }
                            } else if (allOnlinePlayers.getInventory().firstEmpty() == -1) {

                                if (args[0].equalsIgnoreCase("copper_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), (Copper.copperKatana));
                                }
                                if (args[0].equalsIgnoreCase("iron_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), (Iron.ironKatana));
                                }
                                if (args[0].equalsIgnoreCase("diamond_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), (Diamond.diamondKatana));
                                }
                                if (args[0].equalsIgnoreCase("golden_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), (Gold.goldKatana));
                                }
                                if (args[0].equalsIgnoreCase("golden_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), GoldLight.lightGoldKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_copper_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), CopperLight.lightCopperKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_iron_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), IronLight.lightIronKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), DiamondLight.lightDiamondKatana);
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
