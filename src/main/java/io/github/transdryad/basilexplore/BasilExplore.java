package io.github.transdryad.basilexplore;

import org.bukkit.plugin.java.JavaPlugin;

public final class BasilExplore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BasilListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
