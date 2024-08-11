package io.github.transdryad.basilexplore;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class PlayerDeath {

    static JavaPlugin plugin = BasilExplore.getPlugin(BasilExplore.class);

    public static void playerDeath(PlayerDeathEvent event) {
        Player deadPlayer = event.getPlayer();
        event.setKeepInventory(false);
        int x = deadPlayer.getLocation().getBlockX();
        int y = deadPlayer.getLocation().getBlockY();
        int z = deadPlayer.getLocation().getBlockZ();
        deadPlayer.sendMessage("You died at: " + x + ", " + y + ", " + z + ".");
        plugin.getLogger().log(Level.INFO, deadPlayer.getName() + " died at: " + x + ", " + y + ", " + z + ".");
    }
}
