package com.project.Team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {


    @Autowired
    private TeamRepository teamRepository;

    //CRUD->SQl->HTTPRequest
    //create/insert/post
    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    //read/select/get
    public List<Team> getTeams() {

        return teamRepository.findAll();
    }

    public Optional<Team> getTeam(long id) {
        Optional<Team> user = teamRepository.findById(id);
        return user;
    }

    //update/update/put
    public void updateTeam(Team team) {

        Optional<Team> theUser = teamRepository.findById(team.getId());

        theUser.map(team0 -> {
            team0.setName(team.getName());
            team0.setWins(team.getWins());
            team0.setLosses(team.getLosses());
            team0.setContests(team.getContests());
            return null;
        });
    }

    //delete/delete/delete
    public void deleteTeam(Team team) {
        teamRepository.delete(team);
    }


}
