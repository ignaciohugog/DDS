package app.vista;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import app.model.AterrizarAppModel;

public class MainWindow extends VentanaClasica<AterrizarAppModel>
{

	public MainWindow(WindowOwner parent)
	{
		super(parent, new AterrizarAppModel());
		this.setPrefijoMensaje("Hola");
	}

	@Override
	public void createMainTemplate(Panel mainPanel)
	{
		this.inicializarVentana(mainPanel);
		
		this.createMensajeInicial(mainPanel);
		
		this.crearPanelOpciones(mainPanel);
	}

	
	private void inicializarVentana(Panel mainPanel)
	{
		mainPanel.setLayout(new VerticalLayout());
	}

	

	private void crearPanelOpciones(Panel mainPanel)
	{
		Panel panelOpciones = new Panel(mainPanel);
		panelOpciones.setLayout(new HorizontalLayout());

		new Button(panelOpciones)
			.setCaption("Ver Compras")
			.onClick(new MessageSend(this, "abrirComprasWindow"));
		
		new Button(panelOpciones)
			.setCaption("Ver Reservas")
			.onClick(new MessageSend(this, "abrirReservasWindow"));
		
		new Button(panelOpciones)
			.setCaption("Buscar Asientos")
			.onClick(new MessageSend(this, "abrirBuscadorAsientosWindow"));
	}

	public void abrirBuscadorAsientosWindow()
	{
		this.openWindow(new BuscadorAsientosWindow(this, this.getModelObject()));
	}
	
	public void abrirComprasWindow()
	{
		this.openWindow(new ComprasWindow<AterrizarAppModel>(this, this.getModelObject()));
	}
	
	public void abrirReservasWindow()
	{
		this.openWindow(new ReservasWindow<AterrizarAppModel>(this, this.getModelObject()));
	}
	
	private void openWindow(Window<?> window)
	{
		window.open();
	}
	
}
