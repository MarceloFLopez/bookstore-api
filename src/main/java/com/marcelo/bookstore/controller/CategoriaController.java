package com.marcelo.bookstore.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.bookstore.domain.Categoria;
import com.marcelo.bookstore.repository.CategoriaRepository;
import com.marcelo.bookstore.service.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository catRepository;

	@RequestMapping("/listar")
	public List<Categoria> listAll() {
		List<Categoria> categorias = catRepository.findAll();
		return categorias;
	}

	@GetMapping("/{id}")
	public Categoria findById(@PathVariable Integer id) {
		Optional<Categoria> categoria = catRepository.findById(id);
		return categoria.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! id: "+id+", tipo"+Categoria.class.getName()));
	}

	@PostMapping
	public Categoria save(@RequestBody Categoria categoria) {
		Categoria cadastroSalvar = catRepository.save(categoria);
		return cadastroSalvar;
	}

	@DeleteMapping("delete/{id}")
	public Optional<Categoria> delete(@PathVariable Integer id) {
		Optional<Categoria> categoria = null;
		try {
			categoria = catRepository.findById(id);
			catRepository.delete(categoria.get());
		} catch (ConstraintViolationException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (DataIntegrityViolationException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return categoria;
	}

	@PutMapping
	public Categoria update(@RequestBody Categoria categoria) {
		try {
			catRepository.save(categoria);
		} catch (ConstraintViolationException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (DataIntegrityViolationException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return categoria;
	}
}
