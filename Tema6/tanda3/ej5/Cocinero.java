package ej5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import t6t1e1.Consola;

public class Cocinero {

	ArrayList<Ingrediente> ingredientes;
	HashMap<String, Plato> platos;
	
	public Cocinero(ArrayList<Ingrediente> ingredientes, HashMap<String, Plato> platos) {
		this.ingredientes = ingredientes;
		this.platos = platos;
	}
	
	public void aniadirIngrediente(Ingrediente ingrediente) {
		
		boolean encontrado=false;
		for (int i = 0; i < ingredientes.size() && !encontrado; i++) {
			if (ingredientes.get(i).getNombre().equals(ingrediente.getNombre())) {
				System.out.println("Ya existe el ingrediente. ¿Quieres cambiarlo?");
				String resp=Consola.leeString();
				if (resp.equalsIgnoreCase("si")) {
					ingredientes.set(i, ingrediente);
				}
				encontrado=true;
			}
		}
		if (!encontrado)
			ingredientes.add(ingrediente);
		
	}
	
	public void aniadirIngredientes(ArrayList<Ingrediente> lst) {
		Iterator<Ingrediente> it= lst.iterator();
		while(it.hasNext()) {
			Ingrediente ing=it.next();			
			aniadirIngrediente(ing);
		}
	}
	
	public void aniadirPlato(Plato p) {
		Iterator<Plato> it= platos.values().iterator();
		if (!it.hasNext()) {
			platos.put(p.getNombre(), p);
		}
		while(it.hasNext()) {
			if(!it.next().getNombre().equals(p.getNombre())) {
				platos.put(p.getNombre(), p);
			}
		}
	}
	
	public void aniadirPlatoRandom(String nombrePlato, int n) {
		if (n>ingredientes.size()) {
			System.out.println("No hay suficientes ingredientes");
			return;
		}
		HashSet<Ingrediente> ingredient= new HashSet<Ingrediente>();
		ArrayList<Integer> num=new ArrayList<Integer>();
		int numero;
		for (int j = 0; j < n; j++) {
			do {
				numero=(int) (-1+Math.random()*ingredientes.size());
			} while (num.contains(numero));
			ingredient.add(ingredientes.get(numero));
		}
		Plato plato=new Plato(nombrePlato, ingredient);
		if (platos.containsKey(nombrePlato)) {
			System.out.println("El nombre del plato ya existe. ¿Desea agregarlo?");
			String resp=Consola.leeString();
			if (resp.equalsIgnoreCase("si")) {
				platos.put(nombrePlato, plato);
			}
		}
		platos.put(nombrePlato, plato);
	}
	
	public void verMapa(int calorias) {
		Iterator<Plato> it= platos.values().iterator();
		int cal;
		while (it.hasNext()) {
			Plato p=it.next();
			HashSet<Ingrediente> i=p.getIngredientes();
			Iterator<Ingrediente> ing= i.iterator();
			cal=0;
			while (ing.hasNext()) {
				cal+=ing.next().getCalorias();
			}
			if (cal<=calorias) {
				System.out.println(p);
			}
		}
	}
	
	public void eliminarCalorias(int calorias) {
		Iterator<Plato> it= platos.values().iterator();
		while (it.hasNext()) {
			Plato p=it.next();
			HashSet<Ingrediente> i=p.getIngredientes();
			Iterator<Ingrediente> ing= i.iterator();
			while (ing.hasNext()) {
				Ingrediente ingr=ing.next();
				if (ingr.getCalorias()>calorias) {
					ing.remove();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Ingrediente i1=new Ingrediente("Queso", 50);
		Ingrediente i2=new Ingrediente("Atun", 70);
		Ingrediente i3=new Ingrediente("Huevo", 10);
		Ingrediente i4=new Ingrediente("Cebolla", 100);
		ArrayList<Ingrediente> in1= new ArrayList<Ingrediente>();
		in1.add(i1);
		in1.add(i2);
		in1.add(i3);
		HashSet<Ingrediente> ing1=new HashSet<Ingrediente>();
		ing1.add(i2);
		ing1.add(i4);
		Plato p1=new Plato("Tortilla", ing1);
		HashMap<String, Plato> pl1=new HashMap<String, Plato>();
		Cocinero c1=new Cocinero(in1, pl1);
		
		//c1.aniadirIngrediente(i1);
		//c1.aniadirIngredientes(in1);
		c1.aniadirPlato(p1);
		c1.aniadirPlatoRandom("Asado", 3);
		c1.aniadirPlatoRandom("Cocido", 4);
		
		c1.verMapa(1000);
		System.out.println();
		c1.verMapa(120);
		System.out.println();
		
		c1.eliminarCalorias(60);
		c1.verMapa(120);
		
		
	}
}
