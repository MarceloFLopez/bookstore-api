package com.marcelo.bookstore.resources;

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

import com.marcelo.bookstore.domain.Livro;
import com.marcelo.bookstore.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@RequestMapping("/listar")
	public List<Livro> listAll() {
		List<Livro> livros = livroRepository.findAll();
		return livros;
	}

	@GetMapping("/{id}")
	public Optional<Livro> findById(@PathVariable Integer id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro;
	}

	@PostMapping
	public Livro save(@RequestBody Livro livro) {
		Livro cadastroSalvar = livroRepository.save(livro);
		return cadastroSalvar;
	}

	@DeleteMapping("delete/{id}")
	public Optional<Livro> delete(@PathVariable Integer id) {
		Optional<Livro> livro = null;
		try {
			livro = livroRepository.findById(id);
			livroRepository.delete(livro.get());
		} catch (ConstraintViolationException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (DataIntegrityViolationException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return livro;
	}

	@PutMapping
	public Livro update(@RequestBody Livro livro) {
		try {
			livroRepository.save(livro);
		} catch (ConstraintViolationException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (DataIntegrityViolationException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return livro;
	}
}
