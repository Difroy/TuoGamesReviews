package com.generation.videogiocoreview.model.dto;

public class ReviewsDTO {
	
	protected int Id;
	protected String title, review;
	protected int score;
	protected int gameId;
	
	
	
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
