package com.generation.videogiocoreview.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.videogiocoreview.model.entities.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {

}
