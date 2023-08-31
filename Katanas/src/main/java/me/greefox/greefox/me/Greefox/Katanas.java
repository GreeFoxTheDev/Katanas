package me.greefox.greefox.me.Greefox;

import me.greefox.greefox.me.Greefox.Commands.Give;
import me.greefox.greefox.me.Greefox.Commands.Reload;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.CopperLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.DiamondLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.GoldLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.IronLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Copper;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Diamond;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Gold;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Iron;
import me.greefox.greefox.me.Greefox.Listeners.KatanaListener;
import me.greefox.greefox.me.Greefox.Listeners.ResourcepackChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Katanas extends JavaPlugin {
    @Override
    public void onEnable() {
        reloadConfig();

        FileConfiguration config = this.getConfig();

        config.addDefault("katanas.enable-copper-katana", true);
        config.addDefault("katanas.enable-diamond-katana", true);
        config.addDefault("katanas.enable-golden-katana", true);
        config.addDefault("katanas.enable-iron-katana", true);
        config.addDefault("light-katanas.enable-light-copper-katana", true);
        config.addDefault("light-katanas.enable-light-diamond-katana", true);
        config.addDefault("light-katanas.enable-light-golden-katana", true);
        config.addDefault("light-katanas.enable-light-iron-katana", true);
        saveDefaultConfig();
        if (config.getBoolean("katanas.enable-copper-katana")) {
            Copper.init();
        }
        if (config.getBoolean("katanas.enable-diamond-katana")) {
            Diamond.init();
        }
        if (config.getBoolean("katanas.enable-golden-katana")) {
            Gold.init();
        }
        if (config.getBoolean("katanas.enable-iron-katana")) {
            Iron.init();
        }
        if (config.getBoolean("light-katanas.enable-light-copper-katana")) {
            CopperLight.init();
        }
        if (config.getBoolean("light-katanas.enable-light-diamond-katana")) {
            DiamondLight.init();
        }
        if (config.getBoolean("light-katanas.enable-light-golden-katana")) {
            GoldLight.init();
        }
        if (config.getBoolean("light-katanas.enable-light-iron-katana")) {
            IronLight.init();
        }
        config.options().copyDefaults(true);
        saveConfig();

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.AQUA + "******************************");
        console.sendMessage(ChatColor.AQUA + "| Katanas have been enabled! |");
        console.sendMessage(ChatColor.AQUA + "******************************");
        this.getCommand("givekatana").setExecutor(new Give(this));
        this.getCommand("givekatana").setTabCompleter(new Give(this));
        this.getCommand("katanas").setExecutor(new me.greefox.greefox.me.Greefox.Commands.Katanas(this));
        this.getCommand("katanas").setTabCompleter(new me.greefox.greefox.me.Greefox.Commands.Katanas(this));
        // this.getCommand("reloadkatanas").setExecutor(new Reload(this));
        // this.getCommand("reloadkatanas").setTabCompleter(new Reload(this));
        getServer().getPluginManager().registerEvents(new KatanaListener(this), this);
        getServer().getPluginManager().registerEvents(new ResourcepackChecker(this), this);
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.DARK_RED + "*******************************");
        console.sendMessage(ChatColor.DARK_RED + "| Katanas have been disabled! |");
        console.sendMessage(ChatColor.DARK_RED + "*******************************");
    }
}
