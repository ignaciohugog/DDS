package app.vista;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

public abstract class VentanaAterrizar<AterrizarAppModel> extends SimpleWindow<AterrizarAppModel>
{

	public VentanaAterrizar(WindowOwner parent, AterrizarAppModel model)
	{
		super(parent, model);
		this.setTitle("Aterrizar.com");
	}

	@Override
	protected void addActions(Panel actionsPanel)
	{
		// Vacío
	}

	@Override
	protected void createFormPanel(Panel mainPanel)
	{
		// Vacío
	}

}
