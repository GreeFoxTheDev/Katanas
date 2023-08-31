package me.greefox.greefox.me.Greefox.Commands;

import me.greefox.greefox.me.Greefox.Katanas;
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

public class Reload implements CommandExecutor, TabCompleter {

    Katanas plugin;

    public Reload(Katanas plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            if (sender.isOp()) {
                if (args.length == 0) {
                    if (label.equalsIgnoreCase("reloadkatanas")) {
                        sender.sendMessage(ChatColor.GREEN + "Katanas have been reloaded!");
                        // plugin.reloadConfig();
                        plugin.getPluginLoader().disablePlugin(plugin);
                        plugin.getPluginLoader().enablePlugin(plugin);
                    }
                }
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
