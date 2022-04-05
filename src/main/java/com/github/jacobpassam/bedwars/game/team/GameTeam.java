package com.github.jacobpassam.bedwars.game.team;

import com.github.jacobpassam.bedwars.game.player.GamePlayer;
import lombok.Data;
import org.bukkit.ChatColor;

@Data
public class GameTeam {

    private final String name;
    private final ChatColor color;

    private GamePlayer[] players;

    private final TeamBed bed;

}
