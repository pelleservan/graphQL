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

    @MutationMapping
    public Player writePlayer(@Argument String id, @Argument String first_name, @Argument String last_name, @Argument String date_of_birth) {

        Player player = new Player();
        player.setId(id);
        player.setFirst_name(first_name);
        player.setLast_name(last_name);
        player.setDate_of_birth(date_of_birth);

        return playerDao.savePlayer(player);
    }
}
