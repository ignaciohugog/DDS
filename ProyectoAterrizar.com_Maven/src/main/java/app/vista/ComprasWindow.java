package app.vista;

import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;

import domain.Asiento;

public class ComprasWindow<AterrizarAppModel> extends RegistroAsientosWindow<AterrizarAppModel>
{

	public ComprasWindow(WindowOwner owner, AterrizarAppModel model)
	{
		super(owner, model);
		this.setPrefijoMensaje("Compras de");
	}

	@Override
	protected void establecerBindingTabla(Table<Asiento> tabla)
	{
		tabla.bindItemsToProperty("asientosComprados");
	}	

}
