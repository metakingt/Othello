package negocio;

public class Tablero {
	private Ficha[][] tablero;

    public Tablero() {
        tablero = new Ficha[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = new Ficha();
            }
        }
        tablero[3][3].setValor(1); // Ficha negra
        tablero[4][4].setValor(1);
        tablero[3][4].setValor(2); // Ficha blanca
        tablero[4][3].setValor(2);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	this.checkAllDirections(i, j, true);
            }
        }
    }
    

    public Ficha[][] getTablero() {
		return tablero;
	}
    public boolean checkDireccion(int coorx, int coory, boolean turno, int incrFila, int incrColumna) {
	    int fila = coorx + incrFila;
	    int columna = coory + incrColumna;

	    while (fila >= 0 && fila < 8 && columna >= 0 && columna < 8) {
	        if (this.tablero[fila][columna].getValor() == 2 && turno || this.tablero[fila][columna].getValor() == 1 && !turno) {
	            if (fila + incrFila >= 0 && fila + incrFila < 8 && columna + incrColumna >= 0 && columna + incrColumna < 8) {
	                if (this.tablero[fila + incrFila][columna + incrColumna].getValor() == 0) {
	                    if (turno) {
	                        this.tablero[fila + incrFila][columna + incrColumna].setValor(-1);
	                    } else {
	                        this.tablero[fila + incrFila][columna + incrColumna].setValor(-2);
	                    }
	                    return true;
	                }
	            }
	        } else {
	        	return false;
	        }
	        fila += incrFila;
	        columna += incrColumna;
	    }
		return false;
	}
    public void encontrarcamino(Ficha[][] matriz, int Destinof, int Destinoc, boolean turno ) {
    	for (int i = 0; i < 8; i++) {
    		for (int j = 0; j < 8; j++) {
    			if(matriz[i][j].getValor() == 1 && turno || matriz[i][j].getValor() == 2 && !turno) {
    				marcarCamino(matriz,i,j,Destinof,Destinoc,turno);
    			}
    		}
    	}
    }
    public void marcarCamino(Ficha[][] matriz, int fila, int columna, int Destinof, int Destinoc, boolean turno) {
        if(marcarDireccion(matriz, fila, columna, turno, 0, 1)) {
        	if(matriz[Destinof][Destinoc].getValor() == 1) {
        		return;
        	}
        	// derecha
        }
        if(marcarDireccion(matriz, fila, columna, turno, 0, -1)) {
        	if(matriz[Destinof][Destinoc].getValor() == 1) {
        		return;
        	}
        	// izquierda
        }
        if(marcarDireccion(matriz, fila, columna, turno, -1, 0)) {
        	if(matriz[Destinof][Destinoc].getValor() == 1) {
        		return;
        	}
        	// arriba
        }
        if(marcarDireccion(matriz, fila, columna, turno, 1, 0)) {
        	if(matriz[Destinof][Destinoc].getValor() == 1) {
        		return;
        	}
        	// abajo
        }
        if(marcarDireccion(matriz, fila, columna, turno, -1, 1)) {
        	if(matriz[Destinof][Destinoc].getValor() == 1) {
        		return;
        	}
        	// diagonal superior derecha
        }
        if(marcarDireccion(matriz, fila, columna, turno, -1, -1)) {
        	if(matriz[Destinof][Destinoc].getValor() == 1) {
        		return;
        	}
        	// diagonal superior izquierda
        }
        if(marcarDireccion(matriz, fila, columna, turno, 1, 1)) {
        	if(matriz[Destinof][Destinoc].getValor() == 1) {
        		return;
        	}
        	// diagonal inferior derecha
        }
        if(marcarDireccion(matriz, fila, columna, turno, 1, -1)) {
        	if(matriz[Destinof][Destinoc].getValor() == 1) {
        		return;
        	}
        	// diagonal inferior izquierda
        }
    }

    private boolean marcarDireccion(Ficha[][] matriz, int fila, int columna, boolean turno, int desplazamientoF, int desplazamientoC) {
        int[] valores = checkCamino(matriz, fila, columna, turno, desplazamientoF, desplazamientoC);
        int desplazamientof = valores[0];
        int desplazamientoc = valores[1];
        if(desplazamientof != 0 && desplazamientoc != 0 || desplazamientof != 0 || desplazamientoc != 0) {
        	for (int i = 0; i < desplazamientof; i++) {
            matriz[fila + i ][columna].setValor(1);
        	}
        	for (int i = 0; i < desplazamientoc; i++) {
            matriz[fila][columna + i].setValor(1);
        	}
        	return true;
        }else {
        	return false;
        }
    }
    public int[] checkCamino(Ficha[][] matriz, int coorx, int coory, boolean turno, int incrFila, int incrColumna) {
    	int fila = coorx + incrFila;
	    int columna = coory + incrColumna;
	    int corg = incrColumna;
	    int forg = incrFila;

	    while (fila >= 0 && fila < 8 && columna >= 0 && columna < 8) {
	        if (matriz[fila][columna].getValor() == 2 && turno || matriz[fila][columna].getValor() == 1 && !turno) {
	            if (fila + incrFila >= 0 && fila + incrFila < 8 && columna + incrColumna >= 0 && columna + incrColumna < 8) {
	                if (matriz[fila + incrFila][columna + incrColumna].getValor() == -1 && turno || matriz[fila + incrFila][columna + incrColumna].getValor() == -2 && !turno) {
	                    int desplazamientof = fila + incrFila - forg;
	                    int desplazamientoc = columna + incrColumna;
	                    int[] valores = new int[2];
	                    valores[0] = desplazamientof;
	                    valores[1] = desplazamientoc;
	                    return valores;
	                }
	            }
	        } else {
	        	int[] valores = new int[2];
                return valores;
	        }
	        fila += incrFila;
	        columna += incrColumna;
	    }
	    int[] valores = new int[2];
        return valores;
    }
    public boolean checkAllDirections(int coorx, int coory, boolean turno) {
    	boolean posible = false;
	    if(checkDireccion(coorx, coory, turno, 0, 1)) {
	    	posible = true;
	    	// Derecha
	    }
	    if(checkDireccion(coorx, coory, turno, 0, -1)) {
	    	posible = true;
	    	// Izquierda
	    }
	    if(checkDireccion(coorx, coory, turno, -1, 0)) {
	    	posible = true;
	    	// Arriba
	    }
	    if(checkDireccion(coorx, coory, turno, 1, 0)) {
	    	posible = true;
	    	// Abajo
	    }
	    if(checkDireccion(coorx, coory, turno, -1, 1)) {
	    	posible = true;
	    	// Diagonal superior derecha
	    }  
	    if(checkDireccion(coorx, coory, turno, -1, -1)) {
	    	posible = true;
	    	// Diagonal superior izquierda
	    }
	    if(checkDireccion(coorx, coory, turno, 1, 1)) {
	    	posible = true;
	    	// Diagonal inferior derecha
	    }
	    if(checkDireccion(coorx, coory, turno, 1, -1)) {
	    	posible = true;
	    	// Diagonal inferior izquierda
	    }
	    if(posible) {
	    	return posible;
	    }else {
	    	return posible;
	    }
	}
}