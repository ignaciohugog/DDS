package app.vista;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import app.model.AterrizarAppModel;

public class LoginWindow extends VentanaAterrizar<AterrizarAppModel>
{

	public LoginWindow(WindowOwner parent, AterrizarAppModel model) {
		super(parent, model);
	}

	@Override
	protected void createMainTemplate(Panel mainPanel) {
		mainPanel.setLayout(new VerticalLayout());
		
		this.createPanelLogin(mainPanel);
		
		this.createOpcionesPanel(mainPanel);
	}
	
	protected void createPanelLogin(Panel mainPanel) {
		
		Panel panelUsuario = new Panel(mainPanel);
		panelUsuario.setLayout(new HorizontalLayout());
		
		new Label(panelUsuario)
			.setText("Usuario: ");
		
		new TextBox(panelUsuario)
			.bindValueToProperty("usuario");
		
		Panel panelContrasenia = new Panel(mainPanel);
		panelContrasenia.setLayout(new HorizontalLayout());
		
		new Label(panelContrasenia)
			.setText("Contraseña: ");
		
		new TextBox(panelContrasenia)
			.bindValueToProperty("password");
		
	}
	
	protected void createOpcionesPanel(Panel mainPanel) {
		Panel opcionesPanel = new Panel(mainPanel);
		opcionesPanel.setLayout(new HorizontalLayout());
		
		new Button(opcionesPanel)
			.onClick(new MessageSend(this, "autentificar"));
	}
	
	protected void autentificar() {
		
		try
		{
			//this.getModelObject().autentificar();			
		} 
		catch (Exception e) {
			//TODO:Abrir ventana de Usuario inexistente
		}
		
		
	}

}
