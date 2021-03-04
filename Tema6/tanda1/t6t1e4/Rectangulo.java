package t6t1e4;

public class Rectangulo {

	private int lado1, lado2;

	public Rectangulo(int lado1, int lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	public Rectangulo() {
		lado1 = (int)(2+(Math.random()*89));
		lado2 = (int)(2+(Math.random()*89));
	}
	
	public int getLado1() {
		return lado1;
	}

	public int getLado2() {
		return lado2;
	}

	public int area() {
		int area=lado1*lado2;
		return area;
	}

	public String toString() {
		return "Rectangulo [lado1=" + lado1 + ", lado2=" + lado2 + "]";
	}
	
	public static void main(String[] args) {
		Rectangulo r1 = new Rectangulo();
		
		System.out.println("Area="+r1.area());
		
		System.out.println(r1);
	}
	
}
