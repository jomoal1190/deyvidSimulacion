package com.umg.econo.service;

import java.text.ParseException;
import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umg.econo.dao.ObtenerParametroGenerico;
import com.umg.econo.dao.RespuestaBDanio;
import com.umg.econo.dao.RespuestaGeneralDao;
import com.umg.econo.dao.RespuestaParametroDao;
import com.umg.econo.model.Empleado;
import com.umg.econo.model.PeriodoDeAfecto;
import com.umg.econo.model.Producto;
import com.umg.econo.model.Registro;
import com.umg.econo.model.RegistrosAlterados;


public interface ServiceWeb {
	
	public RespuestaParametroDao<Registro> getAllRegistros(ObtenerParametroGenerico<Registro> registro);
	public RespuestaParametroDao<Producto> getAllProdcutos(ObtenerParametroGenerico<Producto> producto);
	public RespuestaGeneralDao insertExcel(ObtenerParametroGenerico<Producto> producto);
	public RespuestaGeneralDao insertExcelRegistro(ObtenerParametroGenerico<Registro> producto);
	public RespuestaGeneralDao insertRegistro(ObtenerParametroGenerico<Registro> registro);
	public List<Map> getConsulta(HttpServletRequest request, HttpServletResponse response);
	public String insertEmpleado(HttpServletRequest request, HttpServletResponse response);
	public List<Empleado> getAllEmpleados();
	public String deleteEmpleado(HttpServletRequest request, HttpServletResponse response);
	public String updateEmpleado(HttpServletRequest request, HttpServletResponse response);
	public Empleado getEmpleado(HttpServletRequest request, HttpServletResponse response);
	public List<PeriodoDeAfecto> getAllPeriodos();
	public String createPeriodo(HttpServletRequest request, HttpServletResponse response) throws ParseException;
	
	public List<Registro> getAllRegistro();
	public String deletePeriodo(HttpServletRequest request, HttpServletResponse response);
	public void createRegistrosAlterados(List<RegistrosAlterados> registros);
	public PeriodoDeAfecto getPeriodoId(HttpServletRequest request, HttpServletResponse response);
	public String updatePeriodo(HttpServletRequest request, HttpServletResponse response) throws ParseException;
	public List<Map> getConsultaPerido(HttpServletRequest request, HttpServletResponse response);

}
