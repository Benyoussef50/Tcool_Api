package com.kf2y.tcool.service;

import com.kf2y.tcool.domain.Message;

public interface MessageService {

	public Message save(Message msg);
	public void delete(Long id);

}
