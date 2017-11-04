package com.umg.econo.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.umg.econo.objetosCalculos.CalculoFuncionCuadratica;
import com.umg.econo.objetosCalculos.CalculoMinimosCuadrados;
import com.umg.econo.objetosCalculos.CalculoRegresionLineal;
import com.umg.econo.objetosCalculos.RespuestaFuncionCuadratica;
import com.umg.econo.objetosCalculos.RespuestaMinimos;
import com.umg.econo.objetosCalculos.RespuestaRegresionLineal;
import com.umg.econo.service.CalculosService;

import Jama.Matrix;
@Service
public class CalculosServiceImpl implements CalculosService{
	
	private static Logger logger = LoggerFactory.getLogger(CalculosServiceImpl.class);
	public RespuestaMinimos valoresMinimos(List<CalculoMinimosCuadrados> calculos)
	{
		RespuestaMinimos respuesta = new RespuestaMinimos();
		Float sumax= (float) 0.00;
		Float sumay=(float) 0.00;
		Float sumaxy=(float) 0.00;
		int sumax2=0;
		
		for(CalculoMinimosCuadrados cal: calculos)
		{
			
			sumax+=cal.getX();
			sumay+=cal.getY();
			sumaxy+=cal.getXy();
			sumax2+=cal.getX2();
			
		}
		
		Integer n = calculos.size();
		Float m = (float) (((n*sumaxy)-(sumax*sumay))/((n*sumax2)-(sumax*sumax)));
		Float b = (float) (((sumay*sumax2)-(sumax*sumaxy))/((n*sumax2)-(sumax*sumax)));
		respuesta.setValorm(m);
		respuesta.setValorb(b);
		return respuesta;
	}
	
