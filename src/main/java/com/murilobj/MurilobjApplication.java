package com.murilobj;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.murilobj.domain.Categoria;
import com.murilobj.domain.Produto;
import com.murilobj.repositories.CategoriaRepository;
import com.murilobj.repositories.ProdutoRepository;

@SpringBootApplication
public class MurilobjApplication implements CommandLineRunner {

	@Autowired	
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MurilobjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria ("Informática", null);
		Categoria cat2 = new Categoria ("Escritório",null );
		
		Produto p1 = new Produto(null, "Computer", 2000.00);
		Produto p2 = new Produto(null, "Printer", 800.00);
		Produto p3 = new Produto(null, "Mouse", 70.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));		
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
