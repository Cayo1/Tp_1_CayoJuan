package ar.edu.unju.fi.e10;
import java.util.Scanner;
import ar.edu.unju.fi.e10Model.*;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 1; i<=3; i++) {
		Pizza pizza = new Pizza();
		System.out.println("Ingrese los datos para la pizza " + i + ":");
		System.out.println("¿Que diametro? (20, 30 o 40)");
		int diametro = scanner.nextInt();
		pizza.setDiametro(diametro);
		System.out.println("¿Lleva ingredientes especiales? (true/false): ");
		boolean ingredientesEspeciales = scanner.nextBoolean();
		pizza.setIngredientesEspeciales(ingredientesEspeciales);
		pizza.CalcularPrecio();
		pizza.CalcularArea();
		System.out.println("/n Pizza" + i);
		System.out.println("Diámetro = " + pizza.getDiametro());
        System.out.println("Ingredientes especiales = " + pizza.isIngredientesEspeciales());
        System.out.println("Precio Pizza = $" + pizza.getPrecio());
        System.out.println("Área de la pizza = " + pizza.getArea() + "\n");
    }
		scanner.close();
		}
		
	}


