package app;

import java.util.Collection;

import domain.Asiento;
import domain.Busqueda;
import domain.Usuario;

public interface Aterrizar
{
	public Usuario autenticar(String nombre, String apellido, int dni);

	public Collection<Asiento> obtenerAsientosDisponibles(Busqueda busqueda, Usuario usuario);

	public void comprarAsiento(Asiento asiento, Usuario usuario);

	public void reservarAsiento(Asiento asiento, Usuario usuario);
	
	public void altaUsuario(String nombre, String apellido, int dni);

}
