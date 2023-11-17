package negocio;


public class Principal {
	private Tablero tablero;
	
	public Principal() {
		this.tablero = new Tablero();
	}
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.Start();
	}
	public void Start() {
		tablero.print();
		tablero.checkder(3, 3);
		tablero.print();
	}
}
	
        
	

