package com.umg.econo.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.umg.econo.model.Empleado;
import com.umg.econo.service.ServiceWeb;
import com.umg.econo.serviceImpl.ServiceWebImpl;
@Controller
public class EmpleadoController {
	@Autowired ServiceWeb servicioWeb;
	private static final String CODIGO_CORRECTO = "001";
	private static final String CODIGO_INCORRECTO= "000";
	private static Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
	
	@RequestMapping(value="/createEmpleado", method=RequestMethod.GET)
	public String insertarRegistros(Model model)
	{
		return "/empleado/createEmpleado";
	}
	
	@RequestMapping(value = "/createEmpleado", method = RequestMethod.POST)
	 public String agregarEmpleado(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
		
		String respuesta = servicioWeb.insertEmpleado(request, response);
		if(respuesta.equals(CODIGO_INCORRECTO))
		{
			logger.info("Error en metodo guardar empleado metodo");
		}
		else {
			logger.info("Empleado guardado");
		}
		
		return "redirect:/listEmpleado";
		
	}
	@RequestMapping(value= {"/empleado/listEmpleado", "listEmpleado"}, method=RequestMethod.GET)
	public String getAllEmpleados(Model model)
	{
		List<Empleado> empleados = servicioWeb.getAllEmpleados();
		model.addAttribute("empleado",empleados);
		return "/empleado/listEmpleado";
	}
	@RequestMapping(value="/empleado/eliminarEmpleado", method = RequestMethod.POST)
	public @ResponseBody String deleteEmpleado(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes)
	{
		String respuesta = servicioWeb.deleteEmpleado(request, response);
		return respuesta;
		
	}
	@RequestMapping(value="/updateEmpleado", method = RequestMethod.POST)
	public String udpateEmpleado(HttpServletRequest request, HttpServletResponse response)
	{
		String respuesta = servicioWeb.updateEmpleado(request, response);
		return "redirect:/listEmpleado";
		
	}
	@RequestMapping(value= "/getEmpleado", method=RequestMethod.GET)
	public @ResponseBody Empleado updateInfoEmpleado(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		logger.info("Id "+request.getParameter("id"));
		Empleado empleado = servicioWeb.getEmpleado(request, response);
		
		model.addAttribute("empleado",empleado);
		logger.info("Nombre empleado "+empleado.getNombre());
		return empleado;
	}
	

}
