package com.frswcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frswcb.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
