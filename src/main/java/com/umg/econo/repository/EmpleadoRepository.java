package com.umg.econo.repository;

import org.springframework.data.repository.CrudRepository;

import com.umg.econo.model.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long>{
 
	Empleado findById(Long id);
}
