package ej4;

public class MatrizDesigual {

	private Float[][] nums;

	public MatrizDesigual(Float[][] nums) {
		this.nums = nums;
	}
	
	public void cargarFila(Float[] arr, int fila) {
		fila--;
		for (int i = 0; i < arr.length; i++) {
			nums[fila][i]=arr[i];
		}
	}
	
	public void cargarFila(int n, int fila) {
		fila--;
		for (int i = 0; i < n; i++) {
			nums[fila][i]=(-50+(((float)Math.random())*101));
		}
	}
	
	public void verFila(int fila) {
		fila--;
		if (fila>nums.length-1) {
			
		}
		for (int i = 0; i < nums[fila].length; i++) {
			System.out.print(nums[fila][i]+ " | ");
		}
	}
	
	public void verMatriz() {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.print(nums[i][j]+" | ");
			}
			System.out.println();
		}
	}
	
	public static boolean esPrimo(int numero) {
		int contador = 2;
		  boolean primo=true;
		  while ((primo) && (contador!=numero)){
		    if (numero % contador == 0)
		      primo = false;
		    contador++;
		  }
		  return primo;
	}
	
	public static void main(String[] args) {
		MatrizDesigual md1;
		Float arr[][];
		
		
		
		Float f1[]=new Float[7];
		float num=1;
		for (int i = 0; i < f1.length; i++) {
			f1[i]=num;
			num*=3;
		}
		
		
		
		
		Float f2[]=new Float[7];
		num=0;
		for (int i = 0; i < f2.length; i++) {
			f2[i]=(float) Math.cos(num);
			num+=5;
		}
		
		
		
		Float f3[]=new Float[20];
		int nums=2;
		for (int i = 0; i < 20; i++) {
			while(esPrimo(nums)==false) {
				nums++;
			}
			if (esPrimo(nums)) {
				f3[i]=(float) nums;
				nums++;
			}			
		}
		
		
		
		
		Float f6[]=new Float[4];
		for (int i = 0; i < f6.length; i++) {
			f6[i]=(float) (1+Math.random()*50);
		}
		
		
		
		arr=new Float[][]{f1,f2,f3,f6};
		md1=new MatrizDesigual(arr);
		md1.verMatriz();
	}
	
}
