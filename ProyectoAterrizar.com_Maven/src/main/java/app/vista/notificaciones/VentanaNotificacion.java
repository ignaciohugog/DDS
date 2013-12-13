package app.vista.notificaciones;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import app.vista.VentanaAterrizar;

public abstract class VentanaNotificacion<T> extends VentanaAterrizar<T>
{
	protected String mensaje;
	
	public VentanaNotificacion(WindowOwner owner, T model)
	{
		super(owner, model);
	}

	@Override
	public void createContents(Panel mainPanel)
	{
		mainPanel.setLayout(new VerticalLayout());
		
		this.createPanelMensaje(mainPanel);
		
		this.createPanelOpciones(mainPanel);
	}

	private void createPanelMensaje(Panel mainPanel)
	{
		Panel panelMensaje = new Panel(mainPanel);
		panelMensaje.setLayout(new VerticalLayout());
		this.definirMensajeNotificacion(panelMensaje);
	}

	private void createPanelOpciones(Panel mainPanel)
	{
		Panel panelOpciones = new Panel(mainPanel);
		panelOpciones.setLayout(new VerticalLayout());
		this.definirOpcionesVentana(panelOpciones);
	}
	
	
	protected abstract void definirMensajeNotificacion(Panel panelMensaje);

	protected abstract void definirOpcionesVentana(Panel panelOpciones);

	
	/*
	 * GETTERS & SETTERS 
	 */
	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

}
