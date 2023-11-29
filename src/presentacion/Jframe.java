package presentacion;

import javax.swing.*;

import negocio.Ficha;
import negocio.Tablero;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jframe {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearYMostrarGUI();
            }
        });
    }

    private static void crearYMostrarGUI() {
        JFrame frame = new JFrame("Tablero de Othello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Tablero tablero = new Tablero(); 
        Ficha[][] matriz = tablero.getTablero(); 
        int filas = matriz.length;
        int columnas = matriz[0].length;
        JButton[][] botones = new JButton[filas][columnas];
        boolean turno = true;

        // Crear y configurar los botones en el tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setPreferredSize(new Dimension(50, 50)); // Establecer tamaño
                frame.getContentPane().add(botones[i][j]);
                //colocar imagenes
                if(matriz[i][j].getValor() == 1) {
                	 botones[i][j].setIcon(new ImageIcon("img/Negro.jpg"));
                }
                if(matriz[i][j].getValor() == 2) {
               	 botones[i][j].setIcon(new ImageIcon("img/Blanco.jpg"));
               }
                if(matriz[i][j].getValor() == 0) {
               	 botones[i][j].setIcon(new ImageIcon("img/Vacio.jpg"));
               }
                if(matriz[i][j].getValor() == -1 || matriz[i][j].getValor() == -2) {
               	 botones[i][j].setIcon(new ImageIcon("img/Posible.jpg"));
               }
                // Configurar el ActionListener para cada botón
                final int filaActual = i;
                final int columnaActual = j;
                botones[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    		if(matriz[filaActual][columnaActual].getValor() == -1 || matriz[filaActual][columnaActual].getValor() == -2) {
                    			System.out.println("Botón negativo presionado en la fila " + filaActual + " y columna " + columnaActual);
                    			tablero.encontrarcamino(matriz, filaActual, columnaActual, turno);
                    			this.actualizarIconos(matriz);
                    		}else {
                    			System.out.println("Botón presionado en la fila " + filaActual + " y columna " + columnaActual);
                    		}
                    }

					private void actualizarIconos(Ficha[][] matriz) {
						for (int i = 0; i < 8; i++) {
				            for (int j = 0; j < 8; j++) {
		                if(matriz[i][j].getValor() == 1) {
		                	 botones[i][j].setIcon(new ImageIcon("img/Negro.jpg"));
		                }
		                if(matriz[i][j].getValor() == 2) {
		               	 botones[i][j].setIcon(new ImageIcon("img/Blanco.jpg"));
		               }
		                if(matriz[i][j].getValor() == 0) {
		               	 botones[i][j].setIcon(new ImageIcon("img/Vacio.jpg"));
		               }
		                if(matriz[i][j].getValor() == -1 || matriz[i][j].getValor() == -2) {
		               	 botones[i][j].setIcon(new ImageIcon("img/Posible.jpg"));
		                		}
				            }
						}
					}
                });
            }
        }
        

        frame.setLayout(new GridLayout(filas, columnas));
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
