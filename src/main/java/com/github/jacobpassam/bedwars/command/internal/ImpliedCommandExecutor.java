package com.github.jacobpassam.bedwars.command.internal;

import com.github.jacobpassam.bedwars.command.Command;
import com.github.jacobpassam.bedwars.command.CommandUser;
import lombok.Data;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@Data
public class ImpliedCommandExecutor implements CommandExecutor {

    private final Command bwCommand;

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (!(sender instanceof Player) && !(bwCommand.isConsoleAllowed())) {
            sender.sendMessage("Console Not Allowed");
            return true;
        }

        CommandUser user = new CommandUser((sender instanceof ConsoleCommandSender), sender);
        if (!user.hasPermission(bwCommand.getPermission())) {
            sender.sendMessage("No Permission");
        } else {
            bwCommand.execute(user, args);
        }

        return true;
    }
}
