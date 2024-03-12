package org.spelle.sport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public PlayerDao playerDao() {
        List<Player> players = new ArrayList<>();
        for (int playerId = 0; playerId < 10; ++playerId) {
            Player player = new Player();
            player.setId("" + playerId);
            player.setFirst_name("First Name " + playerId);
            player.setLast_name("Last Name " + playerId);
            player.setDate_of_birth("Date of Birth " + playerId);
            players.add(player);
        }
        return new PlayerDao(players);
    }
}
