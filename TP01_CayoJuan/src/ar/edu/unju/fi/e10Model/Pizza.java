package ar.edu.unju.fi.e10Model;

public class Pizza {
	private int diametro;
	private double precio;
	private double area;
	private boolean ingredientesEspeciales;
	private static final double AdicionalEsp20 = 500.0;
	private static final double AdicionalEsp30 = 750.0;
	private static final double AdicionalEsp40 = 1000.0;


public Pizza() {
	

}


public int getDiametro() {
	return diametro;
}


public void setDiametro(int diametro) {
	this.diametro = diametro;
}


public double getPrecio() {
	return precio;
}


public void setPrecio(double precio) {
	this.precio = precio;
}


public double getArea() {
	return area;
}


public void setArea(double area) {
	this.area = area;
}


public boolean isIngredientesEspeciales() {
	return ingredientesEspeciales;
}


public void setIngredientesEspeciales(boolean ingredientesEspeciales) {
	this.ingredientesEspeciales = ingredientesEspeciales;
}

public void CalcularPrecio() {
	switch (diametro) {
    case 20:
        precio = ingredientesEspeciales ? 4500 + AdicionalEsp20 : 4500;
        break;
    case 30:
        precio = ingredientesEspeciales ? 4800 + AdicionalEsp30 : 4800;
        break;
    case 40:
        precio = ingredientesEspeciales ? 5500 + AdicionalEsp40 : 5500;
        break;
    default:
        System.out.println("Diámetro de pizza no válido.");
}
	}

	public void CalcularArea() {
		double radio = this.diametro/2.0;
		area = Math.PI * Math.pow(radio, 2);
	}


}