package io.github.transdryad.basilexplore;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class BasilExplore extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();
        this.getLogger().log(Level.INFO, "Enabling BasilExplore.");
        this.saveDefaultConfig();
        getLogger().log(Level.INFO, "Logging in a different way.");
        getServer().getPluginManager().registerEvents(new BasilListener(), this);
        this.getCommand("home").setExecutor( new CommandHome());
        this.getCommand("warrior").setExecutor( new CommandWarrior());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
    }
}
