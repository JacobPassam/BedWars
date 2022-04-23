package com.github.jacobpassam.bedwars.game.player;

import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@Data
public class GamePlayer {

    private final UUID uuid;
    private final String name;

    private boolean left = false;

    public Player to() {
        return Bukkit.getPlayer(uuid);
    }

}
