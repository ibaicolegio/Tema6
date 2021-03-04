package t6t1e8;

import java.util.Arrays;

import t6t1e1.Consola;

public class Insercion {

	public static int cargar(char[] c1) {
		int total=0;
		char otro='S';
		for (int i = 0; i < c1.length && otro=='S'; i++) {
			System.out.println("Introduce carácter " + i);
			c1[i]=Consola.leeChar();
			total++;
			do {
				System.out.println("Desea introducir otro carácter (S/N)?");
				otro=Consola.leeChar();
			} while (otro!='S' && otro!='N');
		}
		return total;
	}
	
	public static void verArray(char[] c1) {
		System.out.println(Arrays.toString(c1));
	}
	
	public static int insertarCar(char[] c1, char car, int n, int total) {
		if (c1[c1.length-1]=='\0') {
			int ultima=c1.length-2;
			for (int i = n; i < c1.length; i++) {
				for (int j = i; j <= ultima; ultima--) {
					c1[ultima+1]=c1[ultima];
				}
			}
			c1[n]=car;
			total++;
		} else {
			System.out.println("No hay espacio");
		}
		return total;
	}
	
	
	public static void main(String[] args) {
		
		char[] c1=new char[5];
		int total=cargar(c1);
		verArray(c1);
		char otro='S', car;
		int pos;
		do {
			System.out.println("Caracter");
			car=Consola.leeChar();
			System.out.println("Posicion");
			pos=Consola.leeInt();
			total=insertarCar(c1, car, pos, total);
			if (otro=='S' && total<c1.length) {
				System.out.println("Otro (S/N)?");
				otro=Consola.leeChar();
			}
		} while (otro=='S' && total<c1.length);
		verArray(c1);
	}
}
