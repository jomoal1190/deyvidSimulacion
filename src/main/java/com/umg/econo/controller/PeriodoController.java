package com.umg.econo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.umg.econo.model.Categoria;
import com.umg.econo.model.Empleado;
import com.umg.econo.model.PeriodoDeAfecto;
import com.umg.econo.repository.CategoriaRepository;
import com.umg.econo.service.ServiceWeb;

@Controller
public class PeriodoController {
	
	private static Logger logger = LoggerFactory.getLogger(PeriodoController.class);
	@Autowired ServiceWeb servicioWeb;
	@Autowired CategoriaRepository categoriaRepository;
	private static final String CODIGO_CORRECTO = "001";
	private static final String CODIGO_INCORRECTO= "000";
	
	@RequestMapping(value= {"/periodo/listPeriodo", "listPeriodo"}, method=RequestMethod.GET)
	public String getAllPeriodos(Model model)
	{
		List<PeriodoDeAfecto> periodo = servicioWeb.getAllPeriodos();
		List<Categoria> categoria = new ArrayList<Categoria>();
		categoria = categoriaRepository.findAll();
		model.addAttribute("categoria", categoria);
		model.addAttribute("periodo",periodo);
		return "/periodo/listPeriodo";
	}

	@RequestMapping(value="/createPeriodo", method=RequestMethod.GET)
	public String insertarPeriodo(Model model)
	{
		List<Categoria> categoria = new ArrayList<Categoria>();
		categoria = categoriaRepository.findAll();
		model.addAttribute("categoria", categoria);
		return "/periodo/createPeriodo";
	}
	
	
	@RequestMapping(value="/periodo/eliminarPeriodo", method=RequestMethod.POST)
	public @ResponseBody  String eliminarPeriodo(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes)
	{
		String respuesta = servicioWeb.deletePeriodo(request, response);
		return respuesta;
	}
	
	
	@RequestMapping(value = "/createPeriodo", method = RequestMethod.POST)
	 public String agregarPeriodo(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) throws ParseException {
		
		String respuesta = servicioWeb.createPeriodo(request, response);
		if(respuesta.equals(CODIGO_INCORRECTO))
		{
			logger.info("Error en metodo guardar periodo metodo");
		}
		else {
			logger.info("Empleado guardado");
		}
		
		return "redirect:/listPeriodo";
		
	}
	@RequestMapping(value="/getPeriodo", method=RequestMethod.GET)
	public @ResponseBody PeriodoDeAfecto getPeriodoId(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		PeriodoDeAfecto periodo = new PeriodoDeAfecto();
		
		periodo = servicioWeb.getPeriodoId(request, response);
		
		Float monto = periodo.getMonto();
		if(monto<1)
		{
			monto = (monto-1)*100;
		}
		else
		{
			monto = (1-monto)*-100;
		}
		logger.info("Periodo cAtegoria "+periodo.getCategoria());
		periodo.setMonto((float) Math.round(monto));
		logger.info("Monto enviar update "+monto);
		return periodo;
	}
	@RequestMapping(value="/updatePeriodo", method = RequestMethod.POST)
	public String updatePeriodo(HttpServletRequest request, HttpServletResponse response) throws ParseException
	{
		String respuesta = servicioWeb.updatePeriodo(request, response);
		return "redirect:/listPeriodo";
		
	}
	
}
