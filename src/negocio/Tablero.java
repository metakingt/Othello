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
		this.tablero[4][3] = 2;
		this.tablero[4][4] = 1;
	}	
	
	public void checkder(int coorx, int coory, boolean turno) {

		int pulpo = coory; 
		int orca = coory;
		int nautilo = 0;
		//checkeo derecha
		while(pulpo < 8 && nautilo == 0 && coory < 8) {
			System.out.print(this.tablero[coorx][coory] + "\n");
				int i = 0;
				do {
					if(this.tablero [coorx][coory + 1] == 2 && turno || this.tablero [coorx][coory + 1] == 1 && !turno) {
					if(coory + i + 1 < 8) {
					if(this.tablero [coorx][coory + i + 1] == 0) {
						System.out.println("\n movimiento posible");
						if (turno) {
							this.tablero [coorx][coory + i + 1] = -1;
						}else {
							this.tablero [coorx][coory + i + 1] = -2;
						}
						nautilo = 1;
						// poner salto al siguiente checkeo
						coory = pulpo;
						this.checkizq(coorx, coory, turno);
					}else {
					i++;
					}}
					if(this.tablero [coorx][coory + i] == 1 && turno || this.tablero [coorx][coory + i] == 2 && !turno) {
						i++;
					}
					if(coory + i + 1 == 8) {
						System.out.println("\n movimiento no posible");
						// poner salto al siguiente checkeo
						coory = pulpo;
						this.checkizq(coorx, coory, turno);
					}
					}else {
							System.out.println("\n movimiento no posible");
							// poner salto al siguiente checkeo
							coory = pulpo;
							this.checkizq(coorx, coory, turno);
					}
				}while(this.tablero [coorx][coory + i] == 2 && turno || this.tablero [coorx][coory + i] == 1 && !turno);
				pulpo++;
		}
		coory = orca;
		this.checkizq(coorx, coory, turno);
	}
	public void checkizq(int coorx, int coory, boolean turno) {
		int orca = coory;
		int pulpo = coory; 
		int nautilo = 0;
		//checkeo izquierda
		nautilo = 0;
		while(pulpo >= 0 && nautilo == 0 && coory >= 0 ) {
			int i = 0;
			System.out.print(this.tablero[coorx][coory - i ] + "\n");
				do {
					if(this.tablero[coorx][coory - 1] == 2 && turno || this.tablero[coorx][coory - 1] == 1 && !turno) {
					if(coory - i - 1 >= 0) {
					if(this.tablero [coorx][coory - i - 1] == 0) {
						System.out.println("\n movimiento posible");
						if (turno) {
							this.tablero [coorx][coory - i - 1] = -1;
						}else {
							this.tablero [coorx][coory - i - 1] = -2;
						}
						nautilo = 1;
						// poner salto al siguiente checkeo
						coory = pulpo;
						this.checkarr(coorx, coory, turno);
						//this.checkarr(coorx, coory);
					}else {
					i++;
					}}
					if(this.tablero [coorx][coory - i] == 1 && turno || this.tablero [coorx][coory - i] == 2 && !turno) {
						i++;
					}
					if(coory - i - 1 < 0) {
						System.out.println("\n movimiento no posible posible");
						// poner salto al siguiente checkeo
						this.checkarr(coorx, coory, turno);
					}
					}else {
						System.out.println("\n movimiento no posible");
						// poner salto al siguiente checkeo
						this.checkarr(coorx, coory, turno);
				}
				}while(this.tablero [coorx][coory - i] == 2 && turno || this.tablero [coorx][coory - i] == 1 && !turno);
				pulpo--;
		}
		coory = orca;
		this.checkarr(coorx, coory, turno);
	}
	public void checkarr(int coorx, int coory, boolean turno) {
		int orca = coorx;
		int pulpo = coorx; 
		int nautilo = 0;
		//checkeo arriba
		nautilo = 0;
		while(pulpo >= 0 && nautilo == 0 && coorx >= 0 ) {
			int i = 0;
			System.out.print(this.tablero[coorx - i ][coory] + "\n");
				do {
					if(this.tablero[coorx - 1][coory] == 2 && turno || this.tablero[coorx - 1][coory] == 1 && !turno) {
					if(coorx - i - 1 >= 0) {
					if(this.tablero [coorx - i - 1][coory] == 0) {
						System.out.println("\n movimiento posible");
						if (turno) {
							this.tablero [coorx - i - 1][coory] = -1;
						}else {
							this.tablero [coorx - i - 1][coory] = -2;
						}
						nautilo = 1;
						// poner salto al siguiente checkeo
						coorx = pulpo;
						this.checkaba(coorx, coory, turno);
					}else {
					i++;
					}}
					if(this.tablero [coorx - i][coory] == 1 && turno || this.tablero [coorx - i][coory] == 2 && !turno) {
						i++;
					}
					if(coorx - i - 1 < 0) {
						System.out.println("\n movimiento no posible posible");
						// poner salto al siguiente checkeo
						coorx = pulpo;
						this.checkaba(coorx, coory, turno);
					}
					}else {
						System.out.println("\n movimiento no posible posible");
						// poner salto al siguiente checkeo
						coorx = pulpo;
						this.checkaba(coorx, coory, turno);
					}
				}while(this.tablero [coorx - i][coory] == 2 && turno || this.tablero [coorx - i][coory] == 1 && !turno);
				pulpo--;
		}
		coorx = orca;
		this.checkaba(coorx, coory, turno);
	}
	public void checkaba(int coorx, int coory, boolean turno) {
		int pulpo = coorx; 
		int nautilo = 0;
		//checkeo abajo
		nautilo = 0;
		while(pulpo < 8 && nautilo == 0 && coorx < 8 ) {
			int i = 0;
			System.out.print(this.tablero[coorx + i ][coory] + "\n");
				do {
					if(this.tablero[coorx + 1][coory] == 2 && turno || this.tablero[coorx + 1][coory] == 1 && !turno) {
					if(coorx + i + 1 < 8) {
					if(this.tablero [coorx + i + 1][coory] == 0) {
						System.out.println("\n movimiento posible");
						if (turno) {
							this.tablero [coorx + i + 1][coory] = -1;
						}else {
							this.tablero [coorx + i + 1][coory] = -2;
						}
						nautilo = 1;
						// poner salto al siguiente checkeo
						this.checkdsupder(coorx, coory, turno);
					}else {
					i++;
					}}
					if(this.tablero [coorx + i][coory] == 1 && turno || this.tablero [coorx + i][coory] == 2 && !turno) {
						i++;
					}
					if(coorx + i + 1 == 8 ) {
						System.out.println("\n movimiento no posible posible");
						// poner salto al siguiente checkeo
						this.checkdsupder(coorx, coory, turno);
					}
					}else {
						System.out.println("\n movimiento no posible posible");
						// poner salto al siguiente checkeo
						this.checkdsupder(coorx, coory, turno);
					}
				}while(this.tablero [coorx + i][coory] == 2 && turno || this.tablero [coorx + i][coory] == 1 && !turno);
				pulpo++;
		}
		this.checkdsupder(coorx, coory, turno);
	}
	public void checkdsupder(int coorx, int coory, boolean turno) {
		int calamar = coorx;
		int delfin = coorx;
		int pulpo = coory; 
		int orca = coory;
		int nautilo = 0;
		//checkeo deagonal superior derecha
		while(pulpo < 8 && calamar >= 0 && nautilo == 0 && coory < 8 && coorx >= 0) {
			System.out.print(this.tablero[coorx][coory] + "\n");
				int i = 0;
				do {
					if(this.tablero [coorx - 1][coory + 1] == 2 && turno || this.tablero [coorx - 1][coory + 1] == 1 && !turno) {
					if(coory + i + 1 < 8 && coorx - i - 1 >= 0) {
					if(this.tablero [coorx - i - 1][coory + i + 1] == 0) {
						System.out.println("\n movimiento posible");
						if (turno) {
							this.tablero [coorx - i - 1][coory + i + 1] = -1;
						}else {
							this.tablero [coorx - i - 1][coory + i + 1] = -2;
						}
						nautilo = 1;
						// poner salto al siguiente checkeo
						coory = pulpo;
						coorx = calamar;
						this.checkdsupizq(coorx, coory, turno);
					}else {
					i++;
					}}
					if(this.tablero [coorx - i][coory + i] == 1 && turno || this.tablero [coorx - i][coory + i] == 2 && !turno) {
						i++;
					}
					if(coory + i + 1 == 8 && coorx - i - 1 < 0 || coorx - i - 1 < 0 || coory + i + 1 == 8) {
						System.out.println("\n movimiento no posible");
						// poner salto al siguiente checkeo
						coory = pulpo;
						coorx = calamar;
						this.checkdsupizq(coorx, coory, turno);
					}
					}else {
							System.out.println("\n movimiento no posible");
							// poner salto al siguiente checkeo
							coory = pulpo;
							coorx = calamar;
							this.checkdsupizq(coorx, coory, turno);
					}
				}while(this.tablero [coorx - i][coory + i] == 2 && turno || this.tablero [coorx - i][coory + i] == 1 && !turno);
				pulpo++;
				calamar--;
		}
		coory = orca;
		coory = delfin;
		this.checkdsupizq(coorx, coory, turno);
	}
	public void checkdsupizq(int coorx, int coory, boolean turno) {
		int calamar = coorx;
		int delfin = coorx;
		int pulpo = coory; 
		int orca = coory;
		//checkeo deagonal superior izquierda
		while(pulpo >= 0 && calamar >= 0 || coory >= 0 && coorx >= 0) {
			System.out.print(this.tablero[coorx][coory] + "\n");
				int i = 0;
				do {
					if(this.tablero [coorx - 1][coory - 1] == 2 && turno || this.tablero [coorx - 1][coory - 1] == 1 && !turno) {
					if(coory - i - 1 >= 0 && coorx - i - 1 >= 0) {
					if(this.tablero [coorx - i - 1][coory - i - 1] == 0) {
						System.out.println("\n movimiento posible");
						if (turno) {
							this.tablero [coorx - i - 1][coory - i - 1] = -1;
						}else {
							this.tablero [coorx - i - 1][coory - i - 1] = -2;
						}
						// poner salto al siguiente checkeo
						coory = pulpo;
						coorx = calamar;
						this.checkdinfizq(coorx, coory, turno);
					}else {
					i++;
					}}
					if(this.tablero [coorx - i][coory - i] == 1 && turno || this.tablero [coorx - i][coory - i] == 2 && !turno) {
						i++;
					}
					if(coory - i - 1 < 0 && coorx - i - 1 < 0 || coorx - i - 1 < 0 || coory - i - 1 < 0) {
						System.out.println("\n movimiento no posible");
						// poner salto al siguiente checkeo
						coory = pulpo;
						coorx = calamar;
						this.checkdinfizq(coorx, coory, turno);
					}
					}else {
							System.out.println("\n movimiento no posible");
							// poner salto al siguiente checkeo
							coory = pulpo;
							coorx = calamar;
							this.checkdinfizq(coorx, coory, turno);
					}
				}while(this.tablero [coorx - i][coory - i] == 2 && turno || this.tablero [coorx - i][coory - i] == 1 && !turno);
				pulpo--;
				calamar--;
		}
		coory = orca;
		coory = delfin;
		this.checkdinfizq(coorx, coory, turno);
	}
	public void checkdinfizq(int coorx, int coory, boolean turno) {
		int calamar = coorx;
		int delfin = coorx;
		int pulpo = coory; 
		int orca = coory;
		//checkeo deagonal inferior izquierda
		while(pulpo >= 0 && calamar < 8 || coory >= 0 && coorx < 8) {
			System.out.print(this.tablero[coorx][coory] + "\n");
				int i = 0;
				do {
					if(this.tablero [coorx + 1][coory - 1] == 2 && turno || this.tablero [coorx + 1][coory - 1] == 1 && !turno) {
					if(coory - i - 1 >= 0 && coorx + i + 1 < 8) {
					if(this.tablero [coorx + i + 1][coory - i - 1] == 0) {
						System.out.println("\n movimiento posible");
						if (turno) {
							this.tablero [coorx + i + 1][coory - i - 1] = -1;
						}else {
							this.tablero [coorx + i + 1][coory - i - 1] = -2;
						}
						// poner salto al siguiente checkeo
						coory = pulpo;
						coorx = calamar;
						this.checkdinfder(coorx, coory, turno);
					}else {
					i++;
					}}
					if(this.tablero [coorx + i][coory - i] == 1 && turno || this.tablero [coorx + i][coory - i] == 2 && !turno) {
						i++;
					}
					if(coory - i - 1 < 0 && coorx + i + 1 == 8 || coorx + i + 1 == 8 || coory - i - 1 < 0) {
						System.out.println("\n movimiento no posible");
						// poner salto al siguiente checkeo
						coory = pulpo;
						coorx = calamar;
						this.checkdinfder(coorx, coory, turno);
					}
					}else {
							System.out.println("\n movimiento no posible");
							// poner salto al siguiente checkeo
							coory = pulpo;
							coorx = calamar;
							this.checkdinfder(coorx, coory, turno);
					}
				}while(this.tablero [coorx + i][coory - i] == 2 && turno || this.tablero [coorx + i][coory - i] == 1 && !turno);
				pulpo--;
				calamar++;
		}
		coory = orca;
		coory = delfin;
		this.checkdinfder(coorx, coory, turno);
	}
	public void checkdinfder(int coorx, int coory, boolean turno) {
		int calamar = coorx;
		int delfin = coorx;
		int pulpo = coory; 
		int orca = coory;
		int nautilo = 0;
		//checkeo deagonal superior izquierda
		while(pulpo < 8 && calamar < 8 && nautilo == 0 && coory < 8 && coorx < 8) {
			System.out.print(this.tablero[coorx][coory] + "\n");
				int i = 0;
				do {
					if(this.tablero [coorx + 1][coory + 1] == 2 && turno || this.tablero [coorx + 1][coory + 1] == 1 && !turno) {
					if(coory + i + 1 < 8 && coorx + i + 1 < 8) {
					if(this.tablero [coorx + i + 1][coory + i + 1] == 0) {
						System.out.println("\n movimiento posible");
						if (turno){
							this.tablero [coorx + i + 1][coory + i + 1] = -1;
						}else {
							this.tablero [coorx + i + 1][coory + i + 1] = -2;
						}
						nautilo = 1;
						// poner salto al siguiente checkeo
						coory = pulpo;
						coorx = calamar;
						this.print();
						System.exit(0);
					}else {
					i++;
					}}
					if(this.tablero [coorx + i][coory + i] == 1 && turno || this.tablero [coorx + i][coory + i] == 2 && !turno) {
						i++;
					}
					if(coory + i + 1 == 8 && coorx + i + 1 == 8 || coorx + i + 1 == 8 || coory + i + 1 == 8) {
						System.out.println("\n movimiento no posible");
						// poner salto al siguiente checkeo
						coory = pulpo;
						coorx = calamar;
						this.print();
						System.exit(0);
					}
					}else {
							System.out.println("\n movimiento no posible");
							// poner salto al siguiente checkeo
							coory = pulpo;
							coorx = calamar;
							this.print();
							System.exit(0);
					}
				}while(this.tablero [coorx + i][coory + i] == 2 && turno || this.tablero [coorx + i][coory + i] == 1 && !turno);
				pulpo++;
				calamar++;
		}
		coory = orca;
		coory = delfin;
		this.print();
		System.exit(0);
	}
	public void limpiarmatriz() {
		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j < this.tablero[i].length; j++) {
				if (this.tablero[i][j] == -1 || this.tablero[i][j] == -2) {
					this.tablero[i][j] = 0;
				}
			}
		}
	}
	public void print() {
		for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[i].length; j++) {
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println();
        }       
	}
	public boolean cambioturno(boolean turno) {
		if(turno) {
			turno = false;
		}else {
			turno = true;
		}
		return turno;
	}
}