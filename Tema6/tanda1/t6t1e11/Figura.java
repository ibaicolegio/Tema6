package t6t1e11;

public abstract class Figura {

	private String nombre;

	public Figura(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract double calcularArea();
	 
	public abstract boolean esRegular();
}
