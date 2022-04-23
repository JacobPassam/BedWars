package com.github.jacobpassam.bedwars.arena.command.ext;

import com.github.jacobpassam.bedwars.command.Command;
import com.github.jacobpassam.bedwars.command.CommandPermission;
import com.github.jacobpassam.bedwars.command.CommandUser;

public class ArenaListCommand implements Command {

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getUsage() {
        return "/arena list";
    }

    @Override
    public String getDescription() {
        return "List arenas.";
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
    public void execute(CommandUser sender, String[] args) {

    }
}
