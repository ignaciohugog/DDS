package domain.usuarios;

import domain.Usuario;


public class UsuarioEstandar extends Usuario
{
	public UsuarioEstandar()
	{
		tipoDeUsuario = "Estandar";
		recargo = 0;
		puedeVerSuperOfertas = false;
	}
}
