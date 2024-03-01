import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RoundedRectangle extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = 100;
        int height = 50;
        int cornerRadius = 10;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int x = (panelWidth - width) / 2;
        int y = (panelHeight - height) / 2;

        GeneralPath path = new GeneralPath();
        path.moveTo(x + cornerRadius, y);
        path.lineTo(x + width - cornerRadius, y);
        path.quadTo(x + width, y, x + width, y + cornerRadius);
        path.lineTo(x + width, y + height - cornerRadius);
        path.quadTo(x + width, y + height, x + width - cornerRadius, y + height);
        path.lineTo(x + cornerRadius, y + height);
        path.quadTo(x, y + height, x, y + height - cornerRadius);
        path.lineTo(x, y + cornerRadius);
        path.quadTo(x, y, x + cornerRadius, y);
        path.closePath();

        g2d.draw(path);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rounded Rectangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RoundedRectangle());
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
