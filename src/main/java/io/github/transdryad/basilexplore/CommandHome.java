package io.github.transdryad.basilexplore;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class CommandHome implements CommandExecutor {
    JavaPlugin plugin = BasilExplore.getPlugin(BasilExplore.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (label.equalsIgnoreCase("home")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    Location PlayerLocation = player.getLocation();
                    player.sendMessage("This plugin is running the config version " + plugin.getConfig().getString("config_version"));
                    if (args.length == 0) {
                        plugin.getLogger().log(Level.INFO,player.getName() + " ran /home from " + PlayerLocation.getBlockX() + ", " + PlayerLocation.getBlockY() + ", " + PlayerLocation.getBlockZ() + ".");
                    }
                    else if (args[0].equalsIgnoreCase("set")) {
                        plugin.getLogger().log(Level.INFO, player.getName() + " ran /home set from " + PlayerLocation.getBlockX() + ", " + PlayerLocation.getBlockY() + ", " + PlayerLocation.getBlockZ() + ".");
                    }

                    return true;
                }

            }
        return false;
    }


}
