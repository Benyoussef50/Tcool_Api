package com.kf2y.tcool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kf2y.tcool.domain.Code;

import com.kf2y.tcool.repository.CodeRepository;

@Service
@Transactional
public class CodeServiceImpl implements CodeService{
	
	@Autowired
	private CodeRepository codeRepo;

	@Override
	public Code save(Code c) {
		// TODO Auto-generated method stub
		return codeRepo.save(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Code getById(Long id) {
		// TODO Auto-generated method stub
		Code code = codeRepo.findById(id).orElse(null);
		if(code == null) {
			throw new RuntimeException("Code avec id= "+id+" introuvable!");
			}  else return code;
		}

	@Override
	public Code getByCode(String content) {
		// TODO Auto-generated method stub
		
		return codeRepo.findByCode(content);
		}
	}
	
