package org.spelle.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TeamController {

    @Autowired
    private TeamDao teamDao;

    public TeamController() {
    }

    @QueryMapping
    public List<Team> getTeams() {
        return this.teamDao.getTeams();
    }

    @QueryMapping
    public Team getTeamById(@Argument String id) { return this.teamDao.getTeamById(id); }

    @QueryMapping
    public Team getTeamByName(@Argument String name) { return this.teamDao.getTeamByName(name); }

    @QueryMapping
    public List<Team> getTeamByCity(@Argument String city) { return this.teamDao.getTeamByCity(city); }

    @QueryMapping
    public List<Team> getTeamByCountry(@Argument String country) { return this.teamDao.getTeamByCountry(country); }

    @MutationMapping
    public Team updateTeamNameById(@Argument String id, @Argument String  name) {
        return this.teamDao.updateTeamNameById(id, name);
    }

    @MutationMapping
    public void deleteTeamById(@Argument("id") String id) {
        this.teamDao.deleteTeamById(id);
    }
    @MutationMapping
    public Team writerTeam(@Argument String id, @Argument String name, @Argument String country, @Argument String city) {

        Team team = new Team();
        team.setId(id);
        team.setName(name);
        team.setCountry(country);
        team.setCity(city);

        return teamDao.saveTeam(team);
    }
}
