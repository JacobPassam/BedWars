package com.github.jacobpassam.bedwars.game.upgrades;

import com.github.jacobpassam.bedwars.game.team.GameTeam;
import org.bukkit.entity.Player;

public interface UpgradeLevel {

    void apply(Player purchased, GameTeam team);
    String getDescription();

}
