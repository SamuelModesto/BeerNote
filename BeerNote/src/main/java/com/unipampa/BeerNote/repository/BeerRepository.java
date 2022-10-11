package com.unipampa.BeerNote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unipampa.BeerNote.model.Beer;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
    Beer findById(Integer id);
}
