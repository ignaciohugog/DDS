package util;

import java.util.Collection;
import java.util.Vector;

import decorator.filtro.ComponenteFiltrado;
import decorator.filtro.imple.FiltroClase;
import decorator.filtro.imple.FiltroEstados;
import decorator.filtro.imple.FiltroPrecio;
import decorator.filtro.imple.FiltroSuperOfertas;
import decorator.filtro.imple.FiltroUbicacion;
import decorator.filtro.imple.SinFiltro;
import domain.Asiento;
import domain.Busqueda;
import domain.Usuario;

public class UFiltro
{
	public static Collection<Asiento> filtrarAsientos(Busqueda busqueda, Collection<Asiento> col, Usuario usuario)
	{
		Collection<Asiento> nuevaColeccion = new Vector<Asiento>();
		ComponenteFiltrado componente;
		
		componente = new SinFiltro(col);
		componente = new FiltroClase(componente, busqueda.getClases());
		componente = new FiltroUbicacion(componente, busqueda.getUbicacion());
		componente = new FiltroPrecio(componente, busqueda.getPrecioMinimo(), busqueda.getPrecioMaximo());
		componente = new FiltroSuperOfertas(componente, usuario.getPuedeVerSuperOfertas());
		componente = new FiltroEstados(componente, busqueda.getEstados());
		
		nuevaColeccion = componente.operar();
		
		return nuevaColeccion;
	}
	

}
