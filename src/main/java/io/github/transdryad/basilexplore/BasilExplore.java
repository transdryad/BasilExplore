package io.github.transdryad.basilexplore;

import org.bukkit.plugin.java.JavaPlugin;

public final class BasilExplore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BasilListener(), this);
        this.getCommand("kit").setExecutor( new CommandKit());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
