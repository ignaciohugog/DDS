package domain;

import java.util.Collection;

public abstract class Aerolinea<InterfazAerolinea>
{
	private InterfazAerolinea instancia;
	private String nombre;
	private double impuesto;

	// Metodos abstractos

	public abstract Collection<Asiento> obtenerAsientosDisponibles(Busqueda busqueda, Usuario usuario);

	public abstract void comprarAsiento(Asiento asiento, Usuario usuario);

	public abstract void reservarAsiento(Asiento asiento, Usuario usuario);

	// Metodos utilitarios

	protected double getPrecioTotal(double precio, Usuario usuario)
	{
		double precioTotal;
		double recargoUsuario;
		double impuestoAerolinea;

		impuestoAerolinea = this.getImpuesto();
		recargoUsuario = usuario.getRecargo();
		precioTotal = precio * (impuestoAerolinea + 1) + recargoUsuario;

		return precioTotal;
	}

	// Getters & Setters

	public InterfazAerolinea getInstancia()
	{
		return instancia;
	}

	public void setInstancia(InterfazAerolinea instancia)
	{
		this.instancia = instancia;
	}

	public double getImpuesto()
	{
		return impuesto;
	}

	public void setImpuesto(double impuesto)
	{
		this.impuesto = impuesto;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getNombre()
	{
		return nombre;
	}

}
