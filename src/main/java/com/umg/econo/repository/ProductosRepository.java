package com.umg.econo.repository;





import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.umg.econo.model.Producto;


public interface ProductosRepository extends CrudRepository<Producto, Long>{
	
	Producto findById(Long id);
	
	List<Producto> findByProveedorId(Long id);
	
	

}
