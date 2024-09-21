package com.generation.videogiocoreview.model.dto;

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
	
	
	public GamesDTO daGamesADTO (Games games, ReviewsMapper mapper) {
		
		return new GamesDTO(games, mapper);
	}
	
	

}
