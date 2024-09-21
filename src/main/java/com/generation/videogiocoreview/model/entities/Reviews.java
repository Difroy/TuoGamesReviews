package com.generation.videogiocoreview.model.entities;

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
