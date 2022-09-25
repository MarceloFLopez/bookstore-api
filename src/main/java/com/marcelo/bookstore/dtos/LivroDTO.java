package com.marcelo.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.marcelo.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Campo TITULO é obrigatorio")
	@Length(min = 3, max = 50, message = "Campo TITULO deve ter pelo menos 3 caracteres e no maximo 100")
	private String titulo;

	public LivroDTO(Livro obj) {
		super();
		this.titulo = obj.getTitulo();
		this.id = obj.getId();
	}

	public LivroDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
