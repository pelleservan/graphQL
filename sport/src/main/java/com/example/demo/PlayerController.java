package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

public class PlayerController {

    @Autowired
    private PlayerDao postDao;

    public PlayerController() {

    }

    @QueryMapping
    public List<Player> recentPosts(@Argument int count, @Argument int offset) {
        return this.postDao.getRecentPosts(count, offset);
    }

    @MutationMapping
    public Player writePost(@Argument String id, @Argument String first_name, @Argument String last_name, @Argument String date_of_birth) {

        Player player = new Player();
        player.setId(id);
        player.setFirstName(first_name);
        player.setLastName(last_name);
        player.setDateOfBirth(date_of_birth);

        return postDao.savePost(player);
    }
}
