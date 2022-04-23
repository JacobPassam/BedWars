package com.github.jacobpassam.bedwars.command.internal;

import com.github.jacobpassam.bedwars.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHandler {

    private final JavaPlugin plugin;

    public CommandHandler(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register(Command command) { // Top-level
        plugin.getCommand(command.getName()).setExecutor(new ImpliedCommandExecutor(command));
    }

}
