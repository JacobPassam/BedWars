package com.github.jacobpassam.bedwars.arena.command;

import com.github.jacobpassam.bedwars.command.Command;
import com.github.jacobpassam.bedwars.command.CommandPermission;
import com.github.jacobpassam.bedwars.command.extension.ExtensionHandler;

public class ArenaCommand implements ExtensionHandler {

    @Override
    public String getName() {
        return "arena";
    }

    @Override
    public String getDescription() {
        return "Arena Management";
    }

    @Override
    public CommandPermission getPermission() {
        return CommandPermission.op();
    }

    @Override
    public boolean isConsoleAllowed() {
        return true;
    }

    @Override
    public Command[] getExtensions() {
        return new Command[0];
    }
}
