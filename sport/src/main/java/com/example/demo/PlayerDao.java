package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerDao {

    private List<Player> players;

    public PlayerDao(List<Player> posts) {
        this.players = posts;
    }

    public List<Player> getRecentPosts(int count, int offset) {

        return this.players.stream().skip(offset).limit(count).collect(Collectors.toList());
    }

    public Player savePost(Player player) {

        this.players.add(player);

        return player;
    }
}
