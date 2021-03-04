package t6t1e11;

public class PruebaPunto {

	public static void main(String[] args) {
		Punto p1;
		
		double x, y;
		
		if ((args.length<2) || (args[0]==null && args[1]==null)) {
			System.out.println("Error");
			return ;
		}
		x=Double.parseDouble(args[0]);
		y=Double.parseDouble(args[1]);
		
		p1=new Punto(x,y);
		
		System.out.println(p1);
		
		System.out.println("Distancia Origen");
		System.out.println(p1.distanciaOrigen());
		
		System.out.println("Y");
		System.out.println(p1.getY());
		
		System.out.println("Cuadrante");
		System.out.println(p1.calcularCuadrante());
		
		Punto[] a=new Punto[]{new Punto(1, 1), new Punto(5, 3), new Punto(10, 10),
			new Punto(-3, 2), new Punto(-4, -5)};
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.println("Distancia de p1 a a["+i+"]");
			System.out.println(p1.calcularDistancia(a[i]));
		}
		System.out.println();
		System.out.println(p1.calcularMasCercano(a));
		
		
		
	}
}
