package com.kf2y.tcool.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf2y.tcool.domain.Operation;
import com.kf2y.tcool.exception.ResourceNotFoundException;
import com.kf2y.tcool.model.Amount;
import com.kf2y.tcool.service.OperationServiceImpl;

@RestController
@RequestMapping("/api/operations")
public class OperationController {

	@Autowired
	private OperationServiceImpl operationService;
	
	/************************** Get operation *************************/
	@GetMapping("/{id}")
	public Operation getOperationById(@PathVariable Long id) {
		return operationService.getOperationByIg(id);
	}
	
	/************************** save operation ***************************/
	@PostMapping("/save")
	public Operation saveOperation(@RequestBody Operation op) {
		return operationService.saveOperation(op);
	}
	
	/*************************** delete operation*********************************/
	@Transactional
	@DeleteMapping("/delete/{id}")
	public void deletOperation(@PathVariable Long id) {
		operationService.deleteOperation(id);
	}
	
	/**************************** update operation ***************************/
	@Transactional
	@PutMapping("/update/{id}")
	public Operation updateOperation(@PathVariable Long id, @RequestBody Operation op) 
		throws ResourceNotFoundException{
		Operation temp = operationService.getOperationByIg(op.getIdOperation());
		if(temp == null) throw new ResourceNotFoundException("Operation not found on :: " + id);
		
		temp = op;
		final Operation updatedOperation = operationService.saveOperation(temp);
		
		return updatedOperation;
	}
	
	/********************************** get all operations *************************/
	@GetMapping("/all")
	public List<Operation> getAll(){
		return operationService.getAllOperations();
	}
	
	/*************************** get all credits operations *************************/
	@GetMapping("/credits-operations")
	public List<Operation> getAllCreditsOp(){
		return operationService.getCreditOperations();
	}
	
	/***************************** get all debits operations *****************************/
	@GetMapping("/debits-operations")
	public List<Operation> getAllDebitsOp(){
		return operationService.getDebitOperations();
	}
	
	/*********************** get total amount of each operation ***********************/
	@GetMapping("/get-amounts")
	public Amount getAmounts() {
		return operationService.getAmountsOperations();
	}
}
