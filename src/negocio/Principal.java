	public static boolean checkWinConditions(int[][] tablero, boolean turno) {
	    // 1. Verifica si hay un jugador con 64 piezas.
	    if (contarfichas(tablero, 2) == 64 || contarfichas(tablero, 1) == 64) {
	        return true;
	    }
	    // 2. Verifica si no hay movimientos posibles para ningún jugador.
	    if(posibmov(tablero, turno)) {
	    	return false;
	    }
	    return false;
	}
	private static boolean posibmov(int[][] tablero, boolean turno) {
		if (turno) {
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					if (tablero[i][j] == -1) {
						return true;
					}
				}
			}
		}else {
			for (int i = 0; i < tablero.length; i++) {
				for (int j = 0; j < tablero[i].length; j++) {
					if (tablero[i][j] == -2) {
						return true;
					}
				}
			}
		}
		return false;
	}
	private static int contarfichas(int[][] tablero, int color) {
	    int cuenta = 0;
	    for (int i = 0; i < 8; i++) {
	        for (int j = 0; j < 8; j++) {
	            if (tablero[i][j] == color) {
	                cuenta++;
	            }
	        }
	    }
	    return cuenta;
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
	public boolean cambioturno(boolean turno) {
		if(turno) {
			turno = false;
		}else {
			turno = true;
		}
		return turno;
	}
	

	
	
        
	

