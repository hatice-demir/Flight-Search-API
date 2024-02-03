package com.amadeus.FlightSearch.repositories;

import org.springframework.stereotype.Repository;

import com.amadeus.FlightSearch.entities.User;

@Repository
public class UserRepository {
    public User findUserByUserName(String userName){
        User user = new User(userName, "password1", true);
        return user;
    }
}