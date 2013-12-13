package domain.exception;

public class FormatoDeHoraIncorrectoException extends RuntimeException
{
	public FormatoDeHoraIncorrectoException(Throwable ex)
	{
		super(ex);
	}
	
	@Override
	public String getMessage()
	{
		return "El formato de fecha ingresado es incorrecto";
	}
}
