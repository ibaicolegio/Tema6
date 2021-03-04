package t6t1e6;

import t6t1e1.Consola;

public class E6 {

	public static void main(String[] args) {
		
		float[] f1 = new float[10];
		int numero=0, anterior=Integer.MAX_VALUE, i = 0;
		while ( i < f1.length) {
			System.out.println("Introduce numero " + i);
			numero=Consola.leeInt();
			if (numero<=anterior) {
				f1[i]=numero;
				anterior=numero;
				i++;
			}
			
		}
		for (int j = 0; j < f1.length; j++) {
			System.out.print(f1[j] + " | ");
		}
	}
}
