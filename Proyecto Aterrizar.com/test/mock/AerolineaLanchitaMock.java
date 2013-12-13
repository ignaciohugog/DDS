package mock;

import com.lanchita.AerolineaLanchita;
import com.lanchita.excepciones.CodigoErroneoException;
import com.lanchita.excepciones.EstadoErroneoException;

public class AerolineaLanchitaMock extends AerolineaLanchita
{

	public static AerolineaOceanicMock getInstancia()
	{
		return new AerolineaOceanicMock();
	}
	
	public AerolineaLanchitaMock()
	{

	}

	@Override
	public String[][] asientosDisponibles(String origen, String destino, String fechaSalida, String horaSalida, String fechaLlegada, String horaLlegada)
	{
		// Vuelos de Buenos Aires (BUE) a Los Angeles (SLA), fechaSalida
		// 20/12/2012,
		// fechaLlegada 21/12/2012, horaSalida 14:00, horaLlegada 02:25
		String[][] asientos = { { "01202022220202-3", "159.90", "P", "V", "D", "", "14:00", "02:25", "BUE", "SLA", "20/12/2012", "21/12/2012" },
				{ "01202022220202-4", "160.90", "P", "V", "D", "", "14:00", "02:25", "BUE", "SLA", "20/12/2012", "21/12/2012" },
				{ "01202023482384-1", "159.90", "P", "V", "D", "", "14:00", "02:25", "BUE", "SLA", "20/12/2012", "21/12/2012" } };

		return asientos;
	}

	@Override
	public void comprar(String codigo)
	{
		if(codigo.equals("AsientoDisponible-0"))
		{
			// Todo bien, el asiento se pudo reservar entonces no hago nada
		}
		if(codigo.equals("Tira un EstadoErroneoException-0"))
		{
			throw new EstadoErroneoException();
		}
		if(codigo.equals("Tira un CodigoErroneoException-0"))
		{
			throw new CodigoErroneoException(codigo);
		}
	}

	@Override
	public void reservar(String codigo, String dni)
	{
		if(codigo.equals("AsientoDisponible-0"))
		{
			// Todo bien, el asiento se pudo reservar entonces no hago nada
		}
		if(codigo.equals("Tira un EstadoErroneoException-0"))
		{
			throw new EstadoErroneoException();
		}
		if(codigo.equals("Tira un CodigoErroneoException-0"))
		{
			throw new CodigoErroneoException(codigo);
		}
	}

}
