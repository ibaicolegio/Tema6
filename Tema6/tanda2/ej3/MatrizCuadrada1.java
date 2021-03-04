package ej3;

public class MatrizCuadrada1 extends Matriz1{

	public MatrizCuadrada1() {
	}

	public MatrizCuadrada1(int nFilas) {
		super(nFilas, nFilas);
	}
	
	public void cargarIdentidad() {
		int num[][] = new int[getArr().length][getArr().length];
		for (int i = 0; i < getArr().length; i++) {
			for (int j = 0; j < getArr().length; j++) {
				if(j==i)
					num[i][j]=1;
				else
					num[i][j]=0;
			}
		}
		setArr(num);
	}
	
	public boolean esCuadradoMagico() {
		int suma=0, aux=0;
		for (int i = 0; i < getArr().length; i++) {
			suma+=getArr()[i][0];
		}
		for (int i = 0; i < getArr().length; i++) {
			aux+=getArr()[0][i];
		}
		if(suma!=aux)
			return false;
		aux=0;
		for (int i = 0; i < getArr().length; i++) {
			aux+=getArr()[i][i];
		}
		if(suma!=aux)
			return false;
		aux=0;
		for (int i = getArr()[0].length-1, j=0; i >= 0; i--, j++) {
			aux+=getArr()[i][j];
		}
		if(suma!=aux)
			return false;
		return true;
	}
	
	public boolean esSimetrica() {
		if ((getArr().length!=transpuesta().getArr().length)||(getArr()[0].length!=transpuesta().getArr()[0].length)) {
			return false;
		}
		for (int i = 0; i < getArr().length; i++) {
			for (int j = 0; j < getArr()[0].length; j++) {
				if (getArr()[i][j]!=transpuesta().getArr()[i][j])
					return false;
			}
		}
		return true;
		
	}
	
	public void cargarCuadradoMagico() {
		//(getArr().length*getArr()[0].length)
		int j=0,k=getArr().length/2;
		int[][] arr=new int[getArr().length][getArr()[0].length];
		boolean par=false;
		if (getArr().length%2==0) {
			par = true;
		}
		for (int i = 1; i <= getArr().length*getArr().length; i++) {
			arr[j][k]=i;
			j--;
			k++;
			if (j<0) {
				j=arr.length-1;
			}
			if (k>arr[0].length-1) {
				k=0;
			}
			if (arr[j][k]!=0) {
				j+=2;
				k--;
			}
			if (k<0) {
				k=arr.length-1;
			}
			if (j>arr[0].length-1 && par==false) {
				j=1;
			}
			if (j>arr[0].length-1 && par==true) {
				j=0;
			}
		} 
		setArr(arr);
	}
	
	public boolean iguales(MatrizCuadrada1 mc) {
		if (getArr().length!=mc.getArr().length) {
			return false;
		}
		for (int i = 0; i < getArr().length; i++) {
			for (int j = 0; j < getArr().length; j++) {
				if (getArr()[i][j]!=mc.getArr()[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		MatrizCuadrada1 mc1 = new MatrizCuadrada1();
		mc1.ver();
		System.out.println();
		mc1.cargarIdentidad();
		mc1.ver();
		MatrizCuadrada1 mc2 = new MatrizCuadrada1(3);
		mc2.setArr(new int[][]{{4,3,8},{9,5,1},{2,7,6}});
		System.out.println(mc2.esCuadradoMagico());
		System.out.println(mc1.esCuadradoMagico());
		System.out.println();
		MatrizCuadrada1 mc3 = new MatrizCuadrada1(3);
		mc3.setArr(new int[][]{{1,1,1},{1,1,1},{1,1,1}});
		System.out.println(mc3.esSimetrica());
		mc3.ver();
		System.out.println();
		mc3.transpuesta().ver();
		System.out.println();
		MatrizCuadrada1 mc4 = new MatrizCuadrada1(5);
		mc4.cargarCuadradoMagico();
		mc4.ver();
		System.out.println();
		System.out.println(mc3.iguales(mc4));
		MatrizCuadrada1 mc5 = new MatrizCuadrada1(3);
		System.out.println();
		mc5.setArr(new int[][]{{1,1,1},{1,1,1},{1,1,1}});
		System.out.println(mc3.iguales(mc5));
	}

	
}
