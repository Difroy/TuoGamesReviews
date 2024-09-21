package com.generation.videogiocoreview.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.videogiocoreview.model.entities.Games;

public interface GamesRepository extends JpaRepository <Games, Integer>{

}
