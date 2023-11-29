package presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OthelloGUI extends JFrame {

    private JButton[][] buttons;
    private boolean turnoNegras;

    public OthelloGUI() {
        super("Othello");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(8, 8));

        buttons = new JButton[8][8];
        turnoNegras = true; // Empiezan las negras

        // Inicializar el tablero
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].setBackground(Color.GREEN);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }

        // Configurar las primeras fichas
        buttons[3][3].setText("●");
        buttons[3][3].setForeground(Color.BLACK);
        buttons[3][4].setText("●");
        buttons[3][4].setForeground(Color.WHITE);
        buttons[4][3].setText("●");
        buttons[4][3].setForeground(Color.WHITE);
        buttons[4][4].setText("●");
        buttons[4][4].setForeground(Color.BLACK);
    }

    private class ButtonClickListener implements ActionListener {
        private int x, y;

        public ButtonClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[x][y].getText().isEmpty()) {
                if (turnoNegras) {
                    buttons[x][y].setText("●");
                    buttons[x][y].setForeground(Color.BLACK);
                } else {
                    buttons[x][y].setText("●");
                    buttons[x][y].setForeground(Color.WHITE);
                }
                turnoNegras = !turnoNegras;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OthelloGUI othelloGUI = new OthelloGUI();
            othelloGUI.setVisible(true);
        });
    }
}