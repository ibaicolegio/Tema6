package t6t1e11;

public class Triangulo extends Figura{

	private Punto v1,v2,v3;

	public Triangulo(String nombre, Punto v1, Punto v2, Punto v3) {
		super(nombre);
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	public double[] calcularLongitudLados() {
		double p1,p2,p3;
		double longitud[];
		p1=v1.calcularDistancia(v2);
		p2=v2.calcularDistancia(v3);
		p3=v3.calcularDistancia(v1);
		/*
		longitud=new longitud[]{p1,p2,p3};
		return longitud;
	}

	public double calcularArea() {
		
		return area;
	}

	public boolean esRegular() {
		return false;
	}
	*/
	

	
}
