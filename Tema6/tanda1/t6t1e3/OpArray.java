package t6t1e3;

import java.util.Arrays;

import t6t1e1.Consola;

public class OpArray {

	private int[] enteros;
	private int[] numerosProhibidos=new int[50];
	private int cantidad;
	private final int tamanio=10;
	
	public OpArray() {
		enteros = new int[tamanio];
		cantidad=0;
	}
	
	public OpArray(int tamanio) {
		enteros = new int[tamanio];
		cantidad=tamanio;
	}
	
	public int cantidad(int[] cantidad) {
		int i = 0;
		for (; i < enteros.length; i++) {
			if (enteros[i]==0) {
				return i;
			}
		}
		return i;
	}
	
	
	public void cargarArray() {
		boolean salir=false;
		int numero;
		for (int i = 0; i < enteros.length && salir==false; i++) {
			System.out.println("Introduce el numero " + i);
			numero=Consola.leeInt();
			if (numero==0 || prohibido(numero))
				salir=true;
			else {
				enteros[i]=numero;
				cantidad++;
			}
		}
	}
	
	public boolean prohibido(int numero) {
		for (int i = 0; i < numerosProhibidos.length; i++) {
			if (numero==numerosProhibidos[i]) {
				return true;	
			}
		}
		return false;
	}
	
	public void ver() {
		for (int i = 0; i < cantidad; i++) {
			System.out.print(enteros[i]+" | ");
		}
		System.out.println();
	}

	public String toString() {
		String str="";
		for (int i = 0; i < enteros.length; i++) {
			if (enteros[i]!=0)
				str+=enteros[i];
		}
		return str;
	}
	
	public int indicePrimo() {
		for (int i = 0; i < enteros.length; i++) {
			if (esPrimo(enteros[i])) {
				return i;
			}
		}
		return -1;
		
	}
	
	public boolean esPrimo(int numero) {
		int contador=2;
		while(contador<=numero/2) {
			if (numero%contador==0) {
				return false;
			}
			contador++;
		}
		return true;
	}
	
	public void rotar(int cambios) {
		int cantidad=cantidad(enteros);
		int[] aux =  new int[cantidad];
		int[] aux2 =  new int[cantidad];
		for (int i = 0; i < aux.length; i++) {
			aux2[i]=enteros[i];
		}
		for (int j = 0; j < cambios; j++) {
			for (int i = 0; i < aux.length-1; i++) {
				aux[i+1]=aux2[i];
			}
			aux[0]=aux2[cantidad-1];
			for (int i = 0; i < aux.length; i++) {
				aux2[i]=aux[i];
			}
		}
		for (int i = 0; i < aux.length; i++) {
			enteros[i]=aux[i];
		}
	}
	
	public static void main(String[] args) {
		OpArray o1 = new OpArray();
		OpArray o2 = new OpArray(5);
		o1.cargarArray();
		o1.ver();
		System.out.println(o1.toString());
		System.out.println("Indice del primo="+o1.indicePrimo());
		o1.rotar(2);
		o1.ver();
		
	}
	
	
}
