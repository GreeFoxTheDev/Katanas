package me.greefox.greefox.me.Greefox;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Katanas extends JavaPlugin {

    @Override
    public void onEnable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.AQUA + "******************************");
        console.sendMessage(ChatColor.AQUA + "| Katanas have been enabled! |");
        console.sendMessage(ChatColor.AQUA + "******************************");
        Diamond.init();
        Gold.init();
        Iron.init();
        Copper.init();
        getServer().getPluginManager().registerEvents(new KatanaListener(this), this);
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.RED + "*******************************");
        console.sendMessage(ChatColor.RED + "| Katanas have been disabled! |");
        console.sendMessage(ChatColor.RED + "*******************************");
    }
}
