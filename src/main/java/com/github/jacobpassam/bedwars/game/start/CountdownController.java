package com.github.jacobpassam.bedwars.game.start;

import com.github.jacobpassam.bedwars.game.Game;
import com.github.jacobpassam.bedwars.game.player.GamePlayer;
import org.bukkit.Sound;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CountdownController {

    private final Game game;
    private final JavaPlugin plugin;

    private int time = 20;

    public CountdownController(Game game, JavaPlugin plugin) {
        this.game = game;
        this.plugin = plugin;
    }

    public void checkCountdown() {
        if (game.getPlayers().size() == game.getMinPlayers() && game.getGameState() == Game.GameState.RECRUIT) {
            start();
        }
    }

    private void start() {
        game.setGameState(Game.GameState.COUNTDOWN);
        game.broadcast("Countdown Beginning Now");

        new BukkitRunnable() {

            @Override
            public void run() {
                if (time == 0) {
                    this.cancel();
                    game.start();

                    return;
                }

                if (time % 5 == 0 || time < 5) {
                    game.broadcast("The game will begin in " + time + " seconds.");
                    for (GamePlayer player : game.getPlayers()) {
                        player.to().playSound(player.to().getLocation(), Sound.NOTE_PLING, 10, 6);
                    }
                }

                time -= 1;
            }

        }.runTaskTimer(plugin, 0, 20L);
    }
}
