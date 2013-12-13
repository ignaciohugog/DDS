package util.fecha;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha extends Date
{		
	
	public String toString()
	{
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		return formatoFecha.format(this);
	}
	
	public String aLatinoamericano()
	{
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		return formatoFecha.format(this);
	}
	
	public String aInternacional()
	{
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		return formatoFecha.format(this);
	}
	
	public String aNorteamericano()
	{
		SimpleDateFormat formatoFecha = new SimpleDateFormat("MM-dd-yyyy");
		return formatoFecha.format(this);
	}
}
