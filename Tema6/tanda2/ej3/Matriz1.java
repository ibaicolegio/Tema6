package ej3;

public class Matriz1 {

	private int arr[][];
	private final static int NF=10,NC=7;
	
	public Matriz1() {
		if (this instanceof MatrizCuadrada1) {
			arr=new int[NC][NC];
		} else {
			arr=new int[NF][NC];
		}
		cargarPorFilas();
	}

	public Matriz1(int nFilas, int nColumnas) {
		if (nFilas>NF)
			nFilas=NF;
		if (nColumnas>NC)
			nColumnas=NC;
		if (this instanceof MatrizCuadrada1) {
			arr=new int[nFilas][nFilas];
		} else {
			arr=new int[nFilas][nColumnas];
		}
		cargarPorFilas();
	}
	
	private void cargarPorFilas() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=(10*(i)+1+(int)(Math.random()*10));
			}
		}
	}
	
	public void ver() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t|\t");
			}
			System.out.println();
		}
	}
	
	public void invertirFilas() {
		int aux=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0, j2=arr[i].length-1; j < arr[i].length/2; j++, j2--) {
				aux=arr[i][j];
				arr[i][j]=arr[i][j2];
				arr[i][j2]=aux;
			}
			
		}
	}
	
	public boolean intercambiarFilas(int n1, int n2) {
		if (0> n1-1 || n1-1>arr.length || 0>n2-1 || n2-1>arr.length) {
			return false;
		}
		if (!(arr[n1-1].length==arr[n2-1].length))
			return false;
		int aux;
		for (int i = 0; i < arr[n1-1].length; i++) {
			aux=arr[n1-1][i];
			arr[n1-1][i]=arr[n2-1][i];
			arr[n2-1][i]=aux;
		}
		return true;
	}
	
	public boolean intercambiarColumnas(int n1, int n2) {
		n1--;
		n2--;
		if (0> n1 || n1>arr[0].length || 0>n2 || n2>arr[0].length) {
			return false;
		}
		int aux;
		for (int i = 0; i < arr.length; i++) {
			aux=arr[i][n1];
			arr[i][n1]=arr[i][n2];
			arr[i][n2]=aux;
		}
		return true;
		
	}
	
	public Matriz1 transpuesta(){
		Matriz1 matriz=new Matriz1(arr[0].length, arr.length);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				matriz.arr[j][i]=arr[i][j];
			}
		}
		return matriz;
	}
	
	public int[][] getArr() {
		return arr;
	}

	public void setArr(int[][] arr) {
		this.arr = arr;
	}

	public static void main(String[] args) {
		/*
		Matriz1 m1 = new Matriz1(3,5);
		m1.ver();
		System.out.println();
		m1.invertirFilas();
		m1.ver();
		System.out.println();
		if(m1.intercambiarFilas(1, 10)==true)
			m1.ver();
		else
			System.out.println("No se han podido intercambiar las filas");
		System.out.println();
		if(m1.intercambiarColumnas(1, 7)==true)
			m1.ver();
		else
			System.out.println("No se han podido intercambiar las columnas");
		System.out.println();
		Matriz1 m2=m1.transpuesta();
		m2.ver();
		*/
		Matriz1 m1=new Matriz1();
		m1.ver();
		System.out.println();
		if(m1.intercambiarFilas(1, 10)==true)
			m1.ver();
		else
			System.out.println("No se han podido intercambiar las filas");
		System.out.println();
		if(m1.intercambiarColumnas(1, m1.arr.length/2)==true)
			m1.ver();
		else
			System.out.println("No se han podido intercambiar las columnas");
		Matriz1[] arrMatrices = new Matriz1[] {new Matriz1(2,2),new Matriz1(4,7),new Matriz1(6,1),new Matriz1(5,2)};
		for (int i = 0; i < arrMatrices.length; i++) {
			System.out.println();
			System.out.println("Arr="+(i+1));
			arrMatrices[i].ver();
			
		}
	}
	
}
