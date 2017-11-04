package com.umg.econo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.umg.econo.dao.ObtenerParametroGenerico;
import com.umg.econo.dao.RespuestaGeneralDao;
import com.umg.econo.model.Categoria;
import com.umg.econo.model.Empleado;
import com.umg.econo.model.Producto;
import com.umg.econo.model.Proveedor;
import com.umg.econo.model.Registro;
import com.umg.econo.repository.CategoriaRepository;
import com.umg.econo.repository.EmpleadoRepository;
import com.umg.econo.repository.ProductosRepository;
import com.umg.econo.repository.ProveedoresRepository;
import com.umg.econo.service.ServiceWeb;


@Controller
public class ImportarController {
	private static Logger logger = LoggerFactory.getLogger(ImportarController.class);
	@RequestMapping(value="/unploadExcel", method=RequestMethod.GET)
    public String customerForm(Model model) {
	
        return "unploadExcel";
    }
	
	@Autowired ServiceWeb servicioWeb;
	@Autowired ProductosRepository productoRepository;
	@Autowired CategoriaRepository categoriaRepository;
	@Autowired ProveedoresRepository proveedorRepository;
	@Autowired EmpleadoRepository empleadoRepository;
	
	
	@PostMapping("/unploadExcel") 
    public String singleFileUpload(@RequestParam("excel") MultipartFile file, @RequestParam(value="opcion") int opcion,
                                   RedirectAttributes redirectAttributes, Model model) throws IOException, ParseException {
		
		model.addAttribute("tipo",opcion);
		System.out.println("Opcion "+opcion);
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("Mensajle", "Seleccione un Archivo");
            return "fail";
        }
        if(opcion==1)
        {
        	
            FileInputStream excelFile = (FileInputStream) file.getInputStream();
            
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            
            HashSet<Producto>  lista = new HashSet<>();
            ObtenerParametroGenerico<Producto> guardar = new ObtenerParametroGenerico<Producto>();
            while (iterator.hasNext()) {
            	
                Row nextRow = iterator.next();
                
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                int numRow = nextRow.getRowNum(); 
                int ultimaColumna=nextRow.getLastCellNum();
                Producto producto = new Producto();
                if(ultimaColumna==4)
                {
                	while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                      
                        	int numeroCelda =cell.getColumnIndex();
        	             	if(numRow>=1)
        	             	{
        	             		if(numeroCelda==0)
        	             		{
        	             			producto.setNombre(cell.getStringCellValue());
        	             		}
        	             		else if(numeroCelda==1)
        	             		{
        	             			 producto.setPrecio(cell.getNumericCellValue());
        	             		}
        	             		else if(numeroCelda==2)
        	             		{
        	             			Integer id= (int) cell.getNumericCellValue();
        	             			Categoria categoria = categoriaRepository.findById(Long.parseLong(id.toString()));
        	             			logger.info("Nombre de la categoria "+categoria.getDescripcion());
        	             			producto.setCategoria(categoria);
        	             		}
        	             		else if(numeroCelda==3)
        	             		{
        	             			Integer id= (int) cell.getNumericCellValue();
        	             			Proveedor proveedor = proveedorRepository.finById(Long.parseLong(id.toString()));
        	             			logger.info("Nombre del proveedor "+proveedor.getNombre());
        	             			producto.setProveedor(proveedor);
        	             		}
        	             		
        	             	 
        	             		 if(!lista.contains(producto)) {
        	                    	 lista.add(producto);
        	                    }
        	             	}
        	                	 
        	               
                        }
                }
                else {
                	model.addAttribute("tipo","no");
                	
                }
                
     
            }
            for(Producto enviar : lista)
            {
            	guardar.setParametro(enviar);
            servicioWeb.insertExcel(guardar);
            }
            model.addAttribute("objeto", lista);
            workbook.close();
            excelFile.close();
        }
        else if (opcion==2){
        	FileInputStream excelFile = (FileInputStream) file.getInputStream();
            
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            HashSet<Registro>  lista = new HashSet<>();
            ObtenerParametroGenerico<Registro> guardar = new ObtenerParametroGenerico<Registro>();
            while (iterator.hasNext()) {
            	
                Row nextRow = iterator.next();
              
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                int numRow = nextRow.getRowNum(); 
                
                Registro registro = new Registro();
                int ultimaColumna=nextRow.getLastCellNum();
                if(ultimaColumna==3)
                {
                	while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        int numeroCelda =cell.getColumnIndex();
        	             	if(numRow>=1)
        	             	{
        	             		if(numeroCelda==0)
        	             		{
        	             			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        	             			String fecha = formatoFecha.format(cell.getDateCellValue());
        	             			Date fechaEnviar = formatoFecha.parse(fecha);
        	             			
        	             			registro.setFechaCreacion(fechaEnviar);
        	             		}
        	             		else if(numeroCelda==1)
        	             		{
        	             			 registro.setCantidad((int) cell.getNumericCellValue());
        	             		}
        	             		else if(numeroCelda==2)
        	             		{
        	             			Producto producto = productoRepository.findOne((long) cell.getNumericCellValue());
        	             			registro.setProducto(producto);
        	             		}
        	             		else if(numeroCelda==3)
        	             		{
        	             			Empleado empleado = empleadoRepository.findById((long) cell.getNumericCellValue());
        	             			registro.setEmpleado(empleado);
        	             			
        	             		}
        	             		 if(!lista.contains(registro)) {
        	                    	 lista.add(registro);
        	                    }
        	             	}
        	                	     
        	               
                        }
                }
                else {
                	model.addAttribute("tipo","no");
                	
                }
                
     
            }
            for(Registro enviar : lista)
            {
            	guardar.setParametro(enviar);
            servicioWeb.insertExcelRegistro(guardar);
            }
            model.addAttribute("objeto", lista);
            workbook.close();
            excelFile.close();
        	
        }
        
        
        

		return "ImportesExcel";  


} 
	
}