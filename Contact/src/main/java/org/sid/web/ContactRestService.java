package org.sid.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestService {
	@Autowired
private ContactRepository contactRepository;
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContacts()
	{
		return contactRepository.findAll();
	}
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public Contact getContact(@PathVariable Long id)
	{
		return contactRepository.findOne(id);
	}
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact c)
	{
		return contactRepository.save(c);
	}
}
