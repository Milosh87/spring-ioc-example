package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MyBeanConfig;
import repository.IRepository;
import service.MessageService;

@Component(value = "main")
public class Main {
	
	public static void main(String[] args) {
		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		Main main = container.getBean("main", Main.class);
//		main.annotationConfig();
		main.saveMessage("Gladan sam!!!", "txt", container);
		((AnnotationConfigApplicationContext)container).close();
	}

	private void annotationConfig() {
		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		IRepository txtRepository = (IRepository)container.getBean("txtRepository");
		txtRepository.save("My plain message!");
		
		IRepository xmlRepository = container.getBean("xmlRepository", IRepository.class);
		xmlRepository.save("My xml message!");
		
		((AnnotationConfigApplicationContext)container).close();
	}
	
	private void saveMessage(String message, String izbor, BeanFactory container) {
		//1. u zavisnosti od uslova cuvamo poruku u txt ili u xml 
		
		MessageService messageService = null;
		if(izbor.equals("xml")) {
			 messageService = 
					container.getBean("messageServiceXml", MessageService.class);
		} else {
			 messageService = 
					container.getBean("messageServiceTxt", MessageService.class);
		}
		messageService.save(message);

	}
}
