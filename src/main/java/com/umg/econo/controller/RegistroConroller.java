package com.umg.econo.controller;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umg.econo.dao.ObtenerParametroGenerico;
import com.umg.econo.dao.RespuestaGeneralDao;
import com.umg.econo.dao.RespuestaParametroDao;
import com.umg.econo.model.Producto;
import com.umg.econo.model.Registro;
import com.umg.econo.service.ServiceWeb;

import java.util.List;

import org.slf4j.Logger;

@Controller
public class RegistroConroller {
	
	private static Logger logger = LoggerFactory.getLogger(RegistroConroller.class);
	
	@Autowired  ServiceWeb servicioWeb;
	
	
	private static final String CODIGO_CORRECTO ="001";
	
	@RequestMapping("/")
	public String home(Model model) {
	
		return "index";
	}
	
	@GetMapping("/registrosAll")
	public ResponseEntity<List<Registro>> finAllRegistros(){
		ObtenerParametroGenerico<Registro> peticion = new ObtenerParametroGenerico<Registro>();
		RespuestaParametroDao<Registro> respuesta = servicioWeb.getAllRegistros(peticion);
		List<Registro> registro = respuesta.getLista();
		if(respuesta.getCodigo().equals(CODIGO_CORRECTO))
		{
			return new ResponseEntity<List<Registro>>(registro, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Registro>>(HttpStatus.BAD_REQUEST);
		}
	}
	 @RequestMapping(value="/insertRegistros", method=RequestMethod.POST)
	 public String getRegistros(@ModelAttribute Registro registro, Model model) {
		
		ObtenerParametroGenerico<Registro> enviar = new ObtenerParametroGenerico<Registro>();
		enviar.setParametro(registro);
		RespuestaGeneralDao respuesta = servicioWeb.insertRegistro(enviar);
		model.addAttribute("respuestaRegistro", respuesta.getCodigo());
		
		return "index";
	}
	 
	@RequestMapping(value="/insertRegistros", method=RequestMethod.GET)
    public String customerForm(Model model) {
		ObtenerParametroGenerico<Producto> peticion = new ObtenerParametroGenerico<Producto>();
		RespuestaParametroDao<Producto>  respuesta = servicioWeb.getAllProdcutos(peticion);
		
		model.addAttribute("registro", new Registro());
        model.addAttribute("producto", respuesta.getLista());
        return "insertRegistros";
    }
	
	

}
