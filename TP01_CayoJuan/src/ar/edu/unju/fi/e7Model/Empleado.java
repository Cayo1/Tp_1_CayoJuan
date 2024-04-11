package ar.edu.unju.fi.e7Model;

public class Empleado {
	private String Nombre;
	private int Legajo;
	private Double Salario;
	private final Double SALARIO_MINIMO = 210000.0;
	private final Double AUMENTO_POR_MERITOS = 20000.0;
	public Empleado(String nombre, int legajo, double Salario) {
		super();
		Nombre = nombre;
		Legajo = legajo;
		 if (Salario >= SALARIO_MINIMO) {
	            this.Salario = Salario;
	        } else {
	            this.Salario = SALARIO_MINIMO;
	        }
	}
	public void mostrarDatos () {
		System.out.println("Nombre del empleado: " + Nombre);
		System.out.println("Legajo del empleado: " + Legajo);
		System.out.println("Salario del empleado: " + Salario);
	}
	public void AumentoSalario() {
		Salario += AUMENTO_POR_MERITOS;
	}
}
