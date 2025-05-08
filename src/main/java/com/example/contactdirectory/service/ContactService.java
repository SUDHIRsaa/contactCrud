package com.example.contactdirectory.service;

import com.example.contactdirectory.model.Contact;
import java.util.List;

public interface ContactService {
    Contact createContact(Contact contact);
    Contact updateContact(Long id, Contact contact);
    void deleteContact(Long id);
    Contact getContactById(Long id);
    List<Contact> getAllContacts();
    List<Contact> searchContacts(String searchTerm);
    boolean existsByEmail(String email);
} 