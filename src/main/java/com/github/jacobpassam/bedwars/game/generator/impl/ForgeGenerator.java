package com.github.jacobpassam.bedwars.game.generator.impl;

import com.github.jacobpassam.bedwars.game.generator.GeneratorConfiguration;
import com.github.jacobpassam.bedwars.game.generator.GeneratorType;
import org.bukkit.Material;

public class ForgeGenerator implements GeneratorType {

    @Override
    public Material[] getMaterials() {
        return new Material[]{Material.IRON_INGOT, Material.GOLD_INGOT};
    }

    @Override
    public boolean isFancy() {
        return false;
    }

    @Override
    public GeneratorConfiguration[] getConfigurations() {
        return null;
    }
}
