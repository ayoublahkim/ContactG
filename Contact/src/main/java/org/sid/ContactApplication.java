package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactApplication implements CommandLineRunner{
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		// TODO Auto-generated method stub
		contactRepository.save(new Contact("lahkim", "ayoub", df.parse("05/01/1995"), "ayoublahkim@gmail.com", 0613704551, "ayoub.jpeg"));
		contactRepository.save(new Contact("fassi", "hamid", df.parse("04/08/1990"), "fassihamid@gmail.com", 0612456321, "hamid.jpeg"));
		contactRepository.save(new Contact("tazi", "karim", df.parse("19/02/1995"), "tazikarim@gmail.com", 0611236523, "karim.jpeg"));
		contactRepository.findAll().forEach(c->
		{
			System.out.println(c.getNom());
		});
	}
}
