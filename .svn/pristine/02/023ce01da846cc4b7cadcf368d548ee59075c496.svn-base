package app.vista.notificaciones;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

public abstract class BusquedaFallida<T> extends VentanaNotificacion<T>
{

	public BusquedaFallida(WindowOwner owner, T model)
	{
		super(owner, model);
	}

	@Override
	protected void definirMensajeNotificacion(Panel panelMensaje)
	{
		new Label(panelMensaje).setText(this.getMensaje());

	}

	@Override
	protected void definirOpcionesVentana(Panel panelOpciones)
	{
		new Button(panelOpciones).setCaption("Aceptar").onClick(new MessageSend(this, "close"));

	}
}
