package ej1;

import t6t1e1.Consola;

public class Ejercicio1 {

	/*
	public static void rellenar(int[][] notas) {
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				System.out.println("Introduce nota, alumno=" + (i+1) + ", asignatura="+(j+1));
				notas[i][j]=Consola.leeInt();
			}
		}
	}
	*/
	
	public static void ver(int[][] notas) {
		for (int i = 0; i < notas.length; i++) {
			System.out.print("Alumno="+(i+1));
			for (int j = 0; j < notas[i].length; j++) {
				System.out.print(" | asignatura="+(j+1)+", nota="+notas[i][j]);
			}
			System.out.println();
		}
	}
	
	public static int mediaMayor(int[][] notas) {
		int asigMediaMayor=-1;
		double mayorMedia=0;
		for (int j = 0; j < notas[0].length; j++) {
			double media=0;
			for (int i = 0; i < notas.length; i++) {
				media+=notas[i][j];
			}
			if (media/notas.length>mayorMedia) {
				mayorMedia=media/notas.length;
				asigMediaMayor=j;
			}
		}
		return asigMediaMayor+1;
	}
	
	public static double[] suspensos(int[][] notas){
		double suspensos[]=new double[notas.length];
		int suspenso;
		for (int i = 0; i < notas.length; i++) {
			suspenso=0;
			for (int j = 0; j < notas[i].length; j++) {
				if (notas[i][j]<5) {
					suspenso++;
				}
			}
			suspensos[i]=((double)suspenso/notas[i].length)*100;
		}
		return suspensos;
	}
	
	public static int[][] resultados(int[][] notas){
		int resultados[][]=new int[notas.length][4];
		for (int i = 0; i < notas.length; i++) {
			resultados[i][0]=0;
			resultados[i][1]=0;
			resultados[i][2]=0;
			resultados[i][3]=0;
			for (int j = 0; j < notas[i].length; j++) {
				if (notas[i][j]<5) {
					resultados[i][0]++;
				} else {
					if (notas[i][j]<7) {
						resultados[i][1]++;
					} else {
						if (notas[i][j]<9) {
							resultados[i][2]++;
						} else {
							resultados[i][3]++;
						}
					}
				}
			}
		}
		return resultados;
	}

	public static void verResultados(int[][] notas) {
		for (int i = 0; i < notas.length; i++) {
			System.out.print("Alumno="+(i+1));
			System.out.print(" | Suspensos="+notas[i][0]);
			System.out.print(" | Aprobados="+notas[i][1]);
			System.out.print(" | Notables="+notas[i][2]);
			System.out.print(" | Sobresalientes="+notas[i][3]);
			System.out.println();
		}
	}
	
	public static void verSuspensos(double[] suspensos) {
		for (int i = 0; i < suspensos.length; i++) {
			System.out.println("Alumno="+(i+1)+", porcentaje supensos="+(int)suspensos[i]+"%");
		}
	}
	
	public static void main(String[] args) {
		
		int notas[][];
		//System.out.println("Introduce alumnos");
		//int n=Consola.leeInt();
		//System.out.println("Introduce asignaturas");
		//int m=Consola.leeInt();
		//notas=new int[n][m];
		//rellenar(notas);
		notas= new int[][]{{8,8,6},{4,7,10}};
		ver(notas);
		System.out.println();
		System.out.println("Numero de asignatura con media mayor="+mediaMayor(notas));
		System.out.println();
		double suspensos[]=suspensos(notas);
		verSuspensos(suspensos);
		System.out.println();
		int resultados[][]=resultados(notas);
		verResultados(resultados);
	}
}
