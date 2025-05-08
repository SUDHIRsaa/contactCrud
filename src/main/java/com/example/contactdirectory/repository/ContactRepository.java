package com.example.contactdirectory.repository;

import com.example.contactdirectory.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    
    List<Contact> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName, String lastName);
    
    List<Contact> findByEmailContainingIgnoreCase(String email);
    
    List<Contact> findByPhoneNumberContaining(String phoneNumber);
    
    @Query("SELECT c FROM Contact c WHERE " +
           "LOWER(c.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(c.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "LOWER(c.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
           "c.phoneNumber LIKE CONCAT('%', :searchTerm, '%')")
    List<Contact> searchContacts(@Param("searchTerm") String searchTerm);
    
    boolean existsByEmail(String email);
} 