package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public PlayerDao playerDao() {
        List<Player> players = new ArrayList<>();
        for (int playerId = 0; playerId < 1000; ++playerId) {
            Player player = new Player();
            player.setId("" + playerId);
            player.setFirstName("First Name " + playerId);
            player.setLastName("Last Name " + playerId);
            player.setDateOfBirth("Date of Birth " + playerId);
            players.add(player);
        }
        return new PlayerDao(players);
    }
}
