package io.github.transdryad.basilexplore;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;

public class Home {
    JavaPlugin plugin = BasilExplore.getPlugin(BasilExplore.class);

    public boolean saveHome(Location home, Player player) {
        try {
            BukkitObjectOutputStream out = new BukkitObjectOutputStream(new FileOutputStream(player.getName() + ".home"));
            out.writeObject(home);
            out.close();
            plugin.getLogger().log(Level.INFO, "A home was saved to the filesystem");
            return true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    public Location loadHome(Player player) {
        try {
            BukkitObjectInputStream in = new BukkitObjectInputStream(new FileInputStream(player.getName() + ".home"));
            Location home = (Location) in.readObject();
            in.close();
            return home;
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public void deleteHome(Player player) {
        File t = new File(".");
        String rootPath = t.getAbsolutePath();
        t.delete();
        String path = rootPath + "/" + player.getName() + ".home";
        File file = new File(path);
        file.delete();
        plugin.getLogger().log(Level.INFO, path + " deleted.");
    }
}
