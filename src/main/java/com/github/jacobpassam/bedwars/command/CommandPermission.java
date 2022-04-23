package com.github.jacobpassam.bedwars.command;

import lombok.Data;

@Data
public class CommandPermission {

    private final String permission;
    private final boolean op;

    public static CommandPermission from(String s) {
        return new CommandPermission(s, false);
    }

    public static CommandPermission op() {
        return new CommandPermission(null, true);
    }

}
