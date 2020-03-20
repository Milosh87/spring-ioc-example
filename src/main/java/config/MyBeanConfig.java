package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


import repository.IRepository;
import service.MessageService;

import service.impl.MessageServiceImpl;


@ComponentScan(basePackages = {
		"repository",
		"service",
		"main"
})
public class MyBeanConfig {
	@Bean (name = "messageServiceTxt")
	public MessageService getMessageServiceTxt (@Qualifier("txtRepository")IRepository iRepository) {
		return new MessageServiceImpl(iRepository);
	}
	@Bean (name = "messageServiceXml")
	public MessageService getMessageServiceXml (@Qualifier("xmlRepository")IRepository iRepository) {
		return new MessageServiceImpl(iRepository);
	}
	
}
