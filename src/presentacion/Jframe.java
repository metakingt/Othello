package presentacion;

import javax.swing.*;
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

        int filas = 8;
        int columnas = 8;

        JButton[][] botones = new JButton[filas][columnas];

        // Crear y configurar los botones en el tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setPreferredSize(new Dimension(50, 50)); // Establecer tamaño
                frame.getContentPane().add(botones[i][j]);

                // Configurar el ActionListener para cada botón
                final int filaActual = i;
                final int columnaActual = j;
                botones[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Aquí puedes manejar la lógica del juego cuando se presiona un botón
                        System.out.println("Botón presionado en la fila " + filaActual + " y columna " + columnaActual);
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
