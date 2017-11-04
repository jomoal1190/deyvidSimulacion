package com.umg.econo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.umg.econo.model.PeriodoDeAfecto;

public interface PeriodoRepository extends CrudRepository<PeriodoDeAfecto, Long>{
	List<PeriodoDeAfecto> findAll();
	
	PeriodoDeAfecto findById(Long id);

}
