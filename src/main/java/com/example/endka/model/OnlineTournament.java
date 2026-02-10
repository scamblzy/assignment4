package com.example.endka.model;

import com.example.endka.exception.InvalidInputException;
import com.example.endka.interfaces.PointCalculable;


public class OnlineTournament extends Tournament {
    private int numberOfTeams;
    private String OrganizerName;

    public OnlineTournament(int id, String name , double prizePool, int basePoints, int numberOfTeams , String OrganizerName){
        super(id, name, prizePool, basePoints);
        this.numberOfTeams = numberOfTeams;
        this.OrganizerName = OrganizerName;
        validateNumberOfTeams();
        validateOrganizerName();
    }

    private void validateNumberOfTeams() {
        if (numberOfTeams <= 1) {
            throw new InvalidInputException("Number of teams must be greater than 1");
        }
    }

    private void validateOrganizerName() {
        if (OrganizerName == null || OrganizerName.isBlank()) {
            throw new InvalidInputException("Organizer name cannot be empty");
        }
    }

    @Override
    public int getMinimumAge(){
        return 14;
    }

    @Override
    public double pointsValue(){
        return 1.2;
    }
}
