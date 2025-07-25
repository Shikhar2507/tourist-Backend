package com.telusko.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.Tourist;
import com.telusko.service.ITouristService;

@RestController
public class TouristController {

	private ITouristService service;

	@Autowired
	public void setService(ITouristService service) {
		this.service = service;
	}
	
	@PostMapping("/reg-tourist")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist)
	{
		String res = service.registerTourist(tourist);
		return new ResponseEntity<String>(res,HttpStatus.CREATED);
	}
	
	@GetMapping("/get-tourist/{id}")
	public ResponseEntity<Tourist> getTourist(@PathVariable Integer id)
	{
		Tourist tourist = service.fetchTouristById(id);
		return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
	}
	
	@GetMapping("/get-tourists")
	public ResponseEntity<List> fetchAllTouristInfo()
	{
		List<Tourist> tourists = service.fetchAllTouristInfo();
		return new ResponseEntity<List>(tourists,HttpStatus.OK) ;
	}
	
	@PutMapping("/update-tourist")
	public ResponseEntity<String> updateTouristInfo(@RequestBody Tourist tourist)
	{
		String res = service.updateTouristInfo(tourist);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@PatchMapping("update-budget/{id}/{budget}")
	public ResponseEntity<String> updateTheTouristBudget(@PathVariable Integer id,@PathVariable Double budget)
	{
		String res = service.updateTheTouristBudget(id, budget);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-tourist/{id}")
	public ResponseEntity<String> deleteTouristInfoById(@PathVariable Integer id)
	{
		String res = service.deleteTouristInfoById(id);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
}
