package com.generation.videogiocoreview;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Games {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	protected String name, descrizione;
	protected int bestPrice;
	AvaibleSystem[] system;
	@OneToMany
	Review review;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getBestPrice() {
		return bestPrice;
	}
	public void setBestPrice(int bestPrice) {
		this.bestPrice = bestPrice;
	}
	public AvaibleSystem[] getSystem() {
		return system;
	}
	public void setSystem(AvaibleSystem[] system) {
		this.system = system;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	
	
}
