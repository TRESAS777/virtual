package com.virtual.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtual.domain.entities.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
    
} 
