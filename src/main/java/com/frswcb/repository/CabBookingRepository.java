package com.frswcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frswcb.entity.CabBooking;

public interface CabBookingRepository extends JpaRepository<CabBooking, Integer> {

}
