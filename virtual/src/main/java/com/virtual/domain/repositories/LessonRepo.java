package com.virtual.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtual.domain.entities.Lesson;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long>{
    
}