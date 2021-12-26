package com.murilobj.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murilobj.domain.Categoria;
import com.murilobj.domain.Produto;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Integer> {

	@Transactional
	List<Categoria> findByProdutosIn(List<Produto> produtos);
	
	
}
