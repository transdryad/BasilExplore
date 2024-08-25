package io.github.transdryad.basilexplore;

import net.citizensnpcs.api.CitizensAPI;


import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCSelector;
import net.citizensnpcs.trait.SkinTrait;
import org.ajbrown.namemachine.Name;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.List;

import static io.github.transdryad.basilexplore.Villagers.generator;

public class BasilWarrior {
    public boolean spawnWarrior(Location spawnLocation) {
        List<Name> names = generator.generateNames( 1 );
        NPC warrior = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, names.getFirst().getFirstName() + " " + names.getFirst().getLastName());
        String texture = "eyJ0aW1lc3RhbXAiOjE1ODU1OTQ2ODc4OTIsInByb2ZpbGVJZCI6Ijc1MTQ0NDgxOTFlNjQ1NDY4Yzk3MzlhNmUzOTU3YmViIiwicHJvZmlsZU5hbWUiOiJUaGFua3NNb2phbmciLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzQxYjhkYmFkYTg5ZjBlYzQ2NDNiMDU5MWJjODk0ZGJiOTM1Y2YwYzEyZTM0YzY1MDFjMjg4OGRhMzdhYzNiNzcifX19";
        String signature = "fYqk0syOHR9iUPnrkdowhEpHH1xXfEy0PaWyhEMMvA35xeTM9ujwbko3buWVMh0Zh0LnS3Lb2T1OAlyW9UTem4TlkvAtGWT4u/RzIYF90Ymz8NbGkqQLu5kFJDE2wdu0rbm1/nqO3r+vcLmpccrUuXVV5jLhmMBEs7Ah7X3HLdyWpDiERVPdLXYSH2kQ9YBFrinYE4oZIeFhBD5cbpPO4xnkOxdeOVaXdnRNwZ7sLaKgQpg8P4p36kyRfgt9M7wsoYHFWOHcrdoKi1JBZlnh2wC6IHcxQjJIIEloZQUFU+EbnvEVlaQlvO8HKSE37fSXK1NLfAopmGgpNoJJuUiVuIALjRHnekz9j5WT4cT6ALM7fM5niNG6QDg5UbPzUDi9h2aRRuj/mzpb7ok9qzuQhSgR+yOeEpQa2e1w5ram43axmPJo01EJQGdk8UJBdkd4ZMrsrlBOVgK7LtbXC3xtkSe5V4lSTUsc6lBx3630g2kz8FgTJauWSqghqH78Qp0GOfvDczgSlCzHFuOMfXjqE2eJtOfOe3W8bMdoSroebnDHlzlKVuOUTF1t9/tRtgndVLPYoPHuCD1mtlNQNINcM0YAWC3OTotMVT2mt22W0N72H2epe+xQBYXEpM3AJVFDLEx8o9xvYeuV5U0Cuy4oWdhEs6cXCPvk8Sh5yt+t0MQ=;";
        warrior.getOrAddTrait(SkinTrait.class).setSkinPersistent("WarriorSkin", signature, texture);
        return warrior.spawn(spawnLocation);
    }

}