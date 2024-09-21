package com.generation.videogiocoreview.model.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Games {

	
	@Id
	//--------------------------------------------------------------------------
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//!!GeneratedValue:
	//usata in Java con JPA (Java Persistence API) per indicare che il valore di un campo deve essere generato automaticamente. Questa annotazione è spesso usata con l'annotazione @Id per indicare che il campo è la chiave primaria dell'entità.
	//!!strategy = GenerationType.IDENTITY:
	//specifica che la generazione del valore deve essere gestita dal database. In altre parole, quando crei una nuova entità e la salvi nel database, il database genererà automaticamente un nuovo valore per il campo.
	//--------------------------------------------------------------------------
	protected int id;
	protected String name, description;
	protected int bestPrice;
	AvaibleSystem[] system;
	@OneToMany ( mappedBy = "game")
	//@JoinColumn(name = "gameId") (Come dovrei fare per usare questo???)
	List<Reviews>reviews = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String nome) {
		this.name = nome;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String descrizione) {
		this.description = descrizione;
	}
	public int getBestPrice() {
		return bestPrice;
	}
	public void setBestPrice(int migliorPrezzo) {
		this.bestPrice = migliorPrezzo;
	}
	public AvaibleSystem[] getSystem() {
		return system;
	}
	public void setSystem(AvaibleSystem[] system) {
		this.system = system;
	}
	public List<Reviews> getReviews() {
		return reviews;
	}
	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
	
	
	
}
