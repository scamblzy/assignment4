package com.example.endka.model;

import com.example.endka.exception.InvalidInputException;
import com.example.endka.interfaces.PointCalculable;


public class LANTournament extends Tournament {
    private int numberOfTeams;
    private String organizerName;
    private String location;

    public LANTournament(int id , String name , double prizePool , int basePoints , int numberOfTeams , String organizerName, String location){
        super(id , name , prizePool , basePoints);
        this.numberOfTeams = numberOfTeams;
        this.organizerName = organizerName;
        this.location = location;
        validateNumberOfTeams();
        validateOrganizerName();
        validateLocation();
    }

    private void validateNumberOfTeams() {
        if (numberOfTeams <= 1) {
            throw new InvalidInputException("Number of teams must be greater than 1");
        }
    }

    private void validateOrganizerName() {
        if (organizerName == null || organizerName.isBlank()) {
            throw new InvalidInputException("Organizer name cannot be empty");
        }
    }

    private void validateLocation(){
        if(location == null || location.isBlank()){
            throw new InvalidInputException(    "Location name cannot be empty");
        }
    }

    @Override
    public int getMinimumAge(){
        return 18;
    }

    @Override
    public double pointsValue(){
        return 1.5;
    }
}
