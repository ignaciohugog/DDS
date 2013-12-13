package criterioDeOrdenamiento;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import domain.Asiento;

public abstract class CriterioDeOrdenamiento implements Criterio,Comparator
{
	
	@SuppressWarnings("unchecked")
	public void aplicarCriterio(Collection<Asiento> col)
	{
		Collections.sort((Vector<Asiento>) col, this);
	}

}
