package com.github.jacobpassam.bedwars.game.generator;

import lombok.Data;
import org.bukkit.Location;

@Data
public class Generator {

    private final GeneratorType type;
    private final Location location;

    private int level;

    private final GeneratorConfiguration[] configurations;

    private final boolean fancy;

}
