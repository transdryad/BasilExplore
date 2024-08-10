package io.github.transdryad.basilexplore;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

import io.github.transdryad.basilexplore.Home;

public class CommandHome implements CommandExecutor {
    Home home = new Home();
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
                        try {
                            Location currentHome = home.loadHome(player);
                            player.teleport(currentHome);
                        } catch (Exception e) {
                            player.sendMessage("You have no home right now. Use /home set before trying again.");
                            plugin.getLogger().log(Level.INFO, player.getName() + " tried to use /home without a home.");
                        }
                    }
                    else if (args[0].equalsIgnoreCase("set")) {
                        plugin.getLogger().log(Level.INFO, player.getName() + " ran /home set from " + PlayerLocation.getBlockX() + ", " + PlayerLocation.getBlockY() + ", " + PlayerLocation.getBlockZ() + ".");
                        home.saveHome(PlayerLocation, player);
                    }
                    else if (args[0].equalsIgnoreCase("remove")) {
                        plugin.getLogger().log(Level.INFO, player.getName() + " ran /home remove.");
                        home.deleteHome(player);
                    }
                    return true;
                }
            }
        return false;
    }
}
