package com.example.demo.repository;

import com.example.demo.model.GenderName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderName,Integer> {


}
