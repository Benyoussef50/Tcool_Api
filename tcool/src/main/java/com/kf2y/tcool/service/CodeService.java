package com.kf2y.tcool.service;

import com.kf2y.tcool.domain.Code;

public interface CodeService {

	
	public Code save(Code c);
	public void delete(Long id);
	public Code getById(Long id);
	public Code getByCode(String content);
}
