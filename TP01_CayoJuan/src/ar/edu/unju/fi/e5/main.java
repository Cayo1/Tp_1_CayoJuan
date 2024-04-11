package ar.edu.unju.fi.e5;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese un numero comprendido entre el 1 y el 9");
		int numero = scanner.nextInt();
				if (numero<1 || numero>9) {
					System.out.println("Numero fuera del rango mencionado");
				}else {
					for (int i = 0; i <= 10; i++) {
						System.out.println(numero + " x " + i + " = "+ (numero*i));
					}
				}
				scanner.close();
	}

}
