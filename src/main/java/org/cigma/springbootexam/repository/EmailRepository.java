package org.cigma.springbootexam.repository;

import org.cigma.springbootexam.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Mail, Long> {

}