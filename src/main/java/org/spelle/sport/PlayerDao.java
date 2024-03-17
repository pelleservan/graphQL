package org.spelle.sport;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerDao {

    private List<Player> players;

    public PlayerDao(List<Player> players) { this.players = players; }

    public List<Player> getPlayers() {
        return this.players.stream().collect(Collectors.toList());
    }

    public Player getPlayerById(String id) {
        return this.players.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Player> getPlayersByFirstName(String first_name) {
        return this.players.stream()
                .filter(player -> player.getFirst_name().equals(first_name))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByLastName(String last_name) {
        return this.players.stream()
                .filter(player -> player.getLast_name().equals(last_name))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByDateOfBirth(String date_of_birth) {
        return this.players.stream()
                .filter(player -> player.getDate_of_birth().equals(date_of_birth))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamId(String teamId) {
        return this.players.stream()
                .filter(player -> player.getTeam_id().equals(teamId))
                .collect(Collectors.toList());
    }

    public Player updatePlayerFirstNameById(String id, String first_name) {
        Player existingPlayer = this.getPlayerById(id);
        if (existingPlayer == null) {
            return null;
        }
        existingPlayer.setFirst_name(first_name);

        return existingPlayer;
    }

    public Player updatePlayerLastNameById(String id, String last_name) {
        Player existingPlayer = this.getPlayerById(id);
        if (existingPlayer == null) {
            return null;
        }
        existingPlayer.setLast_name(last_name);

        return existingPlayer;
    }

    public Player updatePlayerDateOfBirthById(String id, String date_of_birth) {
        Player existingPlayer = this.getPlayerById(id);
        if (existingPlayer == null) {
            return null;
        }
        existingPlayer.setDate_of_birth(date_of_birth);

        return existingPlayer;
    }

    public Player updatePlayerTeamIdById(String id, String team_id) {
        Player existingPlayer = this.getPlayerById(id);
        if (existingPlayer == null) {
            return null;
        }
        existingPlayer.setTeam_id(team_id);

        return existingPlayer;
    }

    public void deletePlayerById(String id) {
        this.players.removeIf(player -> player.getId().equals(id));
    }

    public  Player savePlayer(Player player) {
        this.players.add(player);

        return player;
    }

}
