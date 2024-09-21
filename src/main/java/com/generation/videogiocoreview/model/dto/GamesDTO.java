package com.generation.videogiocoreview.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.generation.videogiocoreview.model.entities.AvaibleSystem;

public class GamesDTO {

	protected int Id;
	protected String name, description;
	protected int bestPrice;
	AvaibleSystem[] system;
	List<ReviewsDTO> reviewsDTO = new ArrayList<>();
	
	

	
	
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String descrizione) {
		this.description = descrizione;
	}
	public AvaibleSystem[] getSystem() {
		return system;
	}
	public void setSystem(AvaibleSystem[] sistema) {
		this.system = sistema;
	}
	public List<ReviewsDTO> getReviewsDTO() {
		return reviewsDTO;
	}
	public void setReviewsDTO(List<ReviewsDTO> reviewsDTO) {
		this.reviewsDTO = reviewsDTO;
	}
	
	public void setPrice (int prezzo) {
		
		this.bestPrice = prezzo;
	}
	
	public int getPrice() {
		return bestPrice;
	}
	
	
	
}
