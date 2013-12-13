package util.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import domain.exception.FormatoDeFechaIncorrectoException;
import domain.exception.FormatoDeHoraIncorrectoException;

import util.UFecha;
import util.fecha.Fecha;
import util.fecha.Hora;

public class UFechaTest
{
	Fecha fecha;
	Fecha fechaMasAntigua;
	Hora hora;
	String fechaInt;
	String fechaLat;
	String fechaNor;
	String strHora;
	String strFormatoErroneo;
	
	@Before
	public void setUp() throws Exception
	{
		long hoy = System.currentTimeMillis();
		long antesDeHoy = hoy - 1000000000;
		
		fecha = new Fecha();
		fecha.setTime(hoy);
		
		fechaMasAntigua = new Fecha();
		fechaMasAntigua.setTime(antesDeHoy);
		
		hora = new Hora();
		hora.setTime(hoy);
		
		fechaInt = "2011-02-20";
		fechaLat = "21/05/2010";
		fechaNor = "07-25-2012";
		strHora = "08:25";
		
		strFormatoErroneo = "hola soy una fecha con formato erroneo";	
	}

	@Test
	public void testConvertirStringFormatoInternacionalAFecha()
	{
		fecha = UFecha.convertirInternacional(fechaInt);
		Assert.assertTrue("La fecha deberia ser la misma" , fecha.aInternacional().equals(fechaInt));
	}
	
	@Test(expected=FormatoDeFechaIncorrectoException.class)
	public void testConvertirStringConFormatoInternacionalAFechaUsandoFormatoIncorrecto()
	{
		fecha = UFecha.convertirInternacional(strFormatoErroneo);
	}

	@Test
	public void testConvertirStringFormatoLatinoAFecha()
	{
		fecha = UFecha.convertirLatino(fechaLat);
		Assert.assertTrue("La fecha deberia ser la misma" , fecha.aLatinoamericano().equals(fechaLat));
	}
	
	@Test(expected=FormatoDeFechaIncorrectoException.class)
	public void testConvertirStringConFormatoLatinoAFechaUsandoFormatoIncorrecto()
	{
		fecha = UFecha.convertirLatino(strFormatoErroneo);
	}

	@Test
	public void testConvertirNorteamericano()
	{
		fecha = UFecha.convertirNorteamericano(fechaNor);
		Assert.assertTrue("La fecha deberia ser la misma" , fecha.aNorteamericano().equals(fechaNor));
	}
	
	@Test(expected=FormatoDeFechaIncorrectoException.class)
	public void testConvertirStringConFormatoNorteamericanoAFechaUsandoFormatoIncorrecto()
	{
		fecha = UFecha.convertirNorteamericano(strFormatoErroneo);
	}

	@Test
	public void testConvertirAFecha()
	{
		fecha = UFecha.convertirAFecha(fechaLat);
		Assert.assertTrue("La fecha deberia ser la misma", fecha.aLatinoamericano().equals(fechaLat));
	}
	
	@Test(expected=FormatoDeFechaIncorrectoException.class)
	public void testConvertirStringDeCualquierFormatoAceptableAFechaUsandoFormatoIncorrecto()
	{
		fecha = UFecha.convertirAFecha(strFormatoErroneo);
	}

	@Test
	public void testDiasEntreUnaFechaAntiguaYUnaActual()
	{
		long dias = UFecha.diasEntre(fechaMasAntigua, fecha);
		Assert.assertTrue("La cantidad de dias deberia ser mayor a 0", dias > 0);
	}
	
	@Test
	public void testDiasEntreDosFechasIguales()
	{
		long dias = UFecha.diasEntre(fecha, fecha);
		Assert.assertTrue("La cantidad de dias entre dos fechas iguales deberia ser 0", dias == 0);
	}
	
	@Test
	public void testDiasEntreDosFechasPoniendolasAlReves()
	{
		long dias = UFecha.diasEntre(fecha, fechaMasAntigua);
		Assert.assertTrue("La cantidad de dias entre las dos fechas deberia ser mayor a 0", dias > 0);
	}

	@Test
	public void testDemostrarQueLaPrimerFechaEsAnteriorALaSegunda()
	{
		Assert.assertTrue("El primer parametro deberia ser una fecha mas antigua que la segunda", UFecha.anteriorA(fechaMasAntigua, fecha));
	}
	
	@Test
	public void testDemostrarQueLaPrimerFechaNoEsAnteriorALaSegunda()
	{
		Assert.assertFalse("El primer parametro deberia ser una fecha posterior o igual a la segunda", UFecha.anteriorA(fecha, fechaMasAntigua));
	}
	
	@Test
	public void testAnteriorAConDosFechasIguales()
	{
		Assert.assertFalse("Deberia retornar falso", UFecha.anteriorA(fecha, fecha));
	}

	@Test
	public void testConvertirDeStringAHora()
	{
		hora = UFecha.convertirAHora(strHora);
		Assert.assertTrue("La hora deberia ser la misma que la ingresada como string", hora.toString().equals(strHora));
	}
	
	@Test(expected=FormatoDeHoraIncorrectoException.class)
	public void testConvertirDeStringAHoraUtilizandoUnFormatoIncorrecto()
	{
		hora = UFecha.convertirAHora(strFormatoErroneo);
	}

}
