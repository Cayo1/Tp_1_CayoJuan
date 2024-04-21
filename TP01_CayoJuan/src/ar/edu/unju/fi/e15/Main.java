package ar.edu.unju.fi.e15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese un numero entre el rango 5-10");
		int numero = scanner.nextInt();
		scanner.nextLine();
		if (numero>5 && numero<10) {
			String[] array = new String[numero];
			for ( int i = 0; i<numero;i++) {
				System.out.println("Ingrese un nombre para la posicion " + i + ": ");
				array[i]=scanner.nextLine();
			}
			for(int i = 0; i<numero; i++) {
				System.out.println("En el indice "+ (i+1) + " se almacena el nombre: "+ array[i]);
			}
			for (int i = numero - 1; i >= 0; i--) {
	            System.out.println("Leyendo de atras para adelante. En el indice " + (i+1) + "se almacena el nombre: " + array[i]);
	        }
		} else {
			System.out.println("El numero no está en el rango 5-10");
		}
		scanner.close();

	}
	}


