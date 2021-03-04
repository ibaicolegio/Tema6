package ej3;

import java.util.ArrayList;
import java.util.Iterator;

import t6t1e1.Consola;

public class Cine {

	private String nombre;
	private ArrayList<Pelicula> pelis;
	private Pelicula[] salas;
	
	public Cine(String nombre, int salas) {
		this.nombre = nombre;
		this.salas = new Pelicula[salas];
	}
	
	public int salaPeli(String nombrePeli, int duracion, int anyo) {
		for (int i = 0; i < pelis.size(); i++) {
			if (pelis.get(i).esIgual(new Pelicula(nombrePeli,duracion,anyo))) {
				return (i+1);
			}
		}
		return -1;
	}
	
	public boolean anyadePeli(Pelicula p) {
		for (int i = 0; i < pelis.size(); i++) {
			if (pelis.get(i)!=null || pelis.get(i).esIgual(p)) {
				System.out.println("La pelicula esta en el cine");
				return false;
			}
		}
		if (salasDisponibles()==-1) {
			System.out.println("No quedan salas disponibles");
			return false;
		}
		pelis.set(pelis.size(), p);
		return true;
	}
	
	public boolean anyadePeli(Pelicula p, int s) {
		for (Pelicula pelicula : pelis) {
			if (pelicula.esIgual(p)) {
				System.out.println("La pelicula esta en el cine");
				return false;
			}
		}
		if (salas[s]!=null) {
			System.out.println("La sala esta ocupada");
			return false;
		}
		if (salasDisponibles()==-1) {
			System.out.println("No quedan salas disponibles");
			return false;
		}
		pelis.set((s-1), p);
		return true;
	}
	
	
	public int salasDisponibles() {
		for (int i = 0; i < salas.length; i++) {
			if (salas[i]==null) {
				return i;
			}
		}
		return -1;
	}
	
	public void ver() {
		System.out.println(nombre);
		for (int i = 0; i < salas.length; i++) {
			if (salas[i]!=null) {
				for (Pelicula pelicula : pelis) {
					if (salaPeli(pelicula.getNombre(), pelicula.getDuracion()
							, pelicula.getAnyo())==i) {
						System.out.println(pelicula.getNombre()+" - Sala "+i);
					}
				}
			}
		}
	}
	
	public void quitarPeli(String str) {
		for (int i = 0; i < salas.length; i++) {
			if (pelis.get(i).getNombre().startsWith(str)) {
				pelis.remove(i);
			}
		}	
	}
	
	
	public ArrayList<Integer> libres(){
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for (int i = 0; i < salas.length; i++) {
			if (salas[i]==null) {
				arr.add(i);
			}
		}
		return arr;
	}
	
	public void cambiaDeSala(Pelicula peli) {
		for (int i = 0; i < salas.length; i++) {
			if (pelis.get(i).esIgual(peli)) {
				System.out.println(i);
			}
		}
		if (salasDisponibles()==-1) {
			System.out.println("No quedan salas disponibles");
		} else {
			System.out.println("Quedan salas disponibles");
			
			int sala=-1;
			do {
				System.out.println("A que sala deseas cambiarla");
				sala=Consola.leeInt();
			} while (salas[sala]!=null);
			salas[sala]=peli;
		}
	}
	
	public void resetearCine() {
		pelis.clear();
	}
	
	public ArrayList<String> pelisMasCortas(int horas, int minutos) {
		ArrayList<String> peli=new ArrayList<String>();
		for (Pelicula pelicula : pelis) {
			if (pelicula.getDuracion()<((horas*60)+minutos)) {
				peli.add(pelicula.getNombre());
			}
		}
		return peli;
	}
	
	
	
}
