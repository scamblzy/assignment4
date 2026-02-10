package com.example.endka.model;

import com.example.endka.exception.InvalidInputException;
import com.example.endka.interfaces.PointCalculable;


public abstract class Tournament implements PointCalculable {
    protected int id;
    protected String name;
    protected double prizePool;
    protected int basePoints;

    // constructor
    public Tournament(int id, String name, double prizePool, int basePoints){
        this.id = id;
        this.name = name;
        this.prizePool = prizePool;
        this.basePoints = basePoints;
        validateId();
        validateName();
        validatePool();
        validateBasePoints();
    }

    //methods
    public abstract int getMinimumAge();

    public abstract double pointsValue();

    @Override
    public double calculatePoints(){
        return (basePoints * pointsValue());
    }

    protected void validateId() {
        if (id <= 0) {
            throw new InvalidInputException("Id must be positive");
        }
    }

    protected void validateName() {
        if (name == null || name.isBlank()) {
            throw new InvalidInputException("model.Tournament name cannot be empty");
        }
    }

    protected void validatePool(){
        if(prizePool <= 0){
            throw new InvalidInputException("Prize pool must be greater than 0");
        }
    }

    protected void validateBasePoints() {
        if (basePoints <= 0) {
            throw new InvalidInputException("Base points must be positive");
        }
    }

    //getters
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrizePool(){
        return prizePool;
    }
}
