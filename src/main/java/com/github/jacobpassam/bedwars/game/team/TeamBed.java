package com.github.jacobpassam.bedwars.game.team;

import lombok.Data;
import org.bukkit.Location;

@Data
public class TeamBed {

    private final Location location;
    private boolean destroyed = false;

}
