package com.example.endka.model;

import com.example.endka.exception.InvalidInputException;
import com.example.endka.interfaces.Validatable;


public class Player implements Validatable{
    private int id;
    private String nickname;
    private int age;
    private Address address;

    public Player(int id, String nickname, int age) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        Validatable.log("Validating player " + nickname);
    }

    @Override
    public void validate() {
        if (id <= 0) {
            throw new InvalidInputException("ID must be positive number");
        }

        if (nickname == null || nickname.isBlank()) {
            throw new InvalidInputException("Nickname cannot be empty");
        }

        if (age <= 0) {
            throw new InvalidInputException("Age must be positive");
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {return id;}
    public int getAge(){
        return age;
    }
    public Address getAddress() {
        return address;
    }


    public String getNickname(){
        return nickname;
    }

}
