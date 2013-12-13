package domain.usuarios;

import domain.Usuario;

public class UsuarioEstandar extends Usuario
{
	public UsuarioEstandar()
	{
		this.inicializar();
	}
	
	public UsuarioEstandar(String unNombre, String unApellido, int unDNI)
	{
		this.inicializar();
		this.setNombre(unNombre);
		this.setApellido(unApellido);
		this.setDni(unDNI);
	}

	private void inicializar()
	{
		tipoDeUsuario = "Estandar";
		recargo = 0;
		puedeVerSuperOfertas = false;
	}
}
