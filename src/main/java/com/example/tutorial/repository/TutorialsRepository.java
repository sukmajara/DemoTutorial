package com.example.tutorial.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tutorial.domain.Tutorial;

@Repository
public interface TutorialsRepository extends JpaRepository<Tutorial, BigInteger>{

    @Query(value = "SELECT max(id) as id, published, description, title FROM tutorials group by id order by id desc limit 1", nativeQuery = true)
    List<Tutorial> findNewestId();
    
    @Query(value = "SELECT * FROM tutorials WHERE published = true", nativeQuery = true)
    List<Tutorial> findPublished();
    
    @Query(value = "SELECT * FROM tutorials WHERE title LIKE %:title%", nativeQuery = true)
    List<Tutorial> findTitle(@Param("title") String title);
}
