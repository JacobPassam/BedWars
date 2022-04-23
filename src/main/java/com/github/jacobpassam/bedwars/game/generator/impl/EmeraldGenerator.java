package com.github.jacobpassam.bedwars.game.generator.impl;

import com.github.jacobpassam.bedwars.game.generator.GeneratorConfiguration;
import com.github.jacobpassam.bedwars.game.generator.GeneratorType;
import org.bukkit.Material;

public class EmeraldGenerator implements GeneratorType {

    @Override
    public Material[] getMaterials() {
        return new Material[]{Material.EMERALD};
    }

    @Override
    public boolean isFancy() {
        return true;
    }

    @Override
    public GeneratorConfiguration[] getConfigurations() {
        return null;
    }
}
