package t6t1e10;

import t6t1e1.Consola;

public class GestorDirectorios {

	private Directorio[] rutas;
	private int posicion;

	public GestorDirectorios(int tamanio) {
		rutas=new Directorio[tamanio];
		posicion=0;
	}
	
	public void ver() {
		for (int i = 0; i < posicion; i++) {
			System.out.print(rutas[i].getNombre() + " | ");
		}
		System.out.println();
	}
	
	public void aniadeDirectorio(Directorio direct) {
		if (posicion==rutas.length) {
			System.out.println("No ha sido posible introducirlo");
		} else {
			rutas[posicion]=direct;
			posicion++;
		}	
	}
	
	public long tamanioTotal() {
		int tamanio=0;
		for (int i = 0; i < posicion; i++) {
			tamanio+=rutas[i].getTamanio();
		}
		return tamanio;
	}
	
	public void verTamanioTotal() {
		long tamanio=tamanioTotal();
		long mb,kb,b;
		mb=tamanio/1048576;
		kb=(tamanio-(mb*1048576))/1024;
		b=tamanio-(mb*1048576)-(kb/1024);
		System.out.println("MB="+mb+", KB="+kb+", Bytes="+b);
	}
	
	public static void main(String[] args) {
		GestorDirectorios g1 = new GestorDirectorios(10);
		String nombre;
		long bytes;
		for (int i = 0; i < 3; i++) {
			System.out.println("Introduce el nombre "+i);
			nombre=Consola.leeString();
			System.out.println("Introduce el tamaño "+i);
			bytes=Consola.leeLong();
			g1.aniadeDirectorio(new Directorio(nombre,bytes));
		}
		
		g1.ver();
		for (int i = 0; i < g1.posicion; i++) {
			if (g1.rutas[i].niveles()>4) {
				System.out.print(g1.rutas[i].getNombre()+" | ");
			}
		}
		g1.aniadeDirectorio(new Directorio(g1.rutas[g1.posicion-1].getNombre(),g1.rutas[g1.posicion-1].getTamanio()));
		for (int i = 0; i < g1.posicion; i++) {
			if (!g1.rutas[i].dirValido().equals("ok")) {
				System.out.println(g1.rutas[i].getNombre());
				System.out.println(g1.rutas[i].dirValido());
			}
		}
		for (int i = 0; i < g1.posicion; i++) {
			g1.rutas[i].compactarDir();
		}
		g1.ver();
		g1.verTamanioTotal();
	}
}
