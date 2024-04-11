package ar.edu.unju.fi.e9;
import java.util.Scanner;
import ar.edu.unju.fi.e9Model.*;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);      
        for (int i = 1; i <= 3; i++) {
            Producto producto = new Producto();           
            System.out.println("Ingrese los datos del producto " + i + ":");
            System.out.print("Nombre: ");
            producto.setNombre(scanner.next());
            System.out.print("Código: ");
            producto.setCodigo(scanner.nextInt());
            System.out.print("Precio: ");
            producto.setPrecio(scanner.nextDouble());
            System.out.print("Descuento (valor entero entre 0 y 50): ");
            producto.setDescuento(scanner.nextInt());          
            System.out.println("\nDatos del producto " + i + ":");
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println("Descuento: " + producto.getDescuento() + "%");
            System.out.println("Precio con descuento: $" + producto.calcularDescuento() + "\n");
        }

        scanner.close();
    }
	}

