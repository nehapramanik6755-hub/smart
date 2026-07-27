package com.travelguide.demo.repository;

import com.travelguide.demo.entity.place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface placerepository extends JpaRepository<place, Long> {
}
