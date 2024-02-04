package com.amadeus.FlightSearch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amadeus.FlightSearch.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}