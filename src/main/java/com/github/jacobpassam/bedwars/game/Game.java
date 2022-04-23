package com.github.jacobpassam.bedwars.game;

import com.github.jacobpassam.bedwars.arena.Arena;
import com.github.jacobpassam.bedwars.arena.TeamLocationData;
import com.github.jacobpassam.bedwars.game.generator.Generator;
import com.github.jacobpassam.bedwars.game.player.GamePlayer;
import com.github.jacobpassam.bedwars.game.start.CountdownController;
import com.github.jacobpassam.bedwars.game.team.GameTeam;
import com.github.jacobpassam.bedwars.game.team.TeamBed;
import com.github.jacobpassam.bedwars.game.team.TeamColour;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private final Arena arena;

    @Getter @Setter
    private GameState gameState = GameState.RECRUIT;

    @Getter
    private final int minPlayers = 2;

    private final int maxPlayers;

    @Getter
    private final Set<GamePlayer> players;

    private final List<GameTeam> teams;

    private final Set<Generator> generators;

    private int roundRobin = -1;

    private CountdownController countdownController;

    public Game(Arena arena, JavaPlugin plugin) {
        this.arena = arena;

        this.maxPlayers = arena.getMaxPerTeam() * arena.getTeamCount();

        this.players = new HashSet<>();
        this.teams = new ArrayList<>();
        this.generators = new HashSet<>();

        generateTeams();
        generateGenerators();

        this.countdownController = new CountdownController(this, plugin);
    }

    public void generateTeams() {
        for (int i = 0; i < arena.getTeamCount(); i++) {
            TeamColour c = TeamColour.values()[i];

            GameTeam team = new GameTeam(c.getName(), c, new TeamBed(arena.getTeamData().get(c).getBed()));
            teams.add(team);
        }
    }

    public void generateGenerators() {
        arena.getGenerators().forEach((t, l) -> generators.add(new Generator(t, l)));
    }

    public GameTeam selectTeam() {
        if (roundRobin + 1 == teams.size()) {
            roundRobin = -1;
        }

        roundRobin += 1;

        return teams.get(roundRobin);
    }

    public GameTeam getTeam(GamePlayer player) {
        for (GameTeam team : teams) {
            if (team.getPlayers().contains(player)) return team;
        }

        return null;
    }

    public void broadcast(String s) {
        for (GamePlayer player : players) {
            player.to().sendMessage(s);
        }
    }

    public void join(Player player) {
        GamePlayer gp = new GamePlayer(player.getUniqueId(), player.getName());
        GameTeam team = selectTeam();

        players.add(gp);
        team.getPlayers().add(gp);

        player.teleport(arena.getWaitingLobby());

        player.sendMessage("Joined Game");
        broadcast(player.getName() + " Joined. (" + players.size() + "/" + maxPlayers + ")");

        countdownController.checkCountdown();
    }

    public void start() {
        this.gameState = GameState.LIVE;
        broadcast("Game is Live. Started.");

        for (GameTeam team : teams) {
            TeamLocationData data = arena.getTeamData().get(team.getColour());
            data.getBed().getBlock().setType(Material.BED);

            for (GamePlayer player : team.getPlayers()) {
                player.to().teleport(data.getSpawn());
            }
        }
    }

    public enum GameState {
        RECRUIT, COUNTDOWN, LIVE, ENDING;
    }

}
