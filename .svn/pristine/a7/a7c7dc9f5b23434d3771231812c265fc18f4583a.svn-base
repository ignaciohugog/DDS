package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import util.fecha.Fecha;
import util.fecha.Hora;
import domain.exception.FormatoDeFechaIncorrectoException;
import domain.exception.FormatoDeHoraIncorrectoException;

public class UFecha
{
	
	
	private static Fecha parsearFecha(SimpleDateFormat formato, String strFecha)
	{	
		Fecha f = new Fecha();
		long tiempo;
		
		try
		{
			Date fecha = formato.parse(strFecha);
			tiempo = fecha.getTime();
			f.setTime(tiempo);
			return f;
		}
		catch(Exception ex)
		{
			throw new FormatoDeFechaIncorrectoException(ex);
		}
	
	}
	
	private static Hora parsearHora(SimpleDateFormat formato, String strHora)
	{	
		Hora h = new Hora();
		long tiempo;
		
		try
		{
			Date hora = formato.parse(strHora);
			tiempo = hora.getTime();
			h.setTime(tiempo);
			return h;
		}
		catch(Exception ex)
		{
			throw new FormatoDeHoraIncorrectoException(ex);
		}
	
	}
	
	
	public static Fecha convertirInternacional(String strFecha)
	{
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Fecha fecha = parsearFecha(formato, strFecha);
		
		return fecha;
	}
	
	public static Fecha convertirLatino(String strFecha)
	{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Fecha fecha = parsearFecha(formato, strFecha);
		
		return fecha;	
	}
	
	public static Fecha convertirNorteamericano(String strFecha)
	{
		SimpleDateFormat formato = new SimpleDateFormat("MM-dd-yyyy");
		Fecha fecha = parsearFecha(formato, strFecha);
		
		return fecha;		
	}
	
	
	
	public static Fecha convertirAFecha(String strFecha)
	{
		Fecha fecha;
		int pos = strFecha.indexOf('-');
		
		
		switch(pos)
		{
			case 4:
				fecha = convertirInternacional(strFecha);
				break;
				
			case 2:
				fecha = convertirNorteamericano(strFecha);
				break;

			default:
				fecha = convertirLatino(strFecha);
				break;
		}		
		
		return fecha;
	}
	
	public static long diasEntre(Date fecha1, Date fecha2)
	{
		boolean iguales;
		long dias;
		
		iguales = fecha1.compareTo(fecha2) == 0;
		
		if(iguales)
		{
			dias = 0;
		}
		else
		{
			dias = obtenerDias(fecha1, fecha2);
		}
		
		return dias;	
		
	}
	
	private static long obtenerDias(Date fecha1, Date fecha2)
	{
		long milisegundos;
		long dias;
		
		milisegundos = fecha2.getTime() - fecha1.getTime();
		dias = milisegundos/(1000*60*60*24);
		
		if(dias < 0)
		{
			dias = Math.abs(dias);
		}
		
		return dias;
	}
	
	
	public static boolean anteriorA(Date fecha1, Date fecha2)
	{
		return fecha1.compareTo(fecha2) < 0;
	}

	
	public static Hora convertirAHora(String strHora)
	{
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
		Hora hora = parsearHora(formato, strHora);
		
		return hora;		
	}
	
	public static long tiempoEntre(Date fecha1, Date hora1, Date fecha2, Date hora2)
	{
		long tiempo1 = 0;
		long tiempo2 = 0;
		long tiempoTotal;
		
		tiempo1 = fecha2.getTime() - fecha1.getTime();
		tiempo2 = hora2.getTime() - hora1.getTime();			
		
		tiempoTotal = tiempo1 + tiempo2;
		return tiempoTotal;
	}
	
}
