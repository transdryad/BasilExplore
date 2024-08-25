package io.github.transdryad.basilexplore;

import org.ajbrown.namemachine.NameGenerator;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class BasilListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        PlayerDeath.playerDeath(event);
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.VILLAGER) {
            Villagers.nameVillager(event.getEntity());
        }
    }
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntityType() == EntityType.VILLAGER) {
            Villagers.villagerDeath(event.getEntity());
        }
    }
    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {

    }
}
