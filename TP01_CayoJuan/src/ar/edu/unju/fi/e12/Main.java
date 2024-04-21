package ar.edu.unju.fi.e12;
import ar.edu.unju.fi.e12Model.*;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre de la persona: ");
		String nombre = scanner.nextLine();
		System.out.println("Ingrese la fecha de nacimiento de la persona (dd/mm/yyyy): ");
		String fechaNacimientoStr = scanner.nextLine();
		String[] partesFecha = fechaNacimientoStr.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]) - 1;
        int anio = Integer.parseInt(partesFecha[2]);
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(anio, mes, dia);
       
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setFechaNacimiento(fechaNacimiento);
        
        System.out.println("Datos de la persona:");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Fecha de nacimiento: " + dia + "/" + (mes + 1) + "/" + anio);
        System.out.println("Edad: " + persona.calcularEdad());
        System.out.println("Signo del zodiaco: " + persona.determinarSigno(fechaNacimiento));
        System.out.println("Estación del año: " + persona.determinarEstacion(fechaNacimiento));
        scanner.close();
    }
	}


