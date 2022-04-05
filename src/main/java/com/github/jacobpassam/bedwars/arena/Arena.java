package com.github.jacobpassam.bedwars.arena;

import com.github.jacobpassam.bedwars.game.generator.GeneratorType;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class Arena {

    private final String name;

    private Map<GeneratorType, Location> generators;

    private int teamCount;
    private int maxPerTeam;

    public Arena(String name) {
        this.name = name;

        this.generators = new HashMap<>();
    }
}
