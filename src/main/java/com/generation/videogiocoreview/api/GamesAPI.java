package com.generation.videogiocoreview.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	/*@GetMapping("/{id}")
	public GamesDTO getGame(@PathVariable("id") int id){	
		return gmapper.daGamesADTO(gamerepo.findById(id) .get());
	//DA FARE CONTROLLI
	}*/
	
	
	
	@GetMapping("/{id}")
	public GamesDTO getGame(@PathVariable("id") int id) {
		Optional<Games> game = gamerepo.findById(id);
		if (game.isPresent()) {
			return gmapper.daGamesADTO(game.get());
		} else {
			// Gestisci il caso in cui il gioco non esiste.
			// Potresti voler lanciare un'eccezione o restituire un DTO di default.
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gioco non trovato");
		}
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
	
	
	
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteGame(@PathVariable("id") int id) {
	    Optional<Games> gameOptional = gamerepo.findById(id);

	    if (gameOptional.isEmpty()) {
	        // Se il gioco non esiste, restituisco 404 NOT FOUND
	        return new ResponseEntity<>("Game not found", HttpStatus.NOT_FOUND);
	    }

	    // Se esiste, elimino il gioco
	    Games existingGame = gameOptional.get();
	    gamerepo.delete(existingGame);

	    // Restituisco il DTO del gioco eliminato con status 200 OK
	    return new ResponseEntity<>(gmapper.daGamesADTO(existingGame), HttpStatus.OK);
	}

	
	
	@PutMapping("/{id}")
	public ResponseEntity<GamesDTO> updateGame(@PathVariable("id") int id, @RequestBody GamesDTO dto) {
	    Optional<Games> gameOptional = gamerepo.findById(id);

	    if (gameOptional.isEmpty()) {
	        // Se il gioco non esiste, restituisco 404 NOT FOUND
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    // Aggiorno l'oggetto esistente con i dati del DTO
	    Games existingGame = gameOptional.get();
	    existingGame = gmapper.daDTOAGames(dto); // Questo può essere modificato per preservare l'ID e altri campi necessari
	    existingGame.setId(id); // Assicuro che l'ID del gioco rimanga invariato

	    // Salvo il gioco aggiornato
	    Games updatedGame = gamerepo.save(existingGame);

	    // Restituisco il DTO del gioco aggiornato con status 200 OK
	    return new ResponseEntity<>(gmapper.daGamesADTO(updatedGame), HttpStatus.OK);
	}

	
	
	/*	
	
	@PutMapping("/{id}")
	public GamesDTO updateGame(@PathVariable("id") int id, @RequestBody GamesDTO dto) {
		Games existingGame = gmapper.daDTOAGames(dto);
		existingGame = gamerepo.save(existingGame);
		return gmapper.daGamesADTO(existingGame);
	}*/
	

	
	
}
