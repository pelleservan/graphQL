package org.spelle.sport;

import java.util.List;
import java.util.stream.Collectors;

public class TeamDao {

    private List<Team> teams;

    public  TeamDao(List<Team> teams) { this.teams = teams; }

    public List<Team> getTeams() {
        return this.teams.stream().collect(Collectors.toList());
    }

    public Team getTeamById(String id) {
        return this.teams.stream()
                .filter(team -> team.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Team getTeamByName(String name) {
        return this.teams.stream()
                .filter(team -> team.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Team> getTeamByCity(String city) {
        return this.teams.stream()
                .filter(team -> team.getCity().equals(city))
                .collect(Collectors.toList());
    }

    public List<Team> getTeamByCountry(String country) {
        return this.teams.stream()
                .filter(team -> team.getCountry().equals(country))
                .collect(Collectors.toList());
    }

    public Team updateTeamNameById(String id, String name) {
        Team existingTeam = this.getTeamById(id);
        if (existingTeam == null) {
            return null;
        }
        existingTeam.setName(name);

        return existingTeam;
    }

    public void deleteTeamById(String id) {
        this.teams.removeIf(team -> team.getId().equals(id));
    }

    public Team saveTeam(Team team) {
        this.teams.add(team);

        return team;
    }
}
