package org.spelle.sport;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerDao {

    private List<Player> players;

    public PlayerDao(List<Player> players) { this.players = players; }

    public List<Player> getAllPlayers() {
        return this.players.stream().collect(Collectors.toList());
    }

    public  Player savePlayer(Player player) {
        this.players.add(player);

        return player;
    }

}
