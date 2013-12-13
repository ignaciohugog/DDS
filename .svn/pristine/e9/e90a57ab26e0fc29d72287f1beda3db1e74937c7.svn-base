package criterioDeOrdenamiento;

import domain.Asiento;
public class CriterioPopularidad extends CriterioDeOrdenamiento {

    @Override
    public int compare(Asiento unAsiento, Asiento otroAsiento) {
            if (this.isAscendente())
            {
                    return unAsiento.getVuelo().getPopularidad() - otroAsiento.getVuelo().getPopularidad();
            }
            else
            {
                    return otroAsiento.getVuelo().getPopularidad() - unAsiento.getVuelo().getPopularidad();
            }
    }

}


