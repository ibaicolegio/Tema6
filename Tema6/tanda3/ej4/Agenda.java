package ej4;

import java.util.HashMap;
import java.util.Iterator;

import t6t1e1.Consola;

public class Agenda {

	private HashMap<String, Integer[]> entradas;
	private int maxNumEntradas;
	
	public Agenda(int maxNumEntradas) {
		this.maxNumEntradas = maxNumEntradas;
		entradas=new HashMap<>();
	}
	
	public void añadeEntrada(String nombre, Integer[] telefonos) {
		if (entradas.size()==maxNumEntradas) {
			System.out.println("Agenda completa");
		} else {
			if (entradas.containsKey(nombre)) {
				Integer[] numeros = entradas.get(nombre);
				System.out.print("Su agenda ya dispone de los siguientes telefonos para " + nombre+": ");
				for (int i = 0; i < numeros.length; i++) {
					System.out.print(numeros[i]+", ");
				}
				System.out.println();
				System.out.println("Desea sustituir por los nuevos?");
				String resp=Consola.leeString();
				if (resp.equalsIgnoreCase("si")) {
					entradas.put(nombre, telefonos);
				}
			} else {
				entradas.put(nombre, telefonos);
			}
		}
	}
	
	public void ver() {
		Iterator<String> it= entradas.keySet().iterator();
		Iterator<Integer[]> va=entradas.values().iterator();
		while (it.hasNext()) {
			String clave=it.next();
			Integer[] valor=va.next();
			System.out.print("Nombre="+clave+" | telefonos=");
			for (int i = 0; i < valor.length; i++) {
				System.out.print(valor[i]+" ");
			}
			System.out.println();
		}
	}
	
	public String buscarNombre(String nombre) {
		Integer[] numeros=entradas.get(nombre);
		if (numeros==null) {
			return "No se encuentra en la agenda";
		}
		String nums="";
		for (int i = 0; i < numeros.length; i++) {
			nums+=numeros[i]+", ";
		}
		return nums;
	}
	
	public Integer cuantosTelefonos(Integer telefono) {
		int ctd=0;
		Iterator<String> clave=entradas.keySet().iterator();
		while (clave.hasNext()) {
			String nombre=clave.next();
			Integer[] numeros=entradas.get(nombre);
			for (int i = 0; i < numeros.length; i++) {
				if (numeros[i].equals(telefono)) {
					ctd++;
					i=numeros.length;
				}
			}
		}
		return ctd;
	}
	
	public static void main(String[] args) {
		Agenda a1=new Agenda(5);
		Integer t1[]=new Integer[] {212122,838383,272772,38933};
		Integer t2[]=new Integer[] {737373,158481,161121,97810};
		a1.añadeEntrada("Juan", t1);
		a1.añadeEntrada("Juan", t2);
		a1.añadeEntrada("Marta", t2);
		a1.añadeEntrada("Carlos", t2);
		a1.añadeEntrada("Jon", t2);
		a1.añadeEntrada("Maria", t2);
		a1.añadeEntrada("Javier", t2);
		System.out.println();
		a1.ver();
		System.out.println();
		System.out.println(a1.buscarNombre("Juan"));
		System.out.println(a1.cuantosTelefonos(737373));
		
	}
}
