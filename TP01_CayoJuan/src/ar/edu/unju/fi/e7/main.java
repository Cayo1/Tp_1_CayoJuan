package ar.edu.unju.fi.e7;

import java.util.Scanner;

import ar.edu.unju.fi.e7Model.Empleado;

public class main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del empleado:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el legajo del empleado:");
        int legajo = scanner.nextInt();
        System.out.println("Ingrese el salario del empleado:");
        double salario = scanner.nextDouble();
        Empleado empleado = new Empleado(nombre ,legajo, salario);
        System.out.println("Datos del empleado antes del aumento:");
        empleado.mostrarDatos();      
        empleado.AumentoSalario();    
        System.out.println("\nDatos del empleado después del aumento:");
        empleado.mostrarDatos();
        scanner.close();
    }
}
