package com.github.jacobpassam.bedwars.game.generator;

import org.bukkit.Material;

public interface GeneratorType {

    Material[] getMaterials();

    boolean isFancy();
    GeneratorConfiguration[] getConfigurations();

}
