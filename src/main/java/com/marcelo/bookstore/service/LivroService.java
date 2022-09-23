package com.marcelo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.marcelo.bookstore.domain.Livro;
import com.marcelo.bookstore.dtos.LivroDTO;
import com.marcelo.bookstore.repository.LivroRepository;
import com.marcelo.bookstore.service.exception.DataIntegriteViolationException;
import com.marcelo.bookstore.service.exception.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
	public Livro create(Livro obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Livro update(Integer id, LivroDTO objDto) {
		Livro obj = findById(id);
		obj.setTitulo(objDto.getTitulo());
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegriteViolationException("Livro não pode ser deletado! Possui livros associados.");
		}
		
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
		
	}
}
