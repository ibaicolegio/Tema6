package t6t1e10;

public class Directorio {

	private String nombre;
	private long tamanio;
	
	private final static int MAXCAR=40;

	public Directorio(String nombre, long tamanio) {
		this.nombre = nombre;
		this.tamanio = tamanio;
	}
	
	public void ver() {
		System.out.println("Directorio=" + nombre + ", tamaño=" + tamanio);
	}
	
	public int niveles() {
		int cantidad=1;
		for (int i = 0; i < nombre.length(); i++) {
			if(nombre.charAt(i)=='/') {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public String ultimo() {
		String aux="";
		for (int i = nombre.length(); i > 0; i--) {
			if(nombre.charAt(i-1)!='/') {
				aux=nombre.charAt(i-1)+aux;
			}
			else {
				return aux;
			}
		}
		return "Directorio mal introducido";
	}
	
	private boolean carIlegales() {
		for (int i = 0; i < nombre.length(); i++) {
			if (nombre.charAt(i)=='*' || nombre.charAt(i)=='#' || nombre.charAt(i)=='@') {
				return true;
			}
		}
		return false;
	}
	
	public String dirValido() {
		if (nombre.length()>=MAXCAR) {
			return "Contiene mas de 40 caracteres";
		}
		if (carIlegales()==true) {
			return "Contiene caracteres ilegales";
		}
		if ((nombre.charAt(0)>='a' && nombre.charAt(0)<='z') || (nombre.charAt(0)>='A' && nombre.charAt(0)<='Z') && nombre.charAt(1)==':') {
			for (int i = 0; i < nombre.length()-1; i++) {
				if(nombre.charAt(i)=='/' && nombre.charAt(i+1)=='/') {
					return "Contiene dos '//' seguidos";
				}
				
			}
			return "ok";
		}
		return "Unidad de disco incorrecta";
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void compactarDir() {
		String copiaNombre=nombre;
		String aux="";
		for (int i = 0; i < copiaNombre.length(); i++) {
			if (copiaNombre.charAt(i)=='/') {
				aux=aux+copiaNombre.charAt(i);
				while(copiaNombre.charAt(i+1)==' ') {
					i++;
				}
			}
			else {
				aux=aux+copiaNombre.charAt(i);
			}
			
		}
		copiaNombre=aux;
		aux="";
		for (int i = copiaNombre.length()-1; i >= 0; i--) {
			if (copiaNombre.charAt(i)=='/') {
				aux=copiaNombre.charAt(i)+aux;
				while(copiaNombre.charAt(i-1)==' ') {
					i--;
				}
			} else {
				aux=copiaNombre.charAt(i)+aux;
			}
			
		}
		nombre=aux.toLowerCase();
	}

	public long getTamanio() {
		return tamanio;
	}

	public void setTamanio(long tamanio) {
		this.tamanio = tamanio;
	}
	
	public void descompuesto() {
		long mb=(long) (getTamanio()/1048576);
		long kb=(long) ((getTamanio()-(mb*1048576))/1024);
		long bytes= getTamanio()-((mb*1048576)+(kb*1024));
		System.out.println(getTamanio() + " bytes se descompone en " + mb 
				+ " Mb, " + kb + " Kb y " + bytes + " bytes");
	}
	
}
