package ej2;

import java.util.ArrayList;
import java.util.Iterator;

public class Array {

	private ArrayList<Punto> puntos;
	
	public Array() {
		puntos=new ArrayList<Punto>();
		puntos.add(new Punto(0, 0));
		puntos.add(new Punto(1, -1));
		puntos.add(new Punto(2, -10));
		puntos.add(new Punto(-2, 4));
	}

	public Array(ArrayList<Punto> puntos) {
		this.puntos=puntos;
	}
	
	public void verPuntos() {
		for (Punto punto : puntos) {
			System.out.print(punto+" | ");
		}
		System.out.println();
	}
	
	public void verPuntosOrdenInverso() {
		for (int i = puntos.size()-1; i >= 0; i--) {
			System.out.print(puntos.get(i)+" | ");
		}
		System.out.println();
	}
	
	public Punto puntoSegundoCuadrante() {
		Iterator<Punto> it=puntos.iterator();
		while(it.hasNext()) {
			Punto p1 = it.next();
			if(p1.segundoCuadrante()) {
				return p1;
			}
		}
		return null;
		
	}
	
	public void verIndicePrimerPunto() {
		Punto p1 = new Punto(0,0);
		boolean tieneIndice=false;
		for (int i = 0; i < puntos.size(); i++) {
			if (puntos.get(i).equals(p1)) {
				System.out.println(puntos.indexOf(p1));
				tieneIndice=true;
			}
		}
		if (!tieneIndice) {
			System.out.println("El ArrayList no contiene (0,0)");
		}
		
	}
	
	public void verIndicePrimerPuntoRedefinido() {
		Punto p1 = new Punto(1,1);
		boolean tieneIndice=false;
		for (int i = 0; i < puntos.size(); i++) {
			if (puntos.get(i).equals(p1)) {
				System.out.println(puntos.indexOf(p1));
				tieneIndice=true;
			}
		}
		if (!tieneIndice) {
			System.out.println("El ArrayList no contiene (1,1)");
		}
		
	}
	
	public void borrarPuntoDistancia10() {
		Punto p1=new Punto(0,0);
		boolean borrado=false;
		for (int i = 0; i < puntos.size() && borrado==false; i++) {
			if (puntos.get(i).distancia(p1)>10) {
				puntos.remove(i);
				borrado=true;
				System.out.println("Se a borrado el punto numero "+(i+1));
			}
		}
		if (!borrado) {
			System.out.println("No se ha borrado ninguno");
		}
	}
	

	public void borrarCuartoCuadrante() {
		Iterator<Punto> it=puntos.iterator();
		while (it.hasNext()) {
			Punto p1 = it.next();
			if(p1.cuartoCuadrante()) {
				it.remove();
			}			
		}
	}
	
	public static void main(String[] args) {
		Array a1 = new Array();
		a1.verPuntos();
		a1.verPuntosOrdenInverso();
		System.out.println(a1.puntoSegundoCuadrante());
		a1.verIndicePrimerPunto();
		a1.verIndicePrimerPuntoRedefinido();
		a1.borrarPuntoDistancia10();
		a1.verPuntos();
		a1.borrarCuartoCuadrante();
		a1.verPuntos();
	}
}
