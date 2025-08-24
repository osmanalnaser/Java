package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] grid = new JButton[3][3];
    private boolean isXTurn = true;
    private int moveCount = 0;
    private JLabel statusLabel;

    public TicTacToe() {
        super("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLayout(new BorderLayout());


        statusLabel = new JLabel("Spieler X ist am Zug");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(statusLabel, BorderLayout.NORTH);

        // Spielfeld
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        initializeGrid(panel);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void initializeGrid(JPanel panel) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = new JButton("");
                grid[row][col].setFont(new Font("Arial", Font.BOLD, 60));
                grid[row][col].setFocusPainted(false);
                grid[row][col].addActionListener(this);
                panel.add(grid[row][col]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton clickedButton = (JButton) event.getSource();

        if (!clickedButton.getText().equals("")) return;

        clickedButton.setText(isXTurn ? "X" : "O");
        moveCount++;

        if (checkWin()) {
            highlightWinningLine();
            int response = JOptionPane.showConfirmDialog(this, "Spieler " + (isXTurn ? "X" : "O") + " hat gewonnen! Neues Spiel?", "Spiel beendet", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) resetGame();
            else System.exit(0);
        } else if (moveCount == 9) {
            int response = JOptionPane.showConfirmDialog(this, "Unentschieden! Neues Spiel?", "Spiel beendet", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) resetGame();
            else System.exit(0);
        } else {
            isXTurn = !isXTurn;
            statusLabel.setText("Spieler " + (isXTurn ? "X" : "O") + " ist am Zug");
        }
    }

    private boolean checkWin() {
        String player = isXTurn ? "X" : "O";

        // Reihen
        for (int row = 0; row < 3; row++)
            if (grid[row][0].getText().equals(player) &&
                    grid[row][1].getText().equals(player) &&
                    grid[row][2].getText().equals(player)) return true;

        // Spalten
        for (int col = 0; col < 3; col++)
            if (grid[0][col].getText().equals(player) &&
                    grid[1][col].getText().equals(player) &&
                    grid[2][col].getText().equals(player)) return true;

        // Diagonalen
        if (grid[0][0].getText().equals(player) &&
                grid[1][1].getText().equals(player) &&
                grid[2][2].getText().equals(player)) return true;

        if (grid[0][2].getText().equals(player) &&
                grid[1][1].getText().equals(player) &&
                grid[2][0].getText().equals(player)) return true;

        return false;
    }

    private void highlightWinningLine() {
        String player = isXTurn ? "X" : "O";

        // Reihen
        for (int row = 0; row < 3; row++)
            if (grid[row][0].getText().equals(player) &&
                    grid[row][1].getText().equals(player) &&
                    grid[row][2].getText().equals(player)) {
                for (int col = 0; col < 3; col++) grid[row][col].setBackground(Color.GREEN);
            }

        // Spalten
        for (int col = 0; col < 3; col++)
            if (grid[0][col].getText().equals(player) &&
                    grid[1][col].getText().equals(player) &&
                    grid[2][col].getText().equals(player)) {
                for (int row = 0; row < 3; row++) grid[row][col].setBackground(Color.GREEN);
            }

        // Diagonalen
        if (grid[0][0].getText().equals(player) &&
                grid[1][1].getText().equals(player) &&
                grid[2][2].getText().equals(player)) {
            grid[0][0].setBackground(Color.GREEN);
            grid[1][1].setBackground(Color.GREEN);
            grid[2][2].setBackground(Color.GREEN);
        }

        if (grid[0][2].getText().equals(player) &&
                grid[1][1].getText().equals(player) &&
                grid[2][0].getText().equals(player)) {
            grid[0][2].setBackground(Color.GREEN);
            grid[1][1].setBackground(Color.GREEN);
            grid[2][0].setBackground(Color.GREEN);
        }
    }

    private void resetGame() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                grid[row][col].setText("");
                grid[row][col].setBackground(null);
            }
        isXTurn = true;
        moveCount = 0;
        statusLabel.setText("Spieler X ist am Zug");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }
}
