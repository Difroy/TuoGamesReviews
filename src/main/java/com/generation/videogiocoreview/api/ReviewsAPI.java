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

import com.generation.videogiocoreview.model.dto.ReviewsDTO;
import com.generation.videogiocoreview.model.dto.ReviewsMapper;
import com.generation.videogiocoreview.model.entities.Reviews;
import com.generation.videogiocoreview.model.repository.ReviewsRepository;

@RestController
@RequestMapping("gamesreview/api/review")
public class ReviewsAPI {

	@Autowired
	ReviewsMapper rmapper;
	@Autowired
	ReviewsRepository revirepo;

	@PostMapping
	public ReviewsDTO insertReview(@RequestBody ReviewsDTO dto) {

		Reviews r = rmapper.daDTOAReview(dto);
		r = revirepo.save(r);

		// Dopo averlo registrato nel DB e averli assegnato un ID,
		// lo ritrasformiamo in DTO
		return rmapper.daReviewADTO(r);
	}

	@GetMapping("/{id}")
	public ReviewsDTO getReview(@PathVariable("id") int id) {
	
		try {
			if (id < 0) {
				throw new RuntimeException("ID non valido");
			}
		Optional<Reviews> review = revirepo.findById(id);
		if (review.isPresent()) {
			return rmapper.daReviewADTO(review.get());

		}
		
		}catch(Exception e) {
			throw new RuntimeException("Review non trovata");
	}return null;
	    
	}

	@GetMapping()
	public List<ReviewsDTO> getReviews() {

		List<ReviewsDTO> listaVuotaDTO = rmapper.daReviewADTO(revirepo.findAll());
		return listaVuotaDTO;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteGame(@PathVariable("id") int id) {
		Optional<Reviews> reviewOptional = revirepo.findById(id);

		if (reviewOptional.isEmpty()) {

			return new ResponseEntity<>("Review non trovata", HttpStatus.NOT_FOUND);

		}

		Reviews existingReview = reviewOptional.get();
		revirepo.delete(existingReview);

		return new ResponseEntity<>(rmapper.daReviewADTO(existingReview), HttpStatus.OK);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReviewsDTO> updateReview(@PathVariable("id")int id, @RequestBody ReviewsDTO dto){
	Optional<Reviews> reviewOptional = revirepo.findById(id);
    if (reviewOptional.isEmpty()) {
       
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   
    Reviews existingReview = reviewOptional.get();
    existingReview = rmapper.daDTOAReview(dto); 
    existingReview.setId(id); 

 
   Reviews updatedReview = revirepo.save(existingReview);

  
    return new ResponseEntity<>(rmapper.daReviewADTO(updatedReview),HttpStatus.OK);
}
	

}
