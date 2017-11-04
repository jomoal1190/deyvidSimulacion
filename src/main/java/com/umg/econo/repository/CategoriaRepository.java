package com.umg.econo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.umg.econo.model.Categoria;



public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	
	Categoria findById(Long id);
	List<Categoria> findAll();

}
