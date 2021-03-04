package t6t1e1;

public class E1 {
	
	static void introducirNotas(int[] notas) {
		for (int i = 0; i < notas.length; i++) {
			do {
				System.out.println("Alumno "+i+" nota:");
				notas[i]=Consola.leeInt();
			} while (notas[i]<0||notas[i]>10);
		}
	}
	static float calcularMedia(int[] notas) {
		float media=0;
		for (int i = 0; i < notas.length; i++) {
			media+=notas[i];
		}
		media/=(float)notas.length;
		return media;
	}
	static void porcenSuperaMedia(int[] notas) {
		float media=calcularMedia(notas), notaMax=0;
		int cant=0, cantNotaMax=0;
		for (int i = 0; i < notas.length; i++) {
			if (notas[i]>media) {
				cant++;
			}
			if (notas[i]==notaMax) {
				cantNotaMax++;
			}
			if (notas[i]>notaMax) {
				cantNotaMax=1;
				notaMax=notas[i];
			}
			
		}
		System.out.println((float)cant/notas.length*100);
		System.out.println("Nota mas alta "+notaMax);
		System.out.println("Veces se repite "+cantNotaMax);
	}
	public static void main(String[] args) {
		System.out.println("Cuantos alumnos?");
		final int N=Consola.leeInt();
		int[] notas=new int[N];
		introducirNotas(notas);
		porcenSuperaMedia(notas);
	}
}
