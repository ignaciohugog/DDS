package app.vista;

import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;

import domain.Asiento;

public class ReservasWindow<AterrizarAppModel> extends RegistroAsientosWindow<AterrizarAppModel>
{

	public ReservasWindow(WindowOwner owner, AterrizarAppModel model)
	{
		super(owner, model);
		this.setPrefijoMensaje("Reservas de");
	}

	@Override
	protected void establecerBindingTabla(Table<Asiento> tabla)
	{
		tabla.bindItemsToProperty("asientosReservados");
	}
	
}

