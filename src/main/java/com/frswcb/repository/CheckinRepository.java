package com.frswcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frswcb.entity.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Integer> {

}
