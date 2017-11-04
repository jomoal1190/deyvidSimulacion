package com.umg.econo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.umg.econo.dao.RespuestaBDanio;
import com.umg.econo.model.Registro;

public interface RegistroRepository extends CrudRepository<Registro, Long>{
	
	
	List<Registro> findByProducto(Long id);
	List<Registro> findAll();
	@Query("from Registro r where r.fechaCreacion=(select min(reg.fechaCreacion) from Registro reg)")
	List<Registro> findByRegistrosMinimo();
	
	
	
	@Query("from Registro r where r.fechaCreacion=(select max(reg.fechaCreacion) from Registro reg where reg.producto.id =?1)")
	List<Registro> findByRegistrosMaxProducto(Long producto);
	@Query("from Registro r where r.fechaCreacion=(select max(reg.fechaCreacion) from Registro reg)")
	List<Registro> findByRegistrosMaximo();
	
	
	 
      
		
	
//	@Query("select new map(year(r.fechaCreacion) as anio, "+
//			"sum(case when (r.fechaCreacion between per.inicio and per.fin) and per.monto<1 then ((r.cantidad*p.precio)-((r.cantidad*p.precio)-(r.cantidad*per.monto*p.precio))) "+
//			"when (r.fechaCreacion between per.inicio and per.fin) and per.monto>1 then ((r.cantidad*p.precio*per.monto)+((r.cantidad*p.precio*per.monto)-(r.cantidad*p.precio)))"+
//			"else (r.cantidad*p.precio) end) as total,  sum(r.cantidad) as suma)"+ 
//			"from PeriodoDeAfecto per, Registro r  inner join r.producto as p "+
//			"where year(r.fechaCreacion)=year(r.fechaCreacion) group by year(r.fechaCreacion) order by year(r.fechaCreacion) asc")
	@Query("select new map(year(r.fechaCreacion) as anio, date(r.fechaCreacion) as fecha,"+
			" (case when emp.porcentaje !=0 then ((r.cantidad*p.precio)-((r.cantidad*p.precio)-(r.cantidad*p.precio*emp.porcentaje)))"+
			" else (r.cantidad*p.precio) end) as total)"+
			" from Registro r"+
			" inner join r.producto as p"+
			" inner join r.empleado as emp order by year(r.fechaCreacion) desc")
	List<Map> parametrosAllPeriodo();
	

//	@Query("select new map(month(r.fechaCreacion) as mes, "+
//			"sum(case when (r.fechaCreacion between per.inicio and per.fin) and per.monto<1 then ((r.cantidad*p.precio)-((r.cantidad*p.precio)-(r.cantidad*per.monto*p.precio))) "+
//			"when (r.fechaCreacion between per.inicio and per.fin) and per.monto>1 then ((r.cantidad*p.precio*per.monto)+((r.cantidad*p.precio*per.monto)-(r.cantidad*p.precio)))"+
//			"else (r.cantidad*p.precio) end) as total,  sum(r.cantidad) as suma)"+ 
//			"from PeriodoDeAfecto per, Registro r  inner join r.producto as p "+
//			"where year(r.fechaCreacion)=year(curdate()) group by month(r.fechaCreacion) order by month(r.fechaCreacion) asc")
	@Query("select new map(month(r.fechaCreacion)  as mes, date(r.fechaCreacion) as fecha,"+
			" (case when emp.porcentaje !=0 then ((r.cantidad*p.precio)-((r.cantidad*p.precio)-(r.cantidad*p.precio*emp.porcentaje)))"+
			" else (r.cantidad*p.precio) end) as total)"+
			" from Registro r"+
			" inner join r.producto as p"+
			" inner join r.empleado as emp"+
			" where year(r.fechaCreacion)=year(curdate()) order by month(r.fechaCreacion) desc")
	List<Map> parametrosAllPeriodoActual();
	
//	@Query("select new map(year(r.fechaCreacion) as anio, "+
//			"sum(case when (r.fechaCreacion between per.inicio and per.fin) and per.monto<1 then ((r.cantidad*p.precio)-((r.cantidad*p.precio)-(r.cantidad*per.monto*p.precio))) "+
//			"when (r.fechaCreacion between per.inicio and per.fin) and per.monto>1 then ((r.cantidad*p.precio*per.monto)+((r.cantidad*p.precio*per.monto)-(r.cantidad*p.precio)))"+
//			"else (r.cantidad*p.precio) end) as total,  sum(r.cantidad) as suma)"+ 
//			"from PeriodoDeAfecto per, Registro r  inner join r.producto as p "+
//			"where year(r.fechaCreacion)=year(r.fechaCreacion) and p.id=?1 group by year(r.fechaCreacion) order by year(r.fechaCreacion) asc")
	@Query("select new map(year(r.fechaCreacion) as anio, date(r.fechaCreacion) as fecha,"+
			" (case when emp.porcentaje !=0 then ((r.cantidad*p.precio)-((r.cantidad*p.precio)-(r.cantidad*p.precio*emp.porcentaje)))"+
			" else (r.cantidad*p.precio) end) as total)"+
			" from Registro r"+
			" inner join r.producto as p"+
			" inner join r.empleado as emp where p.id=?1 order by year(r.fechaCreacion) desc")
	List<Map> parametrosAllPeriodoParametro(Long producto);
	
	
//	@Query("select new map(month(r.fechaCreacion) as mes, "+
//			"sum(case when (r.fechaCreacion between per.inicio and per.fin) and per.monto<1 then ((r.cantidad*p.precio)-((r.cantidad*p.precio)-(r.cantidad*per.monto*p.precio))) "+
//			"when (r.fechaCreacion between per.inicio and per.fin) and per.monto>1 then ((r.cantidad*p.precio*per.monto)+((r.cantidad*p.precio*per.monto)-(r.cantidad*p.precio)))"+
//			"else (r.cantidad*p.precio) end) as total,  sum(r.cantidad) as suma)"+ 
//			"from PeriodoDeAfecto per, Registro r  inner join r.producto as p "+
//			"where year(r.fechaCreacion)=year(r.fechaCreacion) and p.id=?1 group by month(r.fechaCreacion) order by month(r.fechaCreacion) asc")
	@Query("select new map(month(r.fechaCreacion)  as mes, date(r.fechaCreacion) as fecha,"+
			" (case when emp.porcentaje !=0 then ((r.cantidad*p.precio)-((r.cantidad*p.precio)-(r.cantidad*p.precio*emp.porcentaje)))"+
			" else (r.cantidad*p.precio) end) as total)"+
			" from Registro r"+
			" inner join r.producto as p"+
			" inner join r.empleado as emp"+
			" where year(r.fechaCreacion)=year(curdate()) and p.id=?1 order by month(r.fechaCreacion) desc")
	List<Map> parametrosPeriodoParametroActual(Long producto);
	
