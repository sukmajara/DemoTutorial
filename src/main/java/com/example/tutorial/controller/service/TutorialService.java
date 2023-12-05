package com.example.tutorial.controller.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.tutorial.DTO.RequestCreateTutorDTO;
import com.example.tutorial.DTO.RequestUpdateTutorDTO;
import com.example.tutorial.DTO.ResponseCreateTutorDTO;
import com.example.tutorial.DTO.ResponseGetDetailTutorDTO;
import com.example.tutorial.DTO.ResponseUpdateTutorDTO;
import com.example.tutorial.domain.Tutorial;

public interface TutorialService {

	
	public ResponseEntity<List<Tutorial>> GetAllTutor();

	public ResponseEntity<List<Tutorial>> GetTitleTutor(String title);

	public ResponseEntity<ResponseGetDetailTutorDTO> GetDetailTutor(int tutorId);

	public ResponseEntity<List<Tutorial>> GetPublishedTutor();

	public ResponseEntity<ResponseCreateTutorDTO> CreateTutor(RequestCreateTutorDTO rcto);

	public ResponseEntity<ResponseUpdateTutorDTO> UpdateTutor(RequestUpdateTutorDTO ruto,int tutorId);

	public ResponseEntity<Void> DeleteaAllTutor();

	public ResponseEntity<Void> DeleteSpecificTutor(int tutorId);


}
