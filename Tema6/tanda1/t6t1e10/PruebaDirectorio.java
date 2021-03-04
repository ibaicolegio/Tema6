package t6t1e10;

public class PruebaDirectorio {

	public static void main(String[] args) {
		
		Directorio d1 = new Directorio("c:/   programs    /   java/jre", 3166728);
		Directorio d2 = new Directorio("c:/ programs /office /word/plantillas", 4215541);
		
		d1.ver();
		d2.ver();
		
		d2.setTamanio(d2.getTamanio()+d1.getTamanio()/2);
		
		d2.descompuesto();
		
		if (d1.niveles()>d2.niveles()) {
			System.out.println("d1 tiene mas niveles " + d1.niveles());
		} else {
			if (d2.niveles()>d1.niveles()) {
				System.out.println("d2 tiene mas niveles, tiene=" + d2.niveles());
			} else {
				System.out.println("Tienen los mismos niveles");
			}
		}
		
		System.out.println(d1.dirValido());
		System.out.println(d2.dirValido());
		
		if (d1.ultimo()!=d2.ultimo()) {
			String nombre=d2.getNombre();
			String ultimo="D2"+d2.ultimo();
			d2.setNombre(nombre.replaceAll(d2.ultimo(), ultimo));
		}
		
		d1.ver();
		d2.ver();
		
		d1.compactarDir();
		d2.compactarDir();
		
		System.out.println();
		d1.ver();
		d2.ver();
	}
	
	
}
