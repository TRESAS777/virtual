package com.virtual.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtual.domain.entities.ClassEntity;
import java.util.List;


@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

    @Query("select u from class u where u.name = ?1")
    List<ClassEntity> findByName(String name);

    @Query("select u from class u where u.description = ?1")
    List<ClassEntity> findByDescription(String description);
    
}
