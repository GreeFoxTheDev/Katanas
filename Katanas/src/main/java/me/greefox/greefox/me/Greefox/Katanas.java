package me.greefox.greefox.me.Greefox;

import copper.items.items.copper.Items.Listeners.DiscoverRecipe;
import me.greefox.greefox.me.Greefox.Commands.Give;
import me.greefox.greefox.me.Greefox.Listeners.KatanaListener;
import me.greefox.greefox.me.Greefox.Listeners.KatanaListenerOld;
import me.greefox.greefox.me.Greefox.Listeners.ResourcepackChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

import static me.greefox.greefox.me.Greefox.Inits.config;


public final class Katanas extends JavaPlugin {
    private static FileConfiguration en_US;
    private static FileConfiguration UK;
    private static FileConfiguration GE;
    private static FileConfiguration ES;
    private static Katanas instance;
    //static FileConfiguration config = Katanas.getInstance().getConfig();
    private File en_US_file;
    private File UK_file;
    private File GE_file;
    private File ES_file;

    public static FileConfiguration get_en_US() {
        return en_US;
    }

    public static FileConfiguration getUK() {
        return UK;
    }

    public static FileConfiguration get_GE() {
        return GE;
    }

    public static FileConfiguration getES() {
        return ES;
    }

    public static Katanas getInstance() {
        return instance;
    }

    public static FileConfiguration getCurrentLang() {
        FileConfiguration en_US = get_en_US();
        FileConfiguration UK = getUK();
        FileConfiguration GE = get_GE();
        FileConfiguration ES = getES();
        if (config.getString("language").equalsIgnoreCase("en_US")) {
            return en_US;
        }
        if (config.getString("language").equalsIgnoreCase("UK")) {
            return UK;
        }
        if (config.getString("language").equalsIgnoreCase("GE")) {
            return GE;
        }
        if (config.getString("language").equalsIgnoreCase("ES")) {
            return ES;
        } else return en_US;
    }

    private void create_en_US() {
        en_US_file = new File(getDataFolder(), "languages/en_US.yml");
        if (!en_US_file.exists()) {
            en_US_file.getParentFile().mkdirs();
            saveResource("languages/en_US.yml", false);
        }

        en_US = new YamlConfiguration();
        try {
            en_US.load(en_US_file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createUK() {
        UK_file = new File(getDataFolder(), "languages/UK.yml");
        if (!UK_file.exists()) {
            UK_file.getParentFile().mkdirs();
            saveResource("languages/UK.yml", false);
        }

        UK = new YamlConfiguration();
        try {
            UK.load(UK_file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createGE() {
        GE_file = new File(getDataFolder(), "languages/GE.yml");
        if (!GE_file.exists()) {
            GE_file.getParentFile().mkdirs();
            saveResource("languages/GE.yml", false);
        }

        GE = new YamlConfiguration();
        try {
            GE.load(GE_file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createES() {
        ES_file = new File(getDataFolder(), "languages/ES.yml");
        if (!ES_file.exists()) {
            ES_file.getParentFile().mkdirs();
            saveResource("languages/ES.yml", false);
        }

        ES = new YamlConfiguration();
        try {
            ES.load(ES_file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEnable() {
        instance = this;
        config = getConfig();
        create_en_US();
        createUK();
        createGE();
        createES();
        reloadConfig();
        saveDefaultConfig();


        Inits.init();
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.AQUA + "**********************************");
        console.sendMessage(ChatColor.AQUA + "| Katanas 2.0 have been enabled! |");
        console.sendMessage(ChatColor.AQUA + "**********************************");
        this.getCommand("givekatana").setExecutor(new Give(this));
        this.getCommand("givekatana").setTabCompleter(new Give(this));
        this.getCommand("katanas").setExecutor(new me.greefox.greefox.me.Greefox.Commands.Katanas(this));
        this.getCommand("katanas").setTabCompleter(new me.greefox.greefox.me.Greefox.Commands.Katanas(this));
        getServer().getPluginManager().registerEvents(new DiscoverRecipe(this), this);
        getServer().getPluginManager().registerEvents(new KatanaListener(this), this);
        getServer().getPluginManager().registerEvents(new ResourcepackChecker(this), this);
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.DARK_RED + "***********************************");
        console.sendMessage(ChatColor.DARK_RED + "| Katanas 2.0 have been disabled! |");
        console.sendMessage(ChatColor.DARK_RED + "***********************************");
    }
}
