package com.colco.app.restcontroller;

import static com.colco.app.constants.AppConstants.DELETE;
import static com.colco.app.constants.AppConstants.DELETE_BY_ID;
import static com.colco.app.constants.AppConstants.DELETE_FAILED;
import static com.colco.app.constants.AppConstants.FAILED_MSG;
import static com.colco.app.constants.AppConstants.GET_MR_BY_ID;
import static com.colco.app.constants.AppConstants.GET_MR_NAMES;
import static com.colco.app.constants.AppConstants.SAVE_MR;
import static com.colco.app.constants.AppConstants.SUCCESS_MSG;
import static com.colco.app.constants.AppConstants.UPDATED;
import static com.colco.app.constants.AppConstants.UPDATE_FAILED;
import static com.colco.app.constants.AppConstants.UPDATE_MR;
import static com.colco.app.constants.AppConstants.VIEW_ALL_MR_WITH_DRUGS;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.colco.app.model.MedicalRepresentative;
import com.colco.app.model.Response;
import com.colco.app.service.MRService;

@RestController
public class MRController {

	@Autowired
	private MRService mRService;

	@PostMapping(SAVE_MR)
	public ResponseEntity<Object> saveMR(@RequestBody MedicalRepresentative medicalRepresentative) {

		boolean isSave = mRService.createMR(medicalRepresentative);
		if (isSave) {
			return new ResponseEntity<Object>(SUCCESS_MSG, CREATED);

		} else {

			return new ResponseEntity<Object>(FAILED_MSG, INTERNAL_SERVER_ERROR);

		}
	}

	
	@GetMapping(VIEW_ALL_MR_WITH_DRUGS)
	public ResponseEntity<List<MedicalRepresentative>> getAllMR() {
		try {
			List<MedicalRepresentative> list = mRService.getAllMR();
			return new ResponseEntity<List<MedicalRepresentative>>(list, OK);

		} catch (Exception e) {
			return new ResponseEntity<List<MedicalRepresentative>>(NOT_FOUND);
		}

	}

	@GetMapping(GET_MR_BY_ID)

	public ResponseEntity<MedicalRepresentative> getMRByID(@PathVariable("id") Integer id) {
		try {
			MedicalRepresentative medicalRepresentative = mRService.getMRById(id);

			return new ResponseEntity<MedicalRepresentative>(medicalRepresentative, OK);

		} catch (Exception e) {
			return new ResponseEntity<MedicalRepresentative>(NOT_FOUND);
		}

	}

	@DeleteMapping(DELETE_BY_ID)
	public ResponseEntity<Object> deleteTutorial(@PathVariable("id") Integer id) {
		try {
			mRService.deleteMRById(id);
			return new ResponseEntity<Object>(DELETE, HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity<Object>(DELETE_FAILED, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(UPDATE_MR)
	public ResponseEntity<Object> updateMR(@PathVariable("id") Integer id,
			@RequestBody MedicalRepresentative medicalRepresentative) {

		boolean isUpdate = mRService.updateMR(id, medicalRepresentative);
		if (isUpdate) {
			return new ResponseEntity<Object>(UPDATED, CREATED);

		} else {

			return new ResponseEntity<Object>(UPDATE_FAILED, INTERNAL_SERVER_ERROR);

		}

	}
	

		@GetMapping(GET_MR_NAMES)
		public ResponseEntity<List<Response>> getJoinInformation() {
			try {
				List<Response> list = mRService.getJoinInformation();
				return new ResponseEntity<List<Response>>(list, OK);

			} catch (Exception e) {
				return new ResponseEntity<List<Response>>(NOT_FOUND);
			}

		}
		
	}
	
	
	


