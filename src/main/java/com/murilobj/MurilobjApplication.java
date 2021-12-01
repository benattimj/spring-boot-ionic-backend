package com.murilobj;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.murilobj.domain.Categoria;
import com.murilobj.repositories.CategoriaRepository;

@SpringBootApplication
public class MurilobjApplication implements CommandLineRunner {

	@Autowired	
	private CategoriaRepository categoriaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MurilobjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria ("Informática", null);
		Categoria cat2 = new Categoria ("Escritório",null );
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}

}
