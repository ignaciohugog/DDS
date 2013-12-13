package util.fecha;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hora extends Date
{		
	public String toString()
	{
		SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
		return formatoHora.format(this);
	}
	
}
