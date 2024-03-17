package org.spelle.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerDao playerDao;

    public PlayerController() {
    }

    @QueryMapping
    public List<Player> getPlayers() {
        return this.playerDao.getPlayers();
    }

    @QueryMapping
    public Player getPlayerById(@Argument String id) {
        return this.playerDao.getPlayerById(id);
    }

    @QueryMapping
    public List<Player> getPlayersByFirstName(@Argument String first_name) {
        return this.playerDao.getPlayersByFirstName(first_name);
    }

    @QueryMapping
    public List<Player> getPlayersByLastName(@Argument String last_name) {
        return this.playerDao.getPlayersByLastName(last_name);
    }

    @QueryMapping
    public List<Player> getPlayersByDateOfBirth(@Argument String date_of_birth) {
        return this.playerDao.getPlayersByDateOfBirth(date_of_birth);
    }

    @QueryMapping
    public List<Player> getPlayersByTeamId(@Argument("teamId") String teamId) {
        return this.playerDao.getPlayersByTeamId(teamId);
    }

    @MutationMapping
    public Player updatePlayerFirstNameById(@Argument String id, @Argument String first_name) {
        return this.playerDao.updatePlayerFirstNameById(id, first_name);
    }

    @MutationMapping
    public Player updatePlayerLastNameById(@Argument String id, @Argument String last_name) {
        return this.playerDao.updatePlayerLastNameById(id, last_name);
    }

    @MutationMapping
    public Player updatePlayerDateOfBirthById(@Argument String id, @Argument String date_of_birth) {
        return this.playerDao.updatePlayerDateOfBirthById(id, date_of_birth);
    }

    @MutationMapping
    public Player updatePlayerTeamIdById(@Argument String id, @Argument String team_id) {
        return this.playerDao.updatePlayerTeamIdById(id, team_id);
    }

    @MutationMapping
    public void deletePlayerById(@Argument("id") String id) {
        this.playerDao.deletePlayerById(id);
    }

    @MutationMapping
    public Player writePlayer(@Argument String id, @Argument String first_name, @Argument String last_name, @Argument String date_of_birth, @Argument String team_id) {

        Player player = new Player();
        player.setId(id);
        player.setFirst_name(first_name);
        player.setLast_name(last_name);
        player.setDate_of_birth(date_of_birth);
        player.setTeam_id(team_id);

        return playerDao.savePlayer(player);
    }
}
