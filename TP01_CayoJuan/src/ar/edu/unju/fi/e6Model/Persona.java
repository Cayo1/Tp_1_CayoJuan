package ar.edu.unju.fi.e6Model;
import java.time.LocalDate;
public class Persona{

		private int dni;
	    private String nombre;
	    private LocalDate fechaNacimiento;
	    private String provincia;
	public Persona() {	
	}
	public Persona(int dni, String nombre, LocalDate fechaNacimiento, String provincia) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = provincia;
	}
	public Persona(int dni, String nombre, LocalDate fechaNacimiento) {

		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = "Jujuy";
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	 public int calcularEdad() {
	        return LocalDate.now().getYear() - fechaNacimiento.getYear();
	    }
	    public boolean esMayorEdad() {
	        return calcularEdad() >= 18;
	    }
	
	public void mostrarDatos(){
		System.out.println("DNI: " + dni);
		System.out.println("Nombre: " + nombre);
		System.out.println("Fecha de nacimiento: " + fechaNacimiento);
		System.out.println("Provincia: " + provincia);
		System.out.println("Edad: " + calcularEdad());
		if (esMayorEdad()) {
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona no es mayor de edad");
        }
	}
										
	
	}		
	
