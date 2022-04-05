package com.github.jacobpassam.bedwars.game.player;

import lombok.Data;

import java.util.UUID;

@Data
public class GamePlayer {

    private final UUID uuid;
    private final String name;

    private boolean left;

}
