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
        this.tablero[3][5] = 0;
        this.tablero[3][6] = 2;
        this.tablero[3][7] = 2;
		this.tablero[4][3] = 2;
		this.tablero[4][4] = 1;
	}	
	
	public void checkmove(int coorx, int coory) {
		
		int orca = 0;
		int calamar = coorx;
		int pulpo = coory; 
		int nautilo = 0;
		if(coory == 0) {
			orca = 2;
		}else {
			if (coory == 7) {
				orca = 1;
			}
		}
		//checkeo derecha
		while(pulpo < 8 && nautilo == 0) {
			System.out.print(this.tablero[coorx][coory] + "\n");
				int i = 0;
				do {
					if(this.tablero [coorx][coory + i + 1] == 0) {
						System.out.println("\n movimiento posible");
						this.tablero [coorx][coory + i + 1] = -1;
						nautilo = 1;
						return;
					}else {
					i++;
					}
					if(this.tablero [coorx][coory + i] == 1) {
						i++;
					}
				}while(this.tablero [coorx][coory + i] == 2);
				pulpo++;
		}
		//checkeo izquierda
		
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