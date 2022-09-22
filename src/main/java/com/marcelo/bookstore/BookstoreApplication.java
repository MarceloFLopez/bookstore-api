package com.marcelo.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcelo.bookstore.domain.Categoria;
import com.marcelo.bookstore.domain.Livro;
import com.marcelo.bookstore.repository.CategoriaRepository;
import com.marcelo.bookstore.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	@Autowired 
	private CategoriaRepository catrepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren Ipsun", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
				
		this.catrepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
		
		
	}

}
