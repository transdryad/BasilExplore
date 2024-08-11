package io.github.transdryad.basilexplore;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Level;

public class Villagers {

    static JavaPlugin plugin = BasilExplore.getPlugin(BasilExplore.class);

    static NameGenerator generator = new NameGenerator();

    public static void nameVillager(Entity entity) {
        List<Name> names = generator.generateNames( 1 );
        TextComponent textComponent = Component.text(names.getFirst().getFirstName() + " " + names.getFirst().getLastName());
        entity.customName(textComponent);
        //plugin.getLogger().log(Level.INFO, "Villager Spawned.");
    }

    public static void villagerDeath(Entity entity) {
        Component deadName = entity.name();
        TextComponent deathMessage = Component.text("The villager ").append(deadName).append(Component.text(" has just died."));
        Bukkit.broadcast(deathMessage);
    }
}
