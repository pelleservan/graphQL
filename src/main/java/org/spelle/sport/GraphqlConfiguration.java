package org.spelle.sport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public TeamDao teamDao() {
        List<Team> teams = new ArrayList<>();
        for (int teamId = 0; teamId < 5; ++teamId) {
            Team team = new Team();
            team.setId("" + teamId);
            team.setName("Name " + teamId);
            team.setCountry("Country " + teamId);
            team.setCity("City " + teamId);
            teams.add(team);
        }
        return new TeamDao(teams);
    }

    @Bean
    public PlayerDao playerDao() {
        List<Player> players = new ArrayList<>();
        for (int playerId = 0; playerId < 10; ++playerId) {
            Player player = new Player();
            player.setId("" + playerId);
            player.setFirst_name("First Name " + playerId);
            player.setLast_name("Last Name " + playerId);
            player.setDate_of_birth("Date of Birth " + playerId);
            player.setTeam_id("2");
            players.add(player);
        }
        return new PlayerDao(players);
    }
}
