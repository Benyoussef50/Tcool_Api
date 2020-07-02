package com.kf2y.tcool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kf2y.tcool.domain.Message;
import com.kf2y.tcool.repository.MessageRepository;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepo;
	
	@Override
	public Message save(Message msg) {
		// TODO Auto-generated method stub
		return messageRepo.save(msg);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		messageRepo.deleteById(id);
	}

}
