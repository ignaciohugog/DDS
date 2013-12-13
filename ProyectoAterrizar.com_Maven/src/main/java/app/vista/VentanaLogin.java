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

public class VentanaLogin<AterrizarAppModel> extends VentanaClasica<AterrizarAppModel>
{

	public VentanaLogin(WindowOwner parent, AterrizarAppModel model)
	{
		super(parent, model);
	}


	@Override
	protected void createMainTemplate(Panel mainPanel)
	{
		this.inicializar(mainPanel);
		
		this.agregarErrorPanel(mainPanel);
		
		this.agregarTextBoxes(mainPanel);
		
		this.agregarPanelOpciones(mainPanel);
	}
	
	
	private void inicializar(Panel mainPanel)
	{
		mainPanel.setLayout(new VerticalLayout());
	}


	private void agregarErrorPanel(Panel mainPanel)
	{
		this.setTaskDescription("Ingrese nombre, apellido y dni");
		this.createErrorsPanel(mainPanel);
	}


	private void agregarTextBoxes(Panel mainPanel)
	{
		Panel panelUsuario = new Panel(mainPanel);
		panelUsuario.setLayout(new HorizontalLayout());
		
		Panel panelApellido = new Panel(mainPanel);
		panelApellido.setLayout(new HorizontalLayout());
		
		Panel panelDNI = new Panel(mainPanel);
		panelDNI.setLayout(new HorizontalLayout());
		
		new Label(panelUsuario)
			.setText("Nombre:");
		new TextBox(panelUsuario)
			.bindValueToProperty("nombre");
		
		new Label(panelApellido)
			.setText("Apellido");
		new TextBox(panelApellido)
			.bindValueToProperty("apellido");
		
		new Label(panelDNI)
			.setText("DNI:");
		new TextBox(panelDNI)
			.bindValueToProperty("dni");
		
	}

	private void agregarPanelOpciones(Panel mainPanel)
	{
		Panel panelOpciones = new Panel(mainPanel);
		panelOpciones.setLayout(new HorizontalLayout());
		
		new Button(panelOpciones)
			.setCaption("Ingresar")
			.onClick(new MessageSend(this, "ingresar"));
		
		new Button(panelOpciones)
			.setCaption("Crear nuevo usuario")
			.onClick(new MessageSend(this, "crearNuevoUsuario"));
			
	}

	public void ingresar()
	{
		//TODO: método ingresar()
		
		try
		{
			
		}
		catch(Exception e)
		{
			// TODO: handle exception
		}
	}

	public void crearNuevoUsuario()
	{
		//TODO: método crearNuevoUsuario. Crear nuevoUsuarioWindow.
	}
	
}
