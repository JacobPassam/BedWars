package com.github.jacobpassam.bedwars.game.team;

import lombok.Getter;
import org.bukkit.ChatColor;

@Getter
public enum TeamColour {

    RED("Red", ChatColor.RED),
    BLUE("Blue", ChatColor.BLUE),
    GREEN("Green", ChatColor.GREEN),
    YELLOW("Yellow", ChatColor.YELLOW);

    private final String name;
    private final ChatColor color;

    TeamColour(String name, ChatColor color) {
        this.name = name;
        this.color = color;
    }
}
