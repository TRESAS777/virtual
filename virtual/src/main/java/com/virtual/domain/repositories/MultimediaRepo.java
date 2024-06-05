package com.virtual.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtual.domain.entities.Multimedia;

@Repository
public interface MultimediaRepo extends JpaRepository<Multimedia, Long>{
    
}
