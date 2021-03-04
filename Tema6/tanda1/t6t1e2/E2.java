package t6t1e2;

import t6t1e1.Consola;

public class E2 {

	private static int introducirEnCadena(String[] cadenas){
		String texto="hola";
		int longitud=0;
		for (int i = 0; i < cadenas.length && !(texto.equals("quit") || texto.equals("QUIT")); i++) {
			System.out.println("Cadena Nº "+i);
			texto=Consola.leeString();
			if(!(texto.equals("quit") || texto.equals("QUIT"))){
				cadenas[i]=texto;
				longitud++;
			}
		}
		return longitud;
	}

	
	private static String[] corregirCadena(String[] cadenas, int ultimo) {
		String[] aux=new String[ultimo];
		for (int i = 0; i < ultimo; i++) {
			aux[i]=cadenas[i];
		}
		return aux;
	}
	
	private static String[] cadenaInversa(String[] cadenas, int ultimo) {
		String[] inversa=new String[ultimo];
		for (int i = 0; i <= ultimo; i++, ultimo--) {
			inversa[i]=primeraMayusculas(cadenas[ultimo-1]);
		}
		return inversa;
	}

	private static void ver(String[] cadenas) {
		for (int i = 0; i < cadenas.length; i++) {
			if(cadenas[i]!=null) {
				System.out.print(cadenas[i]+" | ");
			}
		}
		System.out.println();
	}
	
	private static String primeraMayusculas(String str){
		String aux="";
		int anterior=0;
		int i = 0;
		for (;i < str.length(); i++) {
			if (str.charAt(i)==' ') {
				aux+=(str.toUpperCase().charAt(anterior));
				aux+=str.toLowerCase().substring(anterior+1,i);
				anterior=i+1;
				i++;
				aux+=" ";
				while(str.charAt(i)==' ' && i<str.length()) {
					anterior++;
					i++;
				}
			}
		}
		aux+=(str.toUpperCase().charAt(anterior));
		aux+=str.toLowerCase().substring(anterior+1,i);
		return aux;
	}
	
	public static void main(String[] args) {
		String[] cadenas=new String[100];
		int ultimo=introducirEnCadena(cadenas);
		ver(cadenas);
		String[] cadenaCorregida=new String[ultimo];
		cadenaCorregida=corregirCadena(cadenas, ultimo);
		ver(cadenaCorregida);
		cadenaCorregida=cadenaInversa(cadenaCorregida, ultimo);
		ver(cadenaCorregida);
	}
}
