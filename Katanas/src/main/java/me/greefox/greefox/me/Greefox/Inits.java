package me.greefox.greefox.me.Greefox;

import me.greefox.greefox.me.Greefox.KatanasTypes.Light.*;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Inits extends JavaPlugin {
    public static FileConfiguration config = Katanas.getInstance().getConfig();
    public static void init(){
        if (config.getBoolean("katanas.copper.enable")){
            Copper.init();
        }
        if (config.getBoolean("katanas.diamond.enable")){
            Diamond.init();
        }
        if (config.getBoolean("katanas.golden.enable")){
            Gold.init();
        }
        if (config.getBoolean("katanas.iron.enable")){
            Iron.init();
        }
        if (config.getBoolean("katanas.netherite.enable")){
            Netherite.init();
        }
        if (config.getBoolean("katanas.stone.enable")){
            Stone.init();
        }
        if (config.getBoolean("katanas.wooden.enable")){
            Wooden.init();
        }
        if (config.getBoolean("light-katanas.copper.enable")){
            CopperLight.init();
        }
        if (config.getBoolean("light-katanas.diamond.enable")){
            DiamondLight.init();
        }
        if (config.getBoolean("light-katanas.golden.enable")){
            GoldLight.init();
        }
        if (config.getBoolean("light-katanas.iron.enable")) {
            IronLight.init();
        }
        if (config.getBoolean("light-katanas.netherite.enable")){
            NetheriteLight.init();
        }
        if (config.getBoolean("light-katanas.stone.enable")){
            StoneLight.init();
        }
        if (config.getBoolean("light-katanas.wooden.enable")){
            WoodenLight.init();
        }
    }
}
