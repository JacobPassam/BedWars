package com.github.jacobpassam.bedwars.game.generator.impl;

import com.github.jacobpassam.bedwars.game.generator.GeneratorConfiguration;
import com.github.jacobpassam.bedwars.game.generator.GeneratorType;
import org.bukkit.Material;

public class DiamondGenerator implements GeneratorType {

    @Override
    public Material[] getMaterials() {
        return new Material[]{Material.DIAMOND};
    }

    @Override
    public GeneratorConfiguration[] getConfigurations() {
        return null;
    }
}
