package copper.items.items.copper.Items.Listeners;

import me.greefox.greefox.me.Greefox.Katanas;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRecipeDiscoverEvent;

import java.util.ArrayList;
import java.util.List;

public class DiscoverRecipe implements Listener {
    Katanas plugin;

    public DiscoverRecipe(Katanas plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void ItemPickup(PlayerRecipeDiscoverEvent e) {
        Player player = e.getPlayer();
        //copper
        if (e.getRecipe().equals(NamespacedKey.minecraft("lightning_rod"))) {

            List<NamespacedKey> copperKeys = new ArrayList<>();

            copperKeys.add(NamespacedKey.minecraft("copper_katana"));
            copperKeys.add(NamespacedKey.minecraft("copper_katana_light"));

            player.discoverRecipes(copperKeys);
        }
        //diamond
        if (e.getRecipe().equals(NamespacedKey.minecraft("diamond_sword"))) {

            List<NamespacedKey> diamondKeys = new ArrayList<>();

            diamondKeys.add(NamespacedKey.minecraft("diamond_katana"));
            diamondKeys.add(NamespacedKey.minecraft("diamond_katana_light"));

            player.discoverRecipes(diamondKeys);
        }
        //golden
        if (e.getRecipe().equals(NamespacedKey.minecraft("golden_sword"))) {

            List<NamespacedKey> goldenKeys = new ArrayList<>();

            goldenKeys.add(NamespacedKey.minecraft("golden_katana"));
            goldenKeys.add(NamespacedKey.minecraft("golden_katana_light"));

            player.discoverRecipes(goldenKeys);
        }
        //iron
        if (e.getRecipe().equals(NamespacedKey.minecraft("iron_sword"))) {

            List<NamespacedKey> ironKeys = new ArrayList<>();

            ironKeys.add(NamespacedKey.minecraft("iron_katana"));
            ironKeys.add(NamespacedKey.minecraft("iron_katana_light"));

            player.discoverRecipes(ironKeys);
        }
        //stone
        if (e.getRecipe().equals(NamespacedKey.minecraft("stone_sword"))) {

            List<NamespacedKey> stoneKeys = new ArrayList<>();

            stoneKeys.add(NamespacedKey.minecraft("stone_katana"));
            stoneKeys.add(NamespacedKey.minecraft("stone_katana2"));
            stoneKeys.add(NamespacedKey.minecraft("stone_katana_light"));
            stoneKeys.add(NamespacedKey.minecraft("stone_katana_light2"));

            player.discoverRecipes(stoneKeys);
        }
        //wooden
        if (e.getRecipe().equals(NamespacedKey.minecraft("wooden_sword"))) {

            List<NamespacedKey> woodKeys = new ArrayList<>();

            woodKeys.add(NamespacedKey.minecraft("wooden_katana"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana1"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana2"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana3"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana4"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana5"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana6"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana7"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana8"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana_light"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana_light1"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana_light2"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana_light3"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana_light4"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana_light5"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana_light6"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana_light7"));
            woodKeys.add(NamespacedKey.minecraft("wooden_katana_light8"));

            player.discoverRecipes(woodKeys);
        }
    }
}