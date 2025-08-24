package GUI;

import javax.swing.*;
import java.awt.*;

public class StickmanDrawing extends JFrame {

    public StickmanDrawing() {
        super("Strichmännchen");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new StickmanPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new StickmanDrawing();
    }
}

class StickmanPanel extends JPanel {

    private final Color skinColor = new Color(238, 197, 145);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Kopf
        g2.setColor(skinColor);
        g2.fillOval(150, 50, 100, 100);

        // Oberkörper
        g2.setColor(Color.RED);
        g2.drawLine(200, 150, 200, 250);

        // Rock
        g2.setColor(Color.BLUE);
        int[] xPoints = {200, 150, 250};
        int[] yPoints = {250, 350, 350};
        g2.fillPolygon(xPoints, yPoints, 3);

        // Arme
        g2.setColor(Color.BLACK);
        g2.drawLine(200, 180, 150, 220);
        g2.drawLine(200, 180, 250, 220);

        // Beine
        g2.drawLine(200, 350, 150, 400);
        g2.drawLine(200, 350, 250, 400);
    }
}
