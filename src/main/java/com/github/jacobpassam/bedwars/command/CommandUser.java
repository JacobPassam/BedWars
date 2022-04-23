package com.github.jacobpassam.bedwars.command;

import lombok.Data;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Data
public class CommandUser {

    private final boolean console;
    private final CommandSender bukkit;

    public void sendMessage(String message) {
        bukkit.sendMessage(message);
    }

    public String getName() {
        if (console) return "Console";
        else return bukkit.getName();
    }

    public boolean hasPermission(CommandPermission permission) {
        if (permission == null) {
            return true;
        }

        if (console || (permission.isOp() && bukkit.isOp())) {
            return true;
        }

        if (!(bukkit instanceof Player)) return false; // Safety

        Player player = (Player) bukkit;
        return player.hasPermission(permission.getPermission());
    }

}
