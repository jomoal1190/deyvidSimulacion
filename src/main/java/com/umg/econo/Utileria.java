package com.umg.econo;


import org.springframework.stereotype.Service;

@Service
public class Utileria {

	public String cambioMesLetras(String mes) {
		String espa=null;
		if(mes.equals("January"))
		{
			espa="Enero";
		}
		else if(mes.equals("February")) {
			espa="Febrero";
		}
		else if(mes.equals("March"))
		{
			espa="Marzo";
		}
		else if(mes.equals("April"))
		{
			espa="Abril";
		}
		else if(mes.equals("May"))
		{
			espa="Mayo";
		}
		else if(mes.equals("June"))
		{
			espa="Junio";
		}
		else if(mes.equals("July"))
		{
			espa="Julio";
		}
		else if(mes.equals("August"))
		{
			espa="Agosto";
		}
		else if(mes.equals("September"))
		{
			espa="Septiembre";
		}
		else if(mes.equals("October"))
		{
			espa="Ocutubre";
		}
		else if(mes.equals("November"))
		{
			espa="Noviembre";
		}
		else if(mes.equals("December"))
		{
			espa="Diciembre";
		}

		return espa;
	}
	
	public String cambioMesNumero(Integer mes) {
		String espa=null;
		if(mes==1)
		{
			espa="Ene";
		}
		else if(mes==2) {
			espa="Feb";
		}
		else if(mes==3)
		{
			espa="Mar";
		}
		else if(mes==4)
		{
			espa="Abr";
		}
		else if(mes==5)
		{
			espa="May";
		}
		else if(mes==6)
		{
			espa="Jun";
		}
		else if(mes==7)
		{
			espa="Jul";
		}
		else if(mes==8)
		{
			espa="Ago";
		}
		else if(mes==9)
		{
			espa="Sep";
		}
		else if(mes==10)
		{
			espa="Oct";
		}
		else if(mes==11)
		{
			espa="Nov";
		}
		else if(mes==12)
		{
			espa="Dic";
		}

		return espa;
	}
}
