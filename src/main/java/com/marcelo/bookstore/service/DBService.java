package com.marcelo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.bookstore.domain.Categoria;
import com.marcelo.bookstore.domain.Livro;
import com.marcelo.bookstore.repository.CategoriaRepository;
import com.marcelo.bookstore.repository.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository catrepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public void instaciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Ficção Cientifica");
		Categoria cat3 = new Categoria(null, "Biografia", "Livros de Biografia");
		Categoria cat4 = new Categoria(null, "Programação", "Livros de Programação");
		Categoria cat5 = new Categoria(null, "Matemática", "Livros de Matemática");
		Categoria cat6 = new Categoria(null, "Português", "Livros de Português");
		Categoria cat7 = new Categoria(null, "Fisísca", "Livros de Fisísca");
		Categoria cat8 = new Categoria(null, "Excel", "Livros de Excel");
		Categoria cat9 = new Categoria(null, "Pacote Office", "Livros de Pacote Office");
		Categoria cat10 = new Categoria(null, "Windwos Server", "Livros de Windwos Server");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren Ipsun", cat1);
		Livro l2 = new Livro(null, "Engenharia de software", "Louis V. Grestner", "Loren Ipsun", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G. Well", "Loren Ipsun", cat2);
		Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Well", "Loren Ipsun", cat2);
		Livro l5 = new Livro(null, "Matemática Aplicadda", "Isaco Asimovv", "Loren Ipsun", cat5);
		Livro l6 = new Livro(null, "Português para leigos", "Isaco Asimovv", "Loren Ipsun", cat6);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4));
		cat5.getLivros().addAll(Arrays.asList(l5));
		cat6.getLivros().addAll(Arrays.asList(l6));

		this.catrepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9,cat10));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));
	}
}
