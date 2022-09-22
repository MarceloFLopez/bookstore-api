package com.marcelo.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.bookstore.domain.Livro;

@Repository
public interface  LivroRepository extends JpaRepository<Livro, Integer>{

}
