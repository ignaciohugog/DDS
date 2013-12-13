package criterioDeOrdenamiento;


import domain.Asiento;
public class CriterioTiempo extends CriterioDeOrdenamiento {
	@Override
    public int compare(Asiento unAsiento, Asiento otroAsiento) {
            if (this.isAscendente())
            {
                    return (int) (unAsiento.getTiempo() - otroAsiento.getTiempo());
            }
            else
            {
                    return (int) (otroAsiento.getTiempo() - unAsiento.getTiempo());
            }
    }



}
