package criterioDeOrdenamiento;

import java.util.Collection;

import domain.Asiento;

public interface Criterio
{
	public void aplicarCriterio(Collection<Asiento> col);
}
