package ej5;

public class Ingrediente {

	private String nombre;
	private int calorias;
	
	public Ingrediente(String nombre, int calorias) {
		this.nombre = nombre;
		this.calorias = calorias;
	}

	@Override
	public String toString() {
		return "Ingredientes [nombre=" + nombre + ", calorias=" + calorias + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public int getCalorias() {
		return calorias;
	}
	
	
	
}
