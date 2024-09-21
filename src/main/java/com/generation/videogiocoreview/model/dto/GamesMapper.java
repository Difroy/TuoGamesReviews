package com.generation.videogiocoreview.model.dto;

import com.generation.videogiocoreview.model.entities.Games;

public class GamesMapper {

	
	public Games fromDTO(GamesDTO dto) {
		
		Games res = new Games();
		res.setId(dto.getId());
		res.setName(dto.getName());
		res.setDescription(dto.getDescription());
		res.setBestPrice(dto.getPrice());
		return res;
		
	}
	
	
	
	
}
