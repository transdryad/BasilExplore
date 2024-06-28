package io.github.transdryad.basilexplore;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BasilExplore extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        Logger log = Bukkit.getServer().getLogger();
        log.info("Enabling BasilExplore");
        this.saveDefaultConfig();
        FileConfiguration config = this.getConfig();
        getServer().getPluginManager().registerEvents(new BasilListener(), this);
        this.getCommand("home").setExecutor( new CommandHome());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
