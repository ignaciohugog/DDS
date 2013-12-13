package criterioDeOrdenamiento;

import domain.Asiento;

public class CriterioPrecio extends CriterioDeOrdenamiento {
	
	
	@Override
    public int compare(Asiento unAsiento, Asiento otroAsiento) {
            if (this.isAscendente())
            {
                    return unAsiento.getPrecio().compareTo(otroAsiento.getPrecio());
            }
            else
            {
                    return otroAsiento.getPrecio().compareTo(unAsiento.getPrecio());
            }
    }


		
	}

	

