package app.vista;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

public abstract class VentanaClasica<AterrizarAppModel> extends VentanaAterrizar<AterrizarAppModel>
{
	private String prefijoMensaje;

	public VentanaClasica(WindowOwner parent, AterrizarAppModel model)
	{
		super(parent, model);
	}
	
	protected void createMensajeInicial(Panel mainPanel)
	{
		Panel saludoPanel = new Panel(mainPanel);
		saludoPanel.setLayout(new HorizontalLayout());
		
		new Label(saludoPanel)
			.setText(this.getPrefijoMensaje());
		new Label(saludoPanel)
			.bindValueToProperty("usuario");
	}
	
	protected void addAccionesFinalesPanel(Panel mainPanel)
	{
		Panel panelAccionesFinales = new Panel(mainPanel);
		panelAccionesFinales.setLayout(new HorizontalLayout());
		
		new Button(panelAccionesFinales)
			.setCaption("Cerrar")
			.onClick(new MessageSend(this, "close"));		
	}


	
	/*
	 * GETTERS & SETTERS
	 */
	
	public String getPrefijoMensaje()
	{
		return prefijoMensaje;
	}

	public void setPrefijoMensaje(String prefijoMensaje)
	{
		this.prefijoMensaje = prefijoMensaje;
	}


}