	@Query("select new map(year(r.fechaCreacion) as anio, sum(r.cantidad) as suma, sum(r.cantidad*p.precio) as total) from Registro r  inner join r.producto as p "
			+ "where year(r.fechaCreacion)=year(r.fechaCreacion) group by year(r.fechaCreacion) order by year(r.fechaCreacion) asc") 
	List<Map> findByParametrosAll();
	
	@Query("select new map(year(r.fechaCreacion) as anio, sum(r.cantidad) as suma, sum(r.cantidad*p.precio) as total) from Registro r  inner join r.producto as p "
			+ "where year(r.fechaCreacion)=year(r.fechaCreacion) and p.id=?1 group by year(r.fechaCreacion) order by year(r.fechaCreacion) asc") 
	List<Map> findByParametrosProducto(Long producto);
	
	@Query("select new map(month(r.fechaCreacion) as mes, sum(r.cantidad) as suma, sum(r.cantidad*p.precio) as total) from Registro r inner join r.producto as p "
			+ "where year(r.fechaCreacion)=year(curdate()) group by month(r.fechaCreacion) order by month(r.fechaCreacion) asc") 
	List<Map> findByParametrosActual();
	
	@Query("select new map(month(r.fechaCreacion) as mes, sum(r.cantidad) as suma, sum(r.cantidad*p.precio) as total) from Registro r inner join r.producto as p "
			+ "where year(r.fechaCreacion)=year(curdate()) and r.producto.id=?1  group by month(r.fechaCreacion) order by month(r.fechaCreacion) asc") 
	List<Map> findByParametrosActuaProductol(Long producto);
	
	
}
