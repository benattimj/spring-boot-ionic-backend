package com.murilobj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murilobj.domain.Categoria;

@Repository

public interface CategoriaRepository  extends JpaRepository<Categoria, Integer> {


	
}
