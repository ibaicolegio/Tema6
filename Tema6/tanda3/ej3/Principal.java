package ej3;

public class Principal {

	public static void main(String[] args) {
		Pelicula p1=new Pelicula("peli1", 100, 1990);
		Pelicula p2=new Pelicula("peli2", 50, 1995);
		Pelicula p3=new Pelicula("peli3", 130, 1993);
		Pelicula p4=new Pelicula("peli4", 123, 1970);
		Pelicula p5=new Pelicula("peli5", 200, 2010);
		Cine c1=new Cine("Florida", 7);
		c1.anyadePeli(p1);
		c1.anyadePeli(p2);
		c1.anyadePeli(p3,4);
		c1.anyadePeli(p4,5);
		c1.anyadePeli(p5,3);
		c1.ver();
	}
	
}
