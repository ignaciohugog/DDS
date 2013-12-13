package app.vista;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.ui.jface.builder.ErrorsPanel;

import app.model.AterrizarAppModel;
import app.vista.notificaciones.BusquedaFallida;
import app.vista.notificaciones.BusquedaFallidaPorCamposSinDefinir;
import app.vista.notificaciones.BusquedaFallidaPorFechaConFormatoIncorrecto;
import app.vista.notificaciones.CompraExitosa;
import app.vista.notificaciones.CompraFallida;
import app.vista.notificaciones.ReservaExitosa;
import app.vista.notificaciones.ReservaFallida;
import domain.Asiento;
import domain.exception.AsientoNoDisponibleException;
import domain.exception.FaltanCompletarCamposObligatoriosException;
import domain.exception.FormatoDeFechaIncorrectoException;

public class BuscadorAsientosWindow extends VentanaClasica<AterrizarAppModel>
{

	public BuscadorAsientosWindow(WindowOwner owner, AterrizarAppModel model)
	{
		super(owner, model);
	}

	@Override
	public void createMainTemplate(Panel mainPanel)
	{
		this.inicializar(mainPanel);
		
		this.createErrorsPanel(mainPanel);
		
		this.createFormulario(mainPanel);
		
		this.createPanelBusqueda(mainPanel);
		
		this.createTablaDeResultados(mainPanel);
		
		this.createOpcionesAsiento(mainPanel);
		
		this.addAccionesFinalesPanel(mainPanel);
	}

	private void inicializar(Panel mainPanel)
	{
		mainPanel.setLayout(new VerticalLayout());
	}

	@Override
	protected ErrorsPanel createErrorsPanel(Panel mainPanel)
	{
		this.setTaskDescription("Ingrese los valores a buscar");
		return super.createErrorsPanel(mainPanel);
	}

	private void createOpcionesAsiento(Panel mainPanel)
	{
		Panel opcionesAsientoPanel = new Panel(mainPanel);
		opcionesAsientoPanel.setLayout(new HorizontalLayout());
		
		Button comprar = new Button(opcionesAsientoPanel)
						.setCaption("Comprar")
						.onClick(new MessageSend(this, "comprar"));
		
		Button reservar = new Button(opcionesAsientoPanel)
						.setCaption("Reservar")
						.onClick(new MessageSend(this, "reservar"));
		
		NotNullObservable asientoSeleccionado = new NotNullObservable("asientoSeleccionado");
		comprar.bindEnabled(asientoSeleccionado);
		reservar.bindEnabled(asientoSeleccionado);
	}


	protected void createFormulario(Panel mainPanel)
	{
		
		Panel panelFormulario = new Panel(mainPanel);
		panelFormulario.setLayout(new HorizontalLayout());
		
		
		new Label(panelFormulario)
			.setText("Origen:");
		new TextBox(panelFormulario)
			.bindValueToProperty("origen");
		
		new Label(panelFormulario)
			.setText(" Destino:");
		new TextBox(panelFormulario)
			.bindValueToProperty("destino");
		
		new Label(panelFormulario)
			.setText(" Fecha de Salida:");
		new TextBox(panelFormulario)
			.bindValueToProperty("fechaSalida");
	}

	private void createPanelBusqueda(Panel mainPanel)
	{	
		Panel busquedaPanel = new Panel(mainPanel);
		busquedaPanel.setLayout(new HorizontalLayout());
		
		Button buscar = new Button(busquedaPanel)
						.setCaption("Buscar")
						.setAsDefault()
						.onClick(new MessageSend(this, "buscar"));
				
		new Button(busquedaPanel)
			.setCaption("Limpiar")
			.onClick(new MessageSend(this.getModelObject(), "limpiar"));
		
		
		NotNullObservable fechaSalida = new NotNullObservable("fechaSalida");
		buscar.bindEnabled(fechaSalida);
		
	}

	
	private void createTablaDeResultados(Panel mainPanel)
	{
		Table<Asiento> tabla = new Table<Asiento>(mainPanel, Asiento.class);
		tabla.setHeigth(150);
		tabla.setWidth(150);
		
		tabla.bindItemsToProperty("resultadoBusqueda");
		tabla.bindValueToProperty("asientoSeleccionado");

		this.describirColumnasTabla(tabla);
	}

