package app.vista.notificaciones;

import org.uqbar.arena.windows.WindowOwner;

public class CompraFallida<T> extends OperacionFallida<T>
{

	public CompraFallida(WindowOwner owner, T model, String unMensaje)
	{
		super(owner, model, unMensaje);
		this.setTipoDeOperacion("compra");
	}

}
