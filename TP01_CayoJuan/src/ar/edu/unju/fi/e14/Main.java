package ar.edu.unju.fi.e14;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese un numero entre el rango 3-10");
		int numero = scanner.nextInt();
		if (numero>3 && numero<10) {
			int[] array = new int[numero];
			for ( int i = 0; i<numero;i++) {
				System.out.println("Ingrese un numero para la posicion " + i + ": ");
				array[i]=scanner.nextInt();
			}
			int suma = 0;
			for(int i = 0; i<numero; i++) {
				System.out.println("En el indice "+ (i+1) + " se almacena: "+ array[i]);
				suma += array[i];
			}
			System.out.println("La suma de todos los valores es: "+ suma);
		}
		else {
			System.out.println("Eñ numero no está dentro del rango 3-10");
		}
		scanner.close();

	}

}
