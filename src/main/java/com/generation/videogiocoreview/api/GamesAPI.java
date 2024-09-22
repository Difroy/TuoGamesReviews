package com.generation.videogiocoreview.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.videogiocoreview.model.dto.GamesDTO;
import com.generation.videogiocoreview.model.dto.GamesMapper;
import com.generation.videogiocoreview.model.dto.ReviewsMapper;
import com.generation.videogiocoreview.model.entities.Games;
import com.generation.videogiocoreview.model.repository.GamesRepository;

@RestController
@RequestMapping ("/gamesreview/api/games")
public class GamesAPI {

	@Autowired
	GamesMapper gmapper;
	@Autowired
	GamesRepository gamerepo;
	@Autowired
	ReviewsMapper rmapper;
	
	
	//Ricordiamo che le insert arrivano da Javascript, di conseguenza le informazioni che ci arriveranno sono in DTO. Dobbiamo trasformalo da DTO a Entità per salvarlo nel DB e successivamente lo ritrasformiamo in DTO per poter fare un trasporto d'informazioni senza creare cicli.
//@RequestBody: Si prende il body della richiesta e lo inserisce nella variabile in input
	@PostMapping
	public GamesDTO insertGame(@RequestBody GamesDTO dto) 
	{
		Games g = gmapper.daDTOAGames(dto);
		g = gamerepo.save(g);
		return gmapper.daGamesADTO(g);
	}
	
	@GetMapping("/{id}")
	public GamesDTO getGame(@PathVariable("id") int id){	
		return gmapper.daGamesADTO(gamerepo.findById(id) .get());
	//DA FARE CONTROLLI
	}
	
	
	@GetMapping()
	public List<GamesDTO> getGames(){
		
		//Lo faccio in questo modo perché già l'ho sviluppato nel GamesMapper
		List<GamesDTO>listaVuotaDTO = gmapper.daGamesADTO(gamerepo.findAll());
		return listaVuotaDTO;
		
		
		
		/*List<GamesDTO>listaVuotaDTO = new ArrayList<>();
		for(Games singoloElementoListaPiena : gamerepo.findAll())
			listaVuotaDTO.add(gmapper.daGamesADTO(singoloElementoListaPiena, rmapper));
		
		return listaVuotaDTO;*/
	}
	
	
	
/*
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable("id") int id) {
		Games existingGame = gamerepo.findById(id).orElseThrow();
		gamerepo.delete(existingGame);
		return ResponseEntity.ok().build();
	}
	
	
	
	@PutMapping("/{id}")
	public GamesDTO updateGame(@PathVariable("id") int id, @RequestBody GamesDTO dto) {
		Games existingGame = gmapper.daDTOAGames(dto);
		existingGame = gamerepo.save(existingGame);
		return gmapper.daGamesADTO(existingGame);
	}*/
	
	
	

	
	
	
	
	
	
	
	
	
	
}
