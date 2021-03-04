package t6t1e9;

public class GestorBorradoArray {

	private int[] enteros;
	private final int N=10;
	private int cantidad;
	
	public GestorBorradoArray() {
		enteros = new int[N];
		cantidad=0;
		int numeros=100;
		for (int i = 0; i < enteros.length; i++) {
			enteros[i]=numeros;
			numeros--;
			cantidad++;
		}
	}
	
	public void ver() {
		for (int i = 0; i < enteros.length; i++) {
			System.out.print(enteros[i]+" | ");
		}
		System.out.println();
	}
	
	public void borrarPosicion(int n) {
		for (int i = n; i < cantidad-1; i++) {
			enteros[i]=enteros[i+1];
			
		}
		enteros[cantidad-1]=0;
		cantidad--;
	}
	
	public static void main(String[] args) {
		GestorBorradoArray g1 = new GestorBorradoArray();
		
		g1.ver();
		g1.borrarPosicion(5);
		g1.ver();
		g1.borrarPosicion(1);
		g1.ver();
		g1.borrarPosicion(0);
		g1.ver();
	}
	
	
}
