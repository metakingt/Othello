package negocio;

public class Tablero {
	private Fichas[][] tablero;

	public  Fichas[][] getTablero() {
		return tablero;
	}

	public void setTablero(Fichas[][] tablero) {
		this.tablero = tablero;
	}

	public Tablero() {
		this.tablero = new Fichas[8][8];
		this.tablero[3][3] = new negocio.Fichas(Fichas.color.NEGRO,3,3);
		this.tablero[3][4] = new negocio.Fichas(Fichas.color.BLANCO,3,3);
		this.tablero[4][3] = new negocio.Fichas(Fichas.color.NEGRO,3,3);
		this.tablero[4][4] = new negocio.Fichas(Fichas.color.BLANCO,3,3);
	}
	
}
