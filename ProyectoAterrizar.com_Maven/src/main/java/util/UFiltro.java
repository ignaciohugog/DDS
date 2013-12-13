package util;

import java.util.Collection;
import java.util.Vector;

import filtro.ComponenteFiltrado;
import filtro.imple.FiltroClase;
import filtro.imple.FiltroEstados;
import filtro.imple.FiltroPrecio;
import filtro.imple.FiltroSuperOfertas;
import filtro.imple.FiltroUbicacion;
import filtro.imple.SinFiltro;
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
