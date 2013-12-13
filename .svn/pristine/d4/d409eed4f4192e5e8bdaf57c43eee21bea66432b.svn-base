package util;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import decorator.filtro.ComponenteFiltrado;
import decorator.filtro.imple.FiltroClase;
import decorator.filtro.imple.FiltroPrecio;
import decorator.filtro.imple.FiltroReservados;
import decorator.filtro.imple.FiltroSuperOfertas;
import decorator.filtro.imple.FiltroUbicacion;
import decorator.filtro.imple.SinFiltro;
import domain.Asiento;
import domain.Clase;
import domain.Ubicacion;
import domain.Usuario;

public class UFiltro
{
	public static Collection<Asiento> filtrarAsientos(List<Clase> clases, Ubicacion ubicacion, double precioMin, double precioMax, boolean incluirReservados, Collection<Asiento> col, Usuario usuario)
	{
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();
		
		ComponenteFiltrado componente = new SinFiltro(col);
		
		if(clases!=null)
		{
			componente = new FiltroClase(componente, clases);
		}
		
		if(ubicacion!=null)
		{
			componente = new FiltroUbicacion(componente, ubicacion);
		}
		
		if(!usuario.getPuedeVerSuperOfertas())
		{
			componente = new FiltroSuperOfertas(componente);
		}
		
		if(!incluirReservados)
		{
			componente = new FiltroReservados(componente);
		}
		
		if(!(precioMin == 0 && precioMax == 0))
		{
			componente = new FiltroPrecio(componente, precioMin, precioMax);
		}
		
		nuevaColeccion = componente.operar();
		
		return nuevaColeccion;
	}
	

}
