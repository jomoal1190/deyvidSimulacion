package com.umg.econo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.umg.econo.model.RegistrosAlterados;

public interface RegistrosAlteradosRepository extends CrudRepository<RegistrosAlterados, Long>{

	List<RegistrosAlterados> findAll();
}
