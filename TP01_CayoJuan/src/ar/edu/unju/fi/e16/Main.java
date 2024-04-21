package ar.edu.unju.fi.e16;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] nombres = new String[5];
		for (int i = 0; i<nombres.length; i++) {
			System.out.println("Ingrese el nombre "+ (i+1) +": ");
			nombres[i] = scanner.nextLine();
		}
		int j=0;
		while (j<nombres.length) {
			System.out.println(nombres[j]);
			j++;
		}
		System.out.println("Tamaño del array: " + nombres.length);
		byte indiceE;
		do {
			System.out.println("Ingrese el indice del elemento que desea borrar");
			indiceE = scanner.nextByte();
		} while(indiceE<0 || indiceE>= nombres.length);
		int IndiceEliminar = indiceE - 1;
		for (int k = IndiceEliminar; k < nombres.length - 1; k++) {
			nombres[k]=nombres[k+1];
		}
		nombres[nombres.length - 1] =null;
		for (String nombre : nombres) if(nombre !=null){
            System.out.println(nombre);
        }

        scanner.close();
	}

}
