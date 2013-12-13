package app.vista.notificaciones;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

public abstract class OperacionFallida<AterrizarAppModel> extends VentanaNotificacion<AterrizarAppModel>
{
	
	protected String tipoDeOperacion;

	
	public OperacionFallida(WindowOwner owner, AterrizarAppModel model, String unMensaje)
	{
		//Recibe el mensaje de la Exception
		super(owner, model);
		this.setMensaje(unMensaje);
	}

	@Override
	protected void definirMensajeNotificacion(Panel panelMensaje)
	{
		new Label(panelMensaje).setText("Ha ocurrido un error en su " + this.getTipoDeOperacion() + ": " + this.getMensaje());
		new Label(panelMensaje).setText("Por favor intente nuevamente");
	}

	@Override
	protected void definirOpcionesVentana(Panel panelOpciones)
	{
		new Button(panelOpciones)
			.setCaption("Aceptar")
			.onClick(new MessageSend(this, "close"));
		
	}

	/*
	 * GETTERS & SETTERS
	 */

	public String getTipoDeOperacion()
	{
		return tipoDeOperacion;
	}

	public void setTipoDeOperacion(String tipoDeOperacion)
	{
		this.tipoDeOperacion = tipoDeOperacion;
	}
	
}
