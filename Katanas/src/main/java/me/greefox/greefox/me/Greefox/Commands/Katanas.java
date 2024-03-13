package me.greefox.greefox.me.Greefox.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Katanas implements CommandExecutor, TabCompleter {
    me.greefox.greefox.me.Greefox.Katanas plugin;

    public Katanas(me.greefox.greefox.me.Greefox.Katanas plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            if (label.equalsIgnoreCase("katanas")) {
                if (sender.isOp()) {
                    sender.sendMessage(ChatColor.YELLOW + "Katanas by GreeFox");
                    sender.sendMessage("");
                    sender.sendMessage("Available commands:");
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "/givekatana <katana> <player>");
                    sender.sendMessage("    <player> is optional");
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "/katanas");
                    sender.sendMessage("Shows this menu!");
                } else sender.sendMessage(ChatColor.RED + "You don't have a permission to do that!");
            }
        }
        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length > 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }
}
