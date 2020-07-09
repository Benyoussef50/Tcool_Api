package com.kf2y.tcool.service;

import java.util.List;

import com.kf2y.tcool.domain.Operation;
import com.kf2y.tcool.model.Amount;

public interface OperationService {

	public Operation getOperationByIg(Long id);
	public Operation saveOperation(Operation op);
	public void deleteOperation(Long id);
	public List<Operation> getAllOperations();
	public List<Operation> getDebitOperations();
	public List<Operation> getCreditOperations();
	public Amount getAmountsOperations();
}
