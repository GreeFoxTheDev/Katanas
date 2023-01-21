package me.greefox.greefox.me.Greefox;

import org.bukkit.plugin.java.JavaPlugin;

public final class Katanas extends JavaPlugin {

    @Override
    public void onEnable() {
        Diamond.init();
        Gold.init();
        Iron.init();
        Copper.init();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
