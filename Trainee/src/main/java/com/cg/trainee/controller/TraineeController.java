package com.cg.trainee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.trainee.Exception.IDInvalidException;
import com.cg.trainee.bean.Trainee;
import com.cg.trainee.service.TraineeService;

@RestController
@RequestMapping("/tr")
//@CrossOrigin("http://localhost:4200")
public class TraineeController {
	@Autowired
	TraineeService ts;
	
	@PostMapping("/addTrainee")
	public ResponseEntity<String> addTrainee(@RequestBody Trainee t){
		Trainee a=ts.addTrainee(t);
		if(a==null) {
			throw new IDInvalidException("enter valid id");
		}
		else {
			return new ResponseEntity<String>("Trainee added succesfully",new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/getbyID/{id}")
	private ResponseEntity<Trainee> getTraineeById(@PathVariable("id")int id){
		Trainee a=ts.getTraineeById(id);
		if(a==null) {
			throw new IDInvalidException("This ID doesn't exist");
		}
		else
			return new ResponseEntity<Trainee>(a,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	private ResponseEntity<List<Trainee>> getAll(){
		List<Trainee> l=ts.getAll();
		return new ResponseEntity<List<Trainee>>(l,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/upt")
	public ResponseEntity<String> updateTrainee(@RequestBody Trainee t){
		Trainee a=ts.updateTrainee(t);
		if(a==null) {
			throw new IDInvalidException("This ID doesn't exist, so we can't update");
		}
		else
			return new ResponseEntity<String>("Updated successfully",new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{id}")
	private ResponseEntity<String> deleteTrainee(@PathVariable("id") int id){
		Trainee a=ts.deleteById(id);
		if(a==null) {
			throw new IDInvalidException("This ID doesn't exist, so we can't delete");
		}
		else {
			return new ResponseEntity<String>("Deleted successfully",new HttpHeaders(),HttpStatus.OK);
		}
	}
	
	@ExceptionHandler(IDInvalidException.class)
	public ResponseEntity<String> notFound(IDInvalidException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
