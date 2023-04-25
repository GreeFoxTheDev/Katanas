package me.greefox.greefox.me.Greefox;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Katanas extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getLogger().info("§eKatanas " + "§7plugin has been enabled!");
        Diamond.init();
        Gold.init();
        Iron.init();
        Copper.init();
        getServer().getPluginManager().registerEvents(new KatanaListener(this), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getLogger().info(ChatColor.YELLOW + "Katanas " + ChatColor.GRAY +"plugin has been " + ChatColor.DARK_RED + "DISABLED");
    }
}
