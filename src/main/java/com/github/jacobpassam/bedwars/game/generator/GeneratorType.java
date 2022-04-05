package com.github.jacobpassam.bedwars.game.generator;

import lombok.Getter;
import org.bukkit.Material;

@Getter
public enum GeneratorType {

    FORGE(Material.IRON_INGOT, Material.GOLD_INGOT),
    DIAMOND(Material.DIAMOND),
    EMERALD(Material.EMERALD);

    private final Material[] materials;

    GeneratorType(Material... materials) {
        this.materials = materials;
    }
}
