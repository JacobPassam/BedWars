package com.github.jacobpassam.bedwars.command;

public interface Command {

    String getName();

    String getUsage();
    String getDescription();

    CommandPermission getPermission();

    boolean isConsoleAllowed();

    void execute(CommandUser sender, String[] args);

    static Command findByName(String name, Command[] commands) {
        Command command = null;

        for (Command iter : commands) {
            if (iter.getName().equalsIgnoreCase(name)) {
                command = iter;
            }
        }

        return command;
    }
}
