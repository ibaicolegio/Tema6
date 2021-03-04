package ej2;

public class Punto {

	private int x,y;

	public Punto(int i, int j) {
		this.x = i;
		this.y = j;
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean segundoCuadrante() {
		if(x<0 && y>0) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public float distancia(Punto p2) {
		float distancia;
		distancia=(float) Math.abs(Math.sqrt(Math.pow((p2.x-this.x),2)+Math.pow((p2.y-this.y),2)));
		return distancia;
	}
	
	public boolean cuartoCuadrante() {
		if(x>0 && y<0) {
			return true;
		}
		return false;
	}
	
}
