package ej3;

public class Pelicula {

	private String nombre;
	private int duracion, anyo;
	
	
	public Pelicula(String nombre, int duracion, int anyo) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.anyo = anyo;
	}


	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", duracion=" + duracion + ", anyo=" + anyo + "]";
	}
	
	public boolean esIgual(Pelicula p1) {
		if (!this.nombre.equalsIgnoreCase(p1.nombre)) {
			return false;
		}
		if (!(this.anyo==p1.anyo)) {
			return false;
		}
		if (!(this.duracion<=p1.duracion+5 && this.duracion>=p1.duracion-5)) {
			return false;
		}
		return true;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}


	public int getDuracion() {
		return duracion;
	}


	public int getAnyo() {
		return anyo;
	}


	public static void main(String[] args) {
		Pelicula p1=new Pelicula("aaa",10,1990);
		Pelicula p2=new Pelicula("aaa",5,1990);
		System.out.println(p1.esIgual(p2));
	}

	
}
