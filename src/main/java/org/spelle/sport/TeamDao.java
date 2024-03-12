package org.spelle.sport;

import java.util.List;
import java.util.stream.Collectors;

public class TeamDao {

    private List<Team> teams;

    public  TeamDao(List<Team> teams) { this.teams = teams; }

    public List<Team> getTeams() {
        return this.teams.stream().collect(Collectors.toList());
    }

    public Team saveTeam(Team team) {
        this.teams.add(team);

        return team;
    }
}
