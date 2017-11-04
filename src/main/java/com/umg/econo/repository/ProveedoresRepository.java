package com.umg.econo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.umg.econo.model.Proveedor;

public interface ProveedoresRepository extends CrudRepository<Proveedor, Long>{
	
	@Query("Select pr from Categoria c inner join c.producto p inner join p.proveedor pr where c.id=?1)")
	List<Proveedor> findByCategoria(Long id);
	@Query("Select pr from Proveedor pr where pr.id=?1)")
	Proveedor finById(Long id);

}
