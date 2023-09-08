package com.frswcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frswcb.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
