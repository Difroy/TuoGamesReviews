package com.generation.videogiocoreview.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.videogiocoreview.model.entities.Games;
@Service
public class GamesMapper {

	@Autowired
	ReviewsMapper mapper;
	
	
	public Games daDTOAGames (GamesDTO dto) {
		return new Games(dto, mapper);
	
		/*Games res = new Games();
		res.setId(dto.getId());
		res.setName(dto.getName());
		res.setDescription(dto.getDescription());
		res.setBestPrice(dto.getPrice());
		return res;*/
	
	}
	public GamesDTO daGamesADTO (Games games) {
		return new GamesDTO(games, mapper);
	}
	
	
	
	public List<GamesDTO> daGamesADTO(List<Games>games){
		
		List<GamesDTO> listaVuotaDTO = new ArrayList<>();
		for (Games singoloElementoLista : games)
			listaVuotaDTO.add(daGamesADTO(singoloElementoLista));
		return listaVuotaDTO;
		
	}
	
	public List<Games> daDTOAGames (List<GamesDTO> gamesDTO){
		List<Games> listaVuotaGames = new ArrayList<>();
		for (GamesDTO singoloElementoLista : gamesDTO)
			listaVuotaGames.add(daDTOAGames(singoloElementoLista));
		return listaVuotaGames;
	}
	
	
	
	
	
	
	

}
