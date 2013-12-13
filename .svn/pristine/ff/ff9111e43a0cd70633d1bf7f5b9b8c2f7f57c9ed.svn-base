package app.vista;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;

import domain.Asiento;

public abstract class RegistroAsientosWindow<AterrizarAppModel> extends VentanaClasica<AterrizarAppModel>
{

	public RegistroAsientosWindow(WindowOwner owner, AterrizarAppModel model)
	{
		super(owner, model);
	}

	
	protected abstract void establecerBindingTabla(Table<Asiento> tabla);

	
	@Override
	public void createMainTemplate(Panel mainPanel)
	{
		mainPanel.setLayout(new VerticalLayout());
		
		this.createMensajeInicial(mainPanel);
		
		this.agregarTabla(mainPanel);
		
		this.addAccionesFinalesPanel(mainPanel);
	}
		

	private void agregarTabla(Panel mainPanel)
	{
		Table<Asiento> tabla = new Table<Asiento>(mainPanel, this.getTableEntityType());
		
		this.establecerBindingTabla(tabla);
		
		this.descripcionTabla(tabla);
	}
	
	private void descripcionTabla(Table<Asiento> tabla)
	{
		Column<Asiento> fechaSalidaColumn = new Column<Asiento>(tabla);
		fechaSalidaColumn.setTitle("Fecha salida");
		fechaSalidaColumn.bindContentsToProperty("fechaSalida");
		fechaSalidaColumn.setFixedSize(80);
		
		Column<Asiento> aerolineaColumn = new Column<Asiento>(tabla);
		aerolineaColumn.setTitle("Aerolinea");
		aerolineaColumn.bindContentsToProperty("aerolinea");
		aerolineaColumn.setFixedSize(80);		
	
		Column<Asiento> codigoDeVueloColumn = new Column<Asiento>(tabla);
		codigoDeVueloColumn.setTitle("Vuelo");
		codigoDeVueloColumn.bindContentsToProperty("codigoVuelo");
		codigoDeVueloColumn.setFixedSize(60);
		
		Column<Asiento> numeroColumn = new Column<Asiento>(tabla);
		numeroColumn.setTitle("Asiento");
		numeroColumn.bindContentsToProperty("numeroAsiento");
		numeroColumn.setFixedSize(60);
		
		Column<Asiento> precioTotalColumn = new Column<Asiento>(tabla);
		precioTotalColumn.setTitle("Precio");
		precioTotalColumn.bindContentsToProperty("precioTotal");
		precioTotalColumn.setFixedSize(60);
		
	}

	
	public Class<Asiento> getTableEntityType()
	{
		return Asiento.class;
	}
}
