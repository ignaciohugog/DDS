package domain.asiento.clase;

import domain.Clase;

public class ClaseTurista extends Clase
{
	public ClaseTurista()
	{
		this.setNombreClase("Turista");
	}
	
	public boolean esSuperOferta(double precio)
	{
		return false;
	}
	
}
