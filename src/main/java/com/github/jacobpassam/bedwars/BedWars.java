package com.github.jacobpassam.bedwars;

import com.github.jacobpassam.bedwars.command.internal.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class BedWars extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        CommandHandler commandHandler = new CommandHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
