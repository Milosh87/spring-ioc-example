package service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import repository.IRepository;
import service.MessageService;


public class MessageServiceImpl implements MessageService {
	private IRepository repository;
	
	
	public MessageServiceImpl(IRepository repository) {
		this.repository = repository;
	}

	
	
	public void save(String message) {
		repository.save(message);
	}
	
	/*
	@Autowired
	@Qualifier(value ="xmlRepository")
	*/
//	
//	@Resource(name = "xmlRepository")
//	public void setRepository(IRepository repository) {
//		this.repository = repository;
//	}
	
	
}
