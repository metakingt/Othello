package negocio;

public class Fichas {

	public enum color{
		BLANCO, NEGRO, POSMOV
	}
	
	private int ubicacioni;
	private int ubicacionj;
	private color color;

	public color getColor() {
		return color;
	}
	public void setColor(color color) {
		this.color = color;
	}
	public int getUbicacioni() {
		return ubicacioni;
	}
	public void setUbicacioni(int ubicacioni) {
		this.ubicacioni = ubicacioni;
	}
	public int getUbicacionj() {
		return ubicacionj;
	}
	public void setUbicacionj(int ubicacionj) {
		this.ubicacionj = ubicacionj;
	}

	public Fichas(color color, int ubicacioni, int ubicacionj) {
		this.color = color;
		this.ubicacioni = ubicacioni;
		this.ubicacionj = ubicacionj;
	}
}
