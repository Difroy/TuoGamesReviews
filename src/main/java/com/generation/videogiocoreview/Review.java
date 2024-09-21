package com.generation.videogiocoreview;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	protected int Id;
	protected String review;
	protected int score;
	@ManyToOne
	protected String gameId;
	
	
	
}
