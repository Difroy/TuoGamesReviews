package com.generation.videogiocoreview.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.videogiocoreview.model.entities.Reviews;
import com.generation.videogiocoreview.model.repository.GamesRepository;
 
@Service
public class ReviewsMapper {

	@Autowired
	GamesRepository repo;
	
	public Reviews daDTOAReview(ReviewsDTO dto) {
		
		/*Reviews res = new Reviews(dto, repo);*/
		return new Reviews(dto, repo);
		
	}
	
	
	public ReviewsDTO daReviewADTO(Reviews r) {
		
		return new ReviewsDTO(r);
		
	}
	
	
	public List<Reviews>daDTOAReview(List<ReviewsDTO>listaPiena) {
		List<Reviews> listaVuotaDTO = new ArrayList<>();
		//Per ogni tipo di REVIEWDTO chiamato R. Ciclami tutti gli elementi della lista revdto
		for(ReviewsDTO singoloElementoListaPiena : listaPiena) {	
			listaVuotaDTO.add(daDTOAReview(singoloElementoListaPiena));	
		}
		return listaVuotaDTO;
	}
	
	public List <ReviewsDTO> daReviewADTO(List<Reviews>listaPiena){
		
		List<ReviewsDTO>listaVuotaDTO = new ArrayList<>();
		for(Reviews singoloElementoListaPiena : listaPiena) {
			listaVuotaDTO.add(daReviewADTO(singoloElementoListaPiena));
		}
			return listaVuotaDTO;
	}
	
	
}
