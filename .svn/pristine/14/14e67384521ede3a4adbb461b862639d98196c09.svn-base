package appModel.test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.model.AterrizarAppModel;
import domain.Asiento;
import domain.exception.AsientoSinSeleccionarException;
import domain.exception.FaltanCompletarCamposObligatoriosException;
import domain.exception.UsuarioNoDefinidoException;

public class AterrizarAppModelTest
{

	private AterrizarAppModel appModel;
	private AterrizarAppModel appModelSinParametros;
	
	
	@Before
	public void setUp() throws Exception
	{
		appModel = new AterrizarAppModel();

		appModel.setOrigen("Los Angeles");
		appModel.setDestino("Buenos Aires");
		appModel.setFechaSalida("13/09/2012");
		
		appModelSinParametros = new AterrizarAppModel();
		appModelSinParametros.setFechaSalida("13/09/2012");
		
	}
	

	@Test
	public void buscarTest()
	{
		appModel.buscar();
		Assert.assertNotNull("El resultado es nulo", appModel.getResultadoBusqueda());
	}
	
	@Test(expected = FaltanCompletarCamposObligatoriosException.class)
	public void buscarTeniendoParametrosSinDefinirTest()
	{
		appModelSinParametros.buscar();
	}
	
	
	
	@Test(expected = UsuarioNoDefinidoException.class)
	public void buscarSinTenerUsuarioDefinido()
	{
		appModel.setUsuario(null);
		appModel.buscar();
	}

	
	
	@Test
	public void comprarTest()
	{
		appModel.buscar();
		for(Asiento unAsiento : appModel.getResultadoBusqueda())
		{
			if(unAsiento.getNumeroAsiento() == 21)
			{
				appModel.setAsientoSeleccionado(unAsiento);
			} 
		}
		
		appModel.comprar();
	}
	
	@Test(expected = AsientoSinSeleccionarException.class)
	public void comprarTeniendoParametrosSinDefinirTest()
	{
		appModelSinParametros.comprar();
	}
	
	
	
	@Test(expected = UsuarioNoDefinidoException.class)
	public void comprarSinTenerUsuarioDefinido()
	{
		appModel.setUsuario(null);
		appModel.comprar();
	}
	
	
	
	@Test
	public void reservarTest()
	{
		appModel.buscar();
		
		for(Asiento unAsiento : appModel.getResultadoBusqueda())
		{
			if(unAsiento.getNumeroAsiento() == 26)
			{
				appModel.setAsientoSeleccionado(unAsiento);
			} 
		}
		
		appModel.reservar();
	}
	
	
	
	@Test(expected = AsientoSinSeleccionarException.class)
	public void reservarTeniendoParametrosSinDefinirTest()
	{
		appModelSinParametros.reservar();
	}

	
	
	@Test(expected= UsuarioNoDefinidoException.class)
	public void reservarSinTenerUsuarioDefinido()
	{
		appModel.setUsuario(null);
		appModel.reservar();
	}
	

}
