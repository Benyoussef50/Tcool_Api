package com.kf2y.tcool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kf2y.tcool.domain.Operation;
import com.kf2y.tcool.repository.OperationRepository;

@Service
@Transactional
public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationRepository operationRepo;
	
	@Override
	public Operation getOperationByIg(Long id) {
		Operation op = operationRepo.findById(id).orElse(null);
		if(op == null) throw new RuntimeException("Operation not found on :: "+ id);
		return op;
	}

	@Override
	public Operation saveOperation(Operation op) {
		// TODO Auto-generated method stub
		return operationRepo.save(op);
	}

	@Override
	public void deleteOperation(Long id) {
		// TODO Auto-generated method stub
		operationRepo.deleteById(id);
	}

	@Override
	public List<Operation> getAllOperations() {
		// TODO Auto-generated method stub
		return operationRepo.findAll();
	}

	@Override
	public List<Operation> getDebitOperations() {
		// TODO Auto-generated method stub
		return operationRepo.findByTypeOp("DEBIT");
	}

	@Override
	public List<Operation> getCreditOperations() {
		// TODO Auto-generated method stub
		return operationRepo.findByTypeOp("CREDIT");
	}

}