	private void describirColumnasTabla(Table<Asiento> tabla)
	{
		Column<Asiento> aerolineaColumn = new Column<Asiento>(tabla);
		aerolineaColumn.setTitle("Aerolinea");
		aerolineaColumn.bindContentsToProperty("aerolinea");

		Column<Asiento> codigoDeVueloColumn = new Column<Asiento>(tabla);
		codigoDeVueloColumn.setTitle("Vuelo");
		codigoDeVueloColumn.bindContentsToProperty("codigoVuelo");
		
		Column<Asiento> numeroColumn = new Column<Asiento>(tabla);
		numeroColumn.setTitle("Asiento");
		numeroColumn.bindContentsToProperty("numeroAsiento");

		Column<Asiento> precioTotalColumn = new Column<Asiento>(tabla);
		precioTotalColumn.setTitle("Precio");
		precioTotalColumn.bindContentsToProperty("precioTotal");
		
		Column<Asiento> ubicacionColumn = new Column<Asiento>(tabla);
		ubicacionColumn.setTitle("Ubicacion");
		ubicacionColumn.bindContentsToProperty("ubicacion");
		
		Column<Asiento> claseColumn = new Column<Asiento>(tabla);
		claseColumn.setTitle("Clase");
		claseColumn.bindContentsToProperty("clase");
		
	}

	
	public void comprar()
	{
		try
		{
			Asiento asientoSeleccionado = this.getModelObject().getAsientoSeleccionado();
			MessageSend comprarAsientoMessage = new MessageSend(this.getModelObject(), "comprar");
			CompraExitosa<AterrizarAppModel> ventanaCompraExitosa = new CompraExitosa<AterrizarAppModel>(this, this.getModelObject(), asientoSeleccionado);
			
			comprarAsientoMessage.execute();
			ventanaCompraExitosa.open();
		}
		catch(AsientoNoDisponibleException ex)
		{	
			CompraFallida<AterrizarAppModel> ventanaCompraFallida = new CompraFallida<AterrizarAppModel>(this, this.getModelObject(), ex.getMessage());
			ventanaCompraFallida.open();
		}
	}
	
	
	public void reservar()
	{
		try
		{
			Asiento asientoSeleccionado = this.getModelObject().getAsientoSeleccionado();
			MessageSend reservarAsientoMessage = new MessageSend(this.getModelObject(), "reservar");
			ReservaExitosa<AterrizarAppModel> ventanaReservaExitosa = new ReservaExitosa<AterrizarAppModel>(this, this.getModelObject(), asientoSeleccionado);
			
			reservarAsientoMessage.execute();
			ventanaReservaExitosa.open();
		}
		catch(AsientoNoDisponibleException ex)
		{
			ReservaFallida<AterrizarAppModel> ventanaReservaFallida = new ReservaFallida<AterrizarAppModel>(this, this.getModelObject(), ex.getMessage());
			ventanaReservaFallida.open();
		}
	}
	
	public void buscar()
	{
		try
		{
			MessageSend buscarAsientosMessage = new MessageSend(this.getModelObject(), "buscar");
			buscarAsientosMessage.execute();
		}
		catch(FaltanCompletarCamposObligatoriosException ex)
		{
			BusquedaFallida<AterrizarAppModel> ventanaBusquedaFallida = new BusquedaFallidaPorCamposSinDefinir<AterrizarAppModel>(this, this.getModelObject());
			ventanaBusquedaFallida.open();
		}
		catch(FormatoDeFechaIncorrectoException ex) 
		{
			BusquedaFallida<AterrizarAppModel> ventanaBusquedaFallida = new BusquedaFallidaPorFechaConFormatoIncorrecto<AterrizarAppModel>(this, this.getModelObject());
			ventanaBusquedaFallida.open();
		}
	}


}
