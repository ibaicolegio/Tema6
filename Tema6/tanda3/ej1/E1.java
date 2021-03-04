package ej1;

import java.util.ArrayList;

public class E1 {
	
	public static void cargarArrayList(ArrayList<Integer> arr) {
			arr.add((int) (50-Math.random()*101));
		
	}
	
	public static void verArrayList(ArrayList<Integer> arr) {
		for (Integer integer : arr) {
			System.out.print(integer + " | ");
		}
		System.out.println();
	}
	
	public static void cargarDivisores(ArrayList<Integer> arr, int n) {
		int num=n-1, cant=0;
		for (int i = n-1; i > 0 && cant<10; i--) {
			if (n%i==0) {
				arr.add(i);
				cant++;
			}
		}
	}

	public static void cargarNumerosAleatorios(ArrayList<Integer> arr) {
		int num=0;
		for (int i = 0; i < 20; i++) {
			num=(int) (20-Math.random()*41);
			while(arr.contains(num)) {
				num=(int) (20-Math.random()*41);
			}
			arr.add(num);
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> nums=new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			cargarArrayList(nums);
		}
		verArrayList(nums);
		nums.clear();
		verArrayList(nums);
		cargarDivisores(nums, 1000);		
		verArrayList(nums);
		System.out.println();
		cargarNumerosAleatorios(nums);
		verArrayList(nums);
		
	}
}
