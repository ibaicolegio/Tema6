package t6t1e7;

import java.util.Arrays;

import t6t1e1.Consola;

public class E7 {

	public static int[] cargarNumeros(int tamanio) {
		int[] array= new int[tamanio];
		int num=0, anterior=Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			System.out.println("Numero " + i);
			num=Consola.leeInt();
			while(num<=anterior) {
				System.out.println("Error, debe ser mayor a=" + anterior);
				System.out.println("Numero " + i);
				num=Consola.leeInt();
			}
			array[i]=num;
			anterior=num;
		}
		return array;
	}
	
	public static int[] ordenarArray(int[] arr1, int a1, int[] arr2, int a2) {
		int tamanio=a1+a2;
		int[] arr=new int[tamanio];
		for (int i = 0, i1=0, i2=0; i < arr.length; i++) {
			if (i1==a1) {
				arr[i]=arr2[i2];
				i2++;
			} else {
				if (i1==a2) {
					arr[i]=arr2[i1];
					i1++;
				} else {
					if (arr1[i1]>arr2[i2]) {
						arr[i]=arr2[i2];
						i2++;
					} else {
						arr[i]=arr2[i1];
						i1++;
					}
				}
			}
		}
		return arr;
	}
	
	public static void verArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		int[] i1, i2, i3;
		
		i1=cargarNumeros(Integer.parseInt(args[0]));
		i2=cargarNumeros(Integer.parseInt(args[1]));
		i3=ordenarArray(i1, Integer.parseInt(args[0]), i2, Integer.parseInt(args[0]));
		
		verArray(i1);
		verArray(i2);
		verArray(i3);
		
	}
}
