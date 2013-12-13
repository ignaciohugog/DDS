package mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.oceanic.AerolineaOceanic;
import com.oceanic.AsientoDTO;

public class AerolineaOceanicMock extends AerolineaOceanic
{
	private List<AsientoDTO> asientos = new ArrayList<AsientoDTO>();;

	public static AerolineaOceanicMock getInstance()
	{
		return new AerolineaOceanicMock();
	}

	public AerolineaOceanicMock()
	{
		List<AsientoDTO> coleccionDeAsientosDTO = new ArrayList<AsientoDTO>();

		AsientoDTO asiento1 = new AsientoDTO("OC100", 10, "20/08/2012", "21/08/2012", "12:00", "08:00", new BigDecimal(700.0), "Ejecutiva", "Pasillo", false, "_BS", "SLA");
		AsientoDTO asiento2 = new AsientoDTO("OC100", 11, "20/08/2012", "21/08/2012", "12:00", "08:00", new BigDecimal(700.0), "Ejecutiva", "Pasillo", false, "_BS", "SLA");
		AsientoDTO asiento3 = new AsientoDTO("OC100", 12, "20/08/2012", "21/08/2012", "12:00", "08:00", new BigDecimal(700.0), "Ejecutiva", "Pasillo", false, "_BS", "SLA");

		coleccionDeAsientosDTO.add(asiento1);
		coleccionDeAsientosDTO.add(asiento2);
		coleccionDeAsientosDTO.add(asiento3);

		asientos = coleccionDeAsientosDTO;
	}

	@Override
	public List<AsientoDTO> asientosDisponiblesParaOrigen(String origen, String fechaDeSalida)
	{
		return this.getAsientos();
	}

	@Override
	public List<AsientoDTO> asientosDisponiblesParaOrigenYDestino(String origen, String destino, String fechaDeSalida)
	{
		return this.getAsientos();
	}

	@Override
	public Boolean comprarSiHayDisponibilidad(String dni, String codigoVuelo, Integer numeroDeAsiento)
	{
		if(codigoVuelo.equals("OC100"))
		{
			return true;
		}
		if(codigoVuelo.equals("Asiento no disponible"))
		{
			return false;
		}
		if(codigoVuelo.equals("Asiento inexistente"))
		{
			return false;
		}

		throw new RuntimeException("El test esta mal hecho, codigo de asiento inesperado");
	}

	@Override
	public Boolean reservar(String dni, String codigoDeVuelo, Integer numeroDeAsiento)
	{
		if(codigoDeVuelo.equals("OC100"))
		{
			return true;
		}
		if(codigoDeVuelo.equals("Asiento no disponible"))
		{
			return false;
		}
		if(codigoDeVuelo.equals("Asiento inexistente"))
		{
			return false;
		}

		throw new RuntimeException("El test esta mal hecho, codigo de asiento inesperado");
	}

	
	//Getters & Setters
	
	public List<AsientoDTO> getAsientos()
	{
		return asientos;
	}

	public void setAsientos(List<AsientoDTO> asientos)
	{
		this.asientos = asientos;
	}
}
