package com.example.tutorial.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorial.DTO.RequestCreateTutorDTO;
import com.example.tutorial.DTO.RequestUpdateTutorDTO;
import com.example.tutorial.DTO.ResponseCreateTutorDTO;
import com.example.tutorial.DTO.ResponseGetDetailTutorDTO;
import com.example.tutorial.DTO.ResponseUpdateTutorDTO;
import com.example.tutorial.controller.service.TutorialService;
import com.example.tutorial.domain.Tutorial;

@RestController
@RequestMapping("/api")
public class TutorialController {
	
	@Autowired
	TutorialService tutorService;
	
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> GetAllTutor(){
		return tutorService.GetAllTutor();
	}
	
	@GetMapping(value = "/tutorials", params="title")
	public ResponseEntity<List<Tutorial>> GetTitleTutor(@RequestParam(value = "title", required = false) String title){
		return tutorService.GetTitleTutor(title);
	}

	
	@GetMapping("/tutorials/{tutorId}")
	public ResponseEntity<ResponseGetDetailTutorDTO> GetDetailTutor(@PathVariable int tutorId){
		return tutorService.GetDetailTutor(tutorId);
	}
	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Tutorial>> GetPublishedTutor(){
		return tutorService.GetPublishedTutor();
	}
	
	@PostMapping("/tutorials")
	public ResponseEntity<ResponseCreateTutorDTO> CreateTutor(@RequestBody RequestCreateTutorDTO rcto){
		return tutorService.CreateTutor(rcto);
	}
	
	@PutMapping("tutorials/{tutorId}")
	public ResponseEntity<ResponseUpdateTutorDTO> UpdateTutor(@RequestBody RequestUpdateTutorDTO ruto,@PathVariable int tutorId){
		return tutorService.UpdateTutor(ruto,tutorId);
	}
		
	@DeleteMapping("/tutorials")
	public ResponseEntity<Void> DeleteaAllTutor(){
		return tutorService.DeleteaAllTutor();
	}
	@DeleteMapping("tutorials/{tutorId}")
	public ResponseEntity<Void> DeleteSpecificTutor(@PathVariable int tutorId){
		return tutorService.DeleteSpecificTutor(tutorId);
	}
}
