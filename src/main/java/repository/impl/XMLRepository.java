package repository.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import repository.IRepository;

@Repository(value = "xmlRepository")
public class XMLRepository  implements IRepository{
	public void save(String message) {
		System.out.println("<message>"+message+"</message>");
	}
}
