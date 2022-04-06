package com.github.jacobpassam.bedwars.game.team;

import com.github.jacobpassam.bedwars.game.player.GamePlayer;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class GameTeam {

    private final String name;
    private final TeamColour colour;

    private final Set<GamePlayer> players = new HashSet<>();

    private final TeamBed bed;

}
