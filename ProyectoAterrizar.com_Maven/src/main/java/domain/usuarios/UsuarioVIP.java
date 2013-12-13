package domain.usuarios;

public class UsuarioVIP extends UsuarioEstandar
{
	public UsuarioVIP()
	{
		tipoDeUsuario = "VIP";
		recargo = 0;
		puedeVerSuperOfertas = true;
	}
}
