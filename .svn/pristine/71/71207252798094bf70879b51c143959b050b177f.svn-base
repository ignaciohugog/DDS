package criteriosDeOrdenamiento.imple;

import java.util.Comparator;

import criterioDeOrdenamiento.CriterioDeOrdenamiento;

import util.UFecha;
import util.fecha.Fecha;
import util.fecha.Hora;
import domain.Asiento;

public class CriterioTiempoDeVuelo extends CriterioDeOrdenamiento implements Comparator
{

	@Override
	public int compare(Object o1, Object o2)
	{
		Asiento asiento1 = (Asiento) o1;
		Asiento asiento2 = (Asiento) o2;
		
		long tiempo1 = UFecha.tiempoEntre(asiento1.getFechaSalida(), asiento1.getHoraSalida(), asiento1.getFechaLlegada(), asiento1.getHoraLlegada());
		long tiempo2 = UFecha.tiempoEntre(asiento2.getFechaSalida(), asiento2.getHoraSalida(), asiento2.getFechaLlegada(), asiento2.getHoraLlegada());
		
		return (int) (tiempo1 - tiempo2);
	}

}
