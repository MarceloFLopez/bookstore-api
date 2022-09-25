package com.marcelo.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.marcelo.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "Campo Nome é obrigatorio")
	@Length(min = 3, max = 100, message = "Campo NOME deve ter pelo menos 3 caracteres e no maximo 100")
	private String nome;
	@NotEmpty(message = "Campo Nome é obrigatorio")
	@Length(min = 3, max = 200, message = "Campo DESCRIÇÃO deve ter pelo menos 3 caracteres e no maximo 100")
	private String descricao;

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public CategoriaDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