	public RespuestaRegresionLineal valoresRegresion(List<CalculoRegresionLineal> calculos)
	{
		RespuestaRegresionLineal respuesta = new RespuestaRegresionLineal();
		Float sumax = (float) 0.00;
		Float sumay = (float) 0.00;
		Float sumay2 = (float) 0.00;
		Float sumax2 = (float) 0.00;
		Float sumaxy = (float) 0.00;
		
		for(CalculoRegresionLineal cal: calculos)
		{
			sumax +=cal.getX();
			sumay += cal.getY();
			sumax2 += cal.getX2();
			sumay2 += cal.getY2();
			sumaxy += cal.getXy();
		}
		
		Integer n = calculos.size();
	
		//Calculos de medias
		Float xmedia = sumax/n;
		Float ymedia = sumay/n;
		//Varianzas de desviaciones tipicas cuadradas
		Float varianzax2 = (sumax2/n)-(xmedia*xmedia);
		Float varianzay2 = (sumay2/n)-(ymedia*ymedia);
		//Varianzas de desviaciones tipicas
		Float varianzax = (float) Math.sqrt(varianzax2);
		Float varianzay = (float) Math.sqrt(varianzay2);
		//Covarianza xy
		Float covarianzaxy = (sumaxy/n)-(xmedia*ymedia);
		//Correlacion lineal de Pearson
		Float rpearson = (covarianzaxy)/(varianzax*varianzay);
		//Recta de regresion 
		Float b1 = (covarianzaxy/varianzax2);
		Float b2 = ymedia +((covarianzaxy/varianzax2)*(-xmedia));
		respuesta.setValorB1(b1);
		respuesta.setValorB2(b2);
		
		return respuesta;
	}
	// METODO DE VARIANZA MEDIA SIN USUAR
	public RespuestaRegresionLineal valoresRegresionCalculob(List<CalculoRegresionLineal> calculos)
	{
		RespuestaRegresionLineal respuesta = new RespuestaRegresionLineal();
		Float sumax = (float) 0.00;
		Float sumay = (float) 0.00;
		Float sumay2 = (float) 0.00;
		Float sumax2 = (float) 0.00;
		Float sumaxy = (float) 0.00;
		
		for(CalculoRegresionLineal cal: calculos)
		{
			sumax +=cal.getX();
			sumay += cal.getY();
			sumax2 += cal.getX2();
			sumay2 += cal.getY2();
			sumaxy += cal.getXy();
		}
		Integer n = calculos.size();
		//Calculos de medias
		Float xmedia = sumax/n;
		Float ymedia = sumay/n;
		//Varianzas de desviaciones tipicas cuadradas
		Float b = ((sumaxy)-(n*xmedia*ymedia))/((sumax2)-(n*xmedia*xmedia));
		Float a = ymedia - (b*xmedia);
		respuesta.setValorB1(b);
		respuesta.setValorB2(a);
		
		return respuesta;
	}
	
	
	public RespuestaFuncionCuadratica valoresFuncionCuadratica(List<CalculoFuncionCuadratica> calculos){
		RespuestaFuncionCuadratica respuesta = new RespuestaFuncionCuadratica();
		Float sumax = (float) 0.00;
		Float sumay = (float) 0.00;
		Float sumax2 = (float) 0.00;
		Float sumax3 = (float) 0.00;
		Float sumax4 = (float) 0.00;
		Float sumaxy = (float) 0.00;
		Float sumax2y = (float) 0.00;
		
		
		for(CalculoFuncionCuadratica cal: calculos)
		{
			sumax +=cal.getX();
			sumay += cal.getY();
			sumax2 += cal.getX2();
			sumax3 += cal.getX3();
			sumax4 += cal.getX4();
			sumaxy += cal.getXy();
			sumax2y += cal.getX2y();
		}
		Integer n = calculos.size();
		
		
        
		double[][] lhsArray = {{n, sumax, sumax2*n}, {sumax, sumax2, sumax3}, {sumax2, sumax3, sumax4}};
        double[] rhsArray = {sumay, sumaxy, sumax2y};
 
        Matrix lhs = new Matrix(lhsArray);
        Matrix rhs = new Matrix(rhsArray, 3);
 
        Matrix ans = lhs.solve(rhs);

        respuesta.setA((float) (ans.get(0, 0)));
        respuesta.setB( (float) (ans.get(1, 0)));
        respuesta.setC((float)  (ans.get(2, 0)));
        System.out.println("a = " + (ans.get(0, 0)));
        System.out.println("b = " + (ans.get(1, 0)));
        System.out.println("c = " + (ans.get(2, 0)));
		
		return respuesta;
	}
	public TreeMap<Integer,Float> unificarAnios(List<Map> mapa)
	{
		TreeMap<Integer,Float> sumas = new TreeMap<Integer,Float>();
		for(Map map: mapa)
		{
			if(sumas.containsKey(map.get("anio")))
			{	
				Float total = sumas.get(map.get("anio"));
				logger.info("total "+total);
				total= total+Float.parseFloat(map.get("total").toString());
				sumas.replace(Integer.parseInt(map.get("anio").toString()), total);
			}
			else {
				sumas.put(Integer.parseInt(map.get("anio").toString()),Float.parseFloat(map.get("total").toString()));
				logger.info("Valor "+sumas.size());
			}	
		}
		
		return sumas;
	}
	public TreeMap<Integer,Float> unificarMes(List<Map> mapa)
	{
		
		TreeMap<Integer,Float> sumas = new TreeMap<Integer,Float>();
		for(Map map: mapa)
		{
			if(sumas.containsKey(map.get("mes")))
			{	
				Float total = sumas.get(map.get("mes"));
				logger.info("total "+total);
				total= total+Float.parseFloat(map.get("total").toString());
				sumas.replace(Integer.parseInt(map.get("mes").toString()), total);
			}
			else {
				sumas.put(Integer.parseInt(map.get("mes").toString()),Float.parseFloat(map.get("total").toString()));
				logger.info("Valor "+sumas.size());
			}	
		}
		
		return sumas;
	}

}
