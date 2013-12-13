package domain.exception;

public class AsientoInexistenteException extends AerolineaException
{
	private String codigoVuelo;
	private int numeroAsiento;

	// ****************************************************************
	// ** CONSTRUCTORS
	// ****************************************************************

	public AsientoInexistenteException(Throwable cause, String codigoVuelo, int numeroAsiento) {
		super(cause);
		this.setCodigoVuelo(codigoVuelo);
		this.setNumeroAsiento(numeroAsiento);
	}
	
	public AsientoInexistenteException(String codigoVuelo, int numeroAsiento) {
		super();
		this.setCodigoVuelo(codigoVuelo);
		this.setNumeroAsiento(numeroAsiento);
	}

	// ****************************************************************
	// ** QUERIES
	// ****************************************************************

	@Override
	public String getMessage() {
		return "El asiento con codigo de vuelo: "+this.getCodigoVuelo()+" y numero de asiento: "+this.getNumeroAsiento()+" no existe";
	}

	// ****************************************************************
	// ** ACCESSORS
	// ****************************************************************

	protected String getCodigoVuelo() {
		return this.codigoVuelo;
	}

	protected void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}
	
	protected int getNumeroAsiento()
	{
		return numeroAsiento;
	}

	protected void setNumeroAsiento(int numeroAsiento)
	{
		this.numeroAsiento = numeroAsiento;
	}
}
