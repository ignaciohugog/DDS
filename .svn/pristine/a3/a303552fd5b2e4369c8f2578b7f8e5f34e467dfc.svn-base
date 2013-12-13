package domain.exception;

public class FaltanCompletarCamposObligatoriosException extends RuntimeException
{
	// Se lanza cuando el campo origen, destino o fecha estan vacios (null)
	
	public FaltanCompletarCamposObligatoriosException()
	{
		super();
		this.setMessage("Por favor complete los campos origen, destino y fecha de salida para realizar la busqueda");
	}
	
	private String message;

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
