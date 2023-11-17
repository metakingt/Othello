package negocio;

public class Tablero {
	private int[][] tablero;

	public  int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}

	public Tablero() {
		this.tablero = new int[8][8];
		this.tablero[3][3] = 1;
		this.tablero[3][4] = 2;
		this.tablero[3][5] = 1;
		this.tablero[4][3] = 2;
		this.tablero[5][3] = 1;
		this.tablero[4][4] = 1;
	}	
	
	public void checkder(int coorx, int coory) {

		int pulpo = coory; 
		int orca = coory;
		int nautilo = 0;
		//checkeo derecha
		while(pulpo < 8 && nautilo == 0 && coory < 8) {
			System.out.print(this.tablero[coorx][coory] + "\n");
				int i = 0;
				do {
					if(this.tablero [coorx][coory + 1] == 2) {
					if(coory + i + 1 < 8) {
					if(this.tablero [coorx][coory + i + 1] == 0) {
						System.out.println("\n movimiento posible");
						this.tablero [coorx][coory + i + 1] = -1;
						nautilo = 1;
						// poner salto al siguiente checkeo
						coory = pulpo;
						this.checkizq(coorx, coory);
					}else {
					i++;
					}}
					if(this.tablero [coorx][coory + i] == 1) {
						i++;
					}
					if(coory + i + 1 == 8) {
						System.out.println("\n movimiento no posible");
						// poner salto al siguiente checkeo
						coory = pulpo;
						this.checkizq(coorx, coory);
					}
					}else {
							System.out.println("\n movimiento no posible");
							// poner salto al siguiente checkeo
							coory = pulpo;
							this.checkizq(coorx, coory);
					}
				}while(this.tablero [coorx][coory + i] == 2);
				pulpo++;
		}
		coory = orca;
		this.checkizq(coorx, coory);
	}
	public void checkizq(int coorx, int coory) {
		int orca = coory;
		int pulpo = coory; 
		int nautilo = 0;
		//checkeo izquierda
		nautilo = 0;
		while(pulpo >= 0 && nautilo == 0 && coory >= 0 ) {
			int i = 0;
			System.out.print(this.tablero[coorx][coory - i ] + "\n");
				do {
					if(this.tablero[coorx][coory - 1] == 2) {
					if(coory - i - 1 >= 0) {
					if(this.tablero [coorx][coory - i - 1] == 0) {
						System.out.println("\n movimiento posible");
						this.tablero [coorx][coory - i - 1] = -1;
						nautilo = 1;
						// poner salto al siguiente checkeo
						coory = pulpo;
						this.checkarr(coorx, coory);
						//this.checkarr(coorx, coory);
					}else {
					i++;
					}}
					if(this.tablero [coorx][coory - i] == 1) {
						i++;
					}
					if(coory - i - 1 < 0) {
						System.out.println("\n movimiento no posible posible");
						// poner salto al siguiente checkeo
						this.checkarr(coorx, coory);
					}
					}else {
						System.out.println("\n movimiento no posible");
						// poner salto al siguiente checkeo
						this.checkarr(coorx, coory);
				}
				}while(this.tablero [coorx][coory - i] == 2);
				pulpo--;
		}
		coory = orca;
		this.checkarr(coorx, coory);
	}
	public void checkarr(int coorx, int coory) {
		int orca = coorx;
		int pulpo = coorx; 
		int nautilo = 0;
		//checkeo arriba
		nautilo = 0;
		while(pulpo >= 0 && nautilo == 0 && coorx >= 0 ) {
			int i = 0;
			System.out.print(this.tablero[coorx - i ][coory] + "\n");
				do {
					if(this.tablero[coorx - 1][coory] == 2) {
					if(coorx - i - 1 >= 0) {
					if(this.tablero [coorx - i - 1][coory] == 0) {
						System.out.println("\n movimiento posible");
						this.tablero [coorx - i - 1][coory] = -1;
						nautilo = 1;
						// poner salto al siguiente checkeo
						coorx = pulpo;
						this.checkaba(coorx, coory);
					}else {
					i++;
					}}
					if(this.tablero [coorx - i][coory] == 1) {
						i++;
					}
					if(coorx - i - 1 < 0) {
						System.out.println("\n movimiento no posible posible");
						// poner salto al siguiente checkeo
						coorx = pulpo;
						this.checkaba(coorx, coory);
					}
					}else {
						System.out.println("\n movimiento no posible posible");
						// poner salto al siguiente checkeo
						coorx = pulpo;
						this.checkaba(coorx, coory);
					}
				}while(this.tablero [coorx - i][coory] == 2);
				pulpo--;
		}
		coorx = orca;
		this.checkaba(coorx, coory);
	}
	public void checkaba(int coorx, int coory) {
		int pulpo = coorx; 
		int nautilo = 0;
		//checkeo abajo
		nautilo = 0;
		while(pulpo < 8 && nautilo == 0 && coorx < 8 ) {
			int i = 0;
			System.out.print(this.tablero[coorx + i ][coory] + "\n");
				do {
					if(this.tablero[coorx + 1][coory] == 2) {
					if(coorx + i + 1 < 8) {
					if(this.tablero [coorx + i + 1][coory] == 0) {
						System.out.println("\n movimiento posible");
						this.tablero [coorx + i + 1][coory] = -1;
						nautilo = 1;
						// poner salto al siguiente checkeo
						System.exit(0);
					}else {
					i++;
					}}
					if(this.tablero [coorx + i][coory] == 1) {
						i++;
					}
					if(coorx + i + 1 == 8 ) {
						System.out.println("\n movimiento no posible posible");
						// poner salto al siguiente checkeo
						System.exit(0);
					}
					}else {
						System.out.println("\n movimiento no posible posible");
						// poner salto al siguiente checkeo
						System.exit(0);
					}
				}while(this.tablero [coorx + i][coory] == 2);
				pulpo++;
		}
		System.exit(0);
	}
	public void print() {
		for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[i].length; j++) {
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println();
        }       
	}
}