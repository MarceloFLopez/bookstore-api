package com.marcelo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.bookstore.domain.Categoria;
import com.marcelo.bookstore.domain.Livro;
import com.marcelo.bookstore.repository.LivroRepository;
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

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);

	}
	
	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updadteDate(newObj, obj);
		return repository.save(newObj);
	}

	private void updadteDate(Livro newObj, Livro obj) {
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
		newObj.setTitulo(obj.getTitulo());
	}

	public void delete(Integer id) {
		Livro obj = findById(id);
		repository.delete(obj);
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

}
