package me.greefox.greefox.me.Greefox.Listeners;

import me.greefox.greefox.me.Greefox.Katanas;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.greefox.greefox.me.Greefox.Inits.config;

public class ResourcepackChecker implements Listener {
    Katanas plugin;

    public ResourcepackChecker(Katanas plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (config.getBoolean("resource-pack.enable-resource-pack") == true) {
            if (config.getBoolean("resource-pack.use-legacy-resourcepack") == false) {
                if (!(Bukkit.getServer().getPluginManager().isPluginEnabled("EpicWeapons")) || (!(Bukkit.getServer().getPluginManager().isPluginEnabled("Copper Items")) || (!(Bukkit.getServer().getPluginManager().isPluginEnabled("Daggers"))))) {
                    event.getPlayer().setResourcePack("https://cdn.modrinth.com/data/TQ5na7TX/versions/noXg0lTi/MPR-BETA-2.0.zip");
                }
            }
            if (config.getBoolean("resource-pack.use-legacy-resourcepack") == true) {
                if (!(Bukkit.getServer().getPluginManager().isPluginEnabled("EpicWeapons")) || (!(Bukkit.getServer().getPluginManager().isPluginEnabled("Copper Items")) || (!(Bukkit.getServer().getPluginManager().isPluginEnabled("Daggers"))))) {
                    event.getPlayer().setResourcePack("https://cdn.modrinth.com/data/TQ5na7TX/versions/us0oWBPs/%5Blegacy%5D%20MPR-BETA-2.0.zip");
                }
            }
        }
    }
}