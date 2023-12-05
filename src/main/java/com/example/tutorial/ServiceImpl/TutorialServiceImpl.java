package com.example.tutorial.ServiceImpl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tutorial.DTO.RequestCreateTutorDTO;
import com.example.tutorial.DTO.RequestUpdateTutorDTO;
import com.example.tutorial.DTO.ResponseCreateTutorDTO;
import com.example.tutorial.DTO.ResponseGetDetailTutorDTO;
import com.example.tutorial.DTO.ResponseUpdateTutorDTO;
import com.example.tutorial.controller.service.TutorialService;
import com.example.tutorial.domain.Tutorial;
import com.example.tutorial.repository.TutorialsRepository;

@Service
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	TutorialsRepository tutorRepo;

	
	@Override
	public ResponseEntity<List<Tutorial>> GetAllTutor() {
        List<Tutorial> data = tutorRepo.findAll();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<Tutorial>> GetTitleTutor(String title) {
		
		List<Tutorial> data = tutorRepo.findTitle(title);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseGetDetailTutorDTO> GetDetailTutor(int tutorId) {
		
		try {
		Tutorial data = tutorRepo.findById(BigInteger.valueOf(tutorId)).get();
		return new ResponseEntity<>(new ResponseGetDetailTutorDTO(data.getTitle(), data.getDescription(),
				String.valueOf(data.isPublished())), HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseGetDetailTutorDTO(null,null,null), HttpStatus.NOT_FOUND);		}
	}

	@Override
	public ResponseEntity<List<Tutorial>> GetPublishedTutor() {
		List<Tutorial> data = tutorRepo.findPublished();
		return new ResponseEntity<List<Tutorial>>(data,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseCreateTutorDTO> CreateTutor(RequestCreateTutorDTO rcto) {
		Tutorial tutor = new Tutorial();
		try {

			tutor.setTitle(rcto.getTitle());
			tutor.setDescription(rcto.getDescription());
			tutor.setPublished(false);
			tutorRepo.save(tutor);

			List<Tutorial> data = tutorRepo.findNewestId();

			return new ResponseEntity<>(new ResponseCreateTutorDTO(data.get(0).getId(), data.get(0).getTitle(),
					data.get(0).getDescription(), data.get(0).isPublished()), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseCreateTutorDTO(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ResponseUpdateTutorDTO> UpdateTutor(RequestUpdateTutorDTO ruto,int tutorId) {
		try {
			
		Tutorial tutor = tutorRepo.findById(BigInteger.valueOf(tutorId)).get();
		tutor.setTitle(ruto.getTitle());
		tutor.setDescription(ruto.getDescription());
		tutor.setPublished(ruto.isPublished());
		tutorRepo.save(tutor);
		
		return new ResponseEntity<>(new ResponseUpdateTutorDTO(tutor.getId(),tutor.getTitle(),tutor.getDescription(),tutor.isPublished()),HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<>(new ResponseUpdateTutorDTO(),HttpStatus.NOT_FOUND);

		}
	}

	@Override
	public ResponseEntity<Void> DeleteaAllTutor() {
		tutorRepo.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Void> DeleteSpecificTutor(int tutorId) {
		try {
			tutorRepo.deleteById(BigInteger.valueOf(tutorId));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
