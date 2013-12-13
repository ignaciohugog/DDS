package domain.exception;

public class AsientoNoDisponibleException extends AerolineaException
{
	private String codigoVuelo;
	private int numeroAsiento;

	// ****************************************************************
	// ** CONSTRUCTORS
	// ****************************************************************

	public AsientoNoDisponibleException(Throwable cause, String codigoVuelo, int numeroAsiento)
	{
		super(cause);
		this.setCodigoVuelo(codigoVuelo);
		this.setNumeroAsiento(numeroAsiento);
	}

	public AsientoNoDisponibleException(String codigoVuelo, int numeroAsiento)
	{
		super();
		this.setCodigoVuelo(codigoVuelo);
		this.setNumeroAsiento(numeroAsiento);
	}

	// ****************************************************************
	// ** QUERIES
	// ****************************************************************

	@Override
	public String getMessage()
	{
		return "Codigo de vuelo: " + this.getCodigoVuelo() + " Asiento: " + this.getNumeroAsiento() + " no esta disponible.";
	}

	// ****************************************************************
	// ** ACCESSORS
	// ****************************************************************

	protected String getCodigoVuelo()
	{
		return this.codigoVuelo;
	}

	protected void setCodigoVuelo(String codigoVuelo)
	{
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
