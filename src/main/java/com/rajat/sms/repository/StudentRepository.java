package com.rajat.sms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rajat.sms.model.Student;
public interface  StudentRepository extends JpaRepository<Student,Integer> {
    
}


