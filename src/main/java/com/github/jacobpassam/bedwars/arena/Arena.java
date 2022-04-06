package com.github.jacobpassam.bedwars.arena;

import com.github.jacobpassam.bedwars.game.generator.GeneratorType;
import com.github.jacobpassam.bedwars.game.team.TeamColour;
import lombok.Data;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

@Data
public class Arena {

    private final String name;

    private final Location waitingLobby;

    private final Map<GeneratorType, Location> generators;

    private final int teamCount;
    private final int maxPerTeam;

    private final Map<TeamColour, TeamLocationData> teamData;

}
