package com.generation.videogiocoreview.model.entities;

import com.generation.videogiocoreview.model.dto.ReviewsDTO;
import com.generation.videogiocoreview.model.repository.GamesRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reviews {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int Id;
	protected String title,review;
	protected int score;
	@ManyToOne
	Games game;
	
	public Reviews(ReviewsDTO dto, GamesRepository repo) {
		  
		this.Id=dto.getId();
		this.title=dto.getTitle();
		this.review=dto.getReview();
		this.score=dto.getScore();
		this.game = repo.findById(dto.getId()).get();
	}
	
	
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String recensione) {
		this.review = recensione;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int punteggio) {
		this.score = punteggio;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String titolo) {
		this.title = titolo;
	}
	public Games getGame() {
		return game;
	}
	public void setGame(Games gioco) {
		this.game = gioco;
	}
	
	
	
	
}
