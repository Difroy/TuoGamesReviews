package com.generation.videogiocoreview.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	GamesMapper mapper;
	@Autowired
	GamesRepository gamerepo;
	@Autowired
	ReviewsMapper revirepo;
	
	
	//Ricordiamo che le insert arrivano da Javascript, di conseguenza le informazioni che ci arriveranno sono in DTO. Dobbiamo trasformalo da DTO a Entità per salvarlo nel DB e successivamente lo ritrasformiamo in DTO per poter fare un trasporto d'informazioni senza creare cicli.
//@RequestBody: Si prende il body della richiesta e lo inserisce nella variabile in input
	@PostMapping
	public GamesDTO insertGame(@RequestBody GamesDTO dto) 
	{
		Games g = mapper.daDTOAGames(dto);
		g = gamerepo.save(g);
		return mapper.daGamesADTO(g,revirepo);
	}
	
	@GetMapping("/{id}")
	public GamesDTO getGame(@PathVariable("id") int id){	
		return mapper.daGamesADTO(gamerepo.findById(id) .get(),revirepo);
	//DA FARE CONTROLLI
	}
	
	
	@GetMapping()
	public List<GamesDTO> getGames(){
		
		List<GamesDTO>listaVuotaDTO = new ArrayList<GamesDTO>();
		
		return listaVuotaDTO;
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
