package com.github.jacobpassam.bedwars.command.extension;

import com.github.jacobpassam.bedwars.command.Command;
import com.github.jacobpassam.bedwars.command.CommandUser;

import java.util.Arrays;

public interface ExtensionHandler extends Command {

    Command[] getExtensions();

    @Override
    default String getUsage() {
        return "";
    }

    default String getInvalidCommandMessages() {
        if (getExtensions().length == 0) {
            return "No Commands Registered";
        }

        StringBuilder s = new StringBuilder();

        for (Command extension : getExtensions()) {
            s.append(extension.getUsage()).append(" ").append(extension.getDescription()).append("\n");
        }

        return s.toString();
    }

    @Override
    default void execute(CommandUser sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(getInvalidCommandMessages());
        }

        Command command = Command.findByName(args[0], getExtensions());
        if (command == null) {
            sender.sendMessage(getInvalidCommandMessages());
        } else {
            if (!sender.hasPermission(command.getPermission())) {
                sender.sendMessage("No Permission");
                return;
            }

            String[] subArgs = Arrays.copyOfRange(args, 1, args.length);
            command.execute(sender, subArgs);
        }

    }

}
