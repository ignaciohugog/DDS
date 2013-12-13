package domain.asiento.clase;

import domain.Clase;

public class ClaseEjecutiva extends Clase
{
	public ClaseEjecutiva()
	{
		this.setNombreClase("Ejecutivo");
	}
	
	public boolean esSuperOferta(double precio)
	{
		return precio < 4000;
	}
	
}
