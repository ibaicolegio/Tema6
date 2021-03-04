package t6t1e5;

import java.util.Arrays;

import t6t1e4.Rectangulo;

public class GestorRectangulos {

	Rectangulo[] rectangulos;

	public GestorRectangulos(Rectangulo[] rectangulos) {
		this.rectangulos = rectangulos;
	}

	public GestorRectangulos(int tamanio) {
		rectangulos= new Rectangulo[tamanio];
		for (int i = 0; i < rectangulos.length; i++) {
			rectangulos[i]= new Rectangulo();
		}
	}
	
	public int[] areas() {
		int[] areas=new int[rectangulos.length];
		for (int i = 0; i < rectangulos.length; i++) {
			areas[i]=rectangulos[i].area();
		}
		return areas;
	}
	
	public void verCuadrados() {
		for (int i = 0; i < rectangulos.length; i++) {
			if (rectangulos[i].getLado1()==rectangulos[i].getLado2()) {
				System.out.println("Rectangulo " + i + " " + rectangulos[i].toString());
			}
		}
	}
	
	public boolean cabeDentro(Rectangulo r1, Rectangulo r2) {
		if (r1.getLado1()<r2.getLado1()) {
			if (r1.getLado2()<r2.getLado2()) {
				return true;
			} else {
				return false;
			}
		
		} else {
			if (r1.getLado1()<r2.getLado2()) {
				if (r1.getLado2()<r2.getLado1()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}
	public int cuantosCabenDentro(Rectangulo rectangulo) {
		int cantidad=0;
		for (int i = 0; i < rectangulos.length; i++) {
			if (cabeDentro(rectangulos[i], rectangulo)==true) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public GestorRectangulos arrayFusion(GestorRectangulos rectangulos) {
		if (this.rectangulos.length!=rectangulos.rectangulos.length) {
			System.out.println("No son del mismo tamanio");
			return null;
		}
		int tamanio=this.rectangulos.length+rectangulos.rectangulos.length;
		GestorRectangulos fusion = new GestorRectangulos(tamanio);
		int i=0, r1=0, r2=0;
		while(i < tamanio) {
			if (r1<this.rectangulos.length) {
				fusion.rectangulos[i]=this.rectangulos[r1];
				r1++;
				i++;
			}
			if (r2<this.rectangulos.length) {
				fusion.rectangulos[i]=rectangulos.rectangulos[r2];
				r2++;
				i++;
			}
		}
		return fusion;
	}
	
	public String toString() {
		return "GestorRectangulos [rectangulos=" + Arrays.toString(rectangulos) + "]";
	}

	public static void main(String[] args) {
		
		GestorRectangulos g1 = new GestorRectangulos(100);
		GestorRectangulos g2 = new GestorRectangulos(100);
		
		g1.verCuadrados();
		System.out.println();
		
		System.out.println("Caben dentro=" + g1.cuantosCabenDentro(g1.rectangulos[2]));
		System.out.println();
		System.out.println(g1);
		System.out.println();
		System.out.println(g2);
		System.out.println();
		GestorRectangulos g3 = g1.arrayFusion(g2);
		System.out.println(g3);
	}
	
}
