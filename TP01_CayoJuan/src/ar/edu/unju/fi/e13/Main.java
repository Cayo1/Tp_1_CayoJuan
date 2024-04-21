package ar.edu.unju.fi.e13;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numeros = new int[8];
		for(int i = 0; i<numeros.length; i++) {
		System.out.print("Ingrese un valor para " + i + ":");
		numeros[i] = scanner.nextInt();
		}
		for ( int i = 0; i<numeros.length;i++) {
		System.out.println("Indice " + (i+1) + ": " + numeros[i]);
		scanner.close();
		}
	}
}
