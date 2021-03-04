package t6t1e11;

public class Punto {

	private double x,y;

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
	
	public double distanciaOrigen() {
		double distancia=Math.sqrt((x*x)+(y*y));
		return distancia;
	}
	
	public double calcularDistancia(Punto punto) {
		double distancia=Math.sqrt((this.x-punto.x)*(this.x-punto.x)+(this.y-punto.y)*(this.y-punto.y));
		return Math.abs(distancia);
	}
	
	public int calcularCuadrante() {
		if (x>0 && y>0) {
			return 1;
		}
		if (x<0 && y>0) {
			return 2;
		}
		if (x<0 && y<0) {
			return 3;
		}
		if (x>0 && y<0) {
			return 4;
		}
		return 0;
	}
	
	public Punto calcularMasCercano(Punto[] p1) {
		double min=Double.MAX_VALUE;
		int cercano=-1;
		if (p1==null)
			return null;
		for (int i = 0; i < p1.length; i++) {
			if (this.calcularDistancia(p1[i])<min) {
				cercano=i;
				min=this.calcularDistancia(p1[i]);
			}
		}
		return p1[cercano];
	}

	public double getY() {
		return y;
	}
	
	
}
