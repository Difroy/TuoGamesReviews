package com.generation.videogiocoreview.model.dto;

import com.generation.videogiocoreview.model.entities.Reviews;


public class ReviewsDTO {
	
	protected int Id;
	protected String title, review;
	protected int score;
	protected int gameId;
	
	
	public ReviewsDTO(Reviews r){
		
		this.Id = r.getId();
		this.title = r.getTitle();
		this.review = r.getReview();
		this.score = r.getScore();
		this.gameId = r.getGame().getId();
		
	}
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String titolo) {
		this.title = titolo;
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
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int giocoId) {
		this.gameId = giocoId;
	}
	
	
	

	
	

}
