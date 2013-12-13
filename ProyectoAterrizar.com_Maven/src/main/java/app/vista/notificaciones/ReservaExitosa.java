package app.vista.notificaciones;

import org.uqbar.arena.windows.WindowOwner;

import domain.Asiento;

public class ReservaExitosa<T> extends OperacionExitosa<T>
{

	public ReservaExitosa(WindowOwner owner, T model, Asiento asiento)
	{
		super(owner, model);
		this.setMensaje("El asiento "+asiento.getNumeroAsiento()+" ha sido reservado exitosamente");
	}

}
