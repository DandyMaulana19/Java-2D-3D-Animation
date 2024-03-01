import javax.swing.*;
import java.awt.*;

public class Planet extends JPanel {
    private double sunRadius = 20;
    private double planetRadius = 10;
    private double orbitRadius = 200;
    private double planetAngle = 0;
    private double rotationSpeed = 2 * Math.PI / 365;
    private Timer timer;

    public Planet() {
        timer = new Timer(20, e -> {
            planetAngle += rotationSpeed;
            if (planetAngle >= 2 * Math.PI) {
                planetAngle -= 2 * Math.PI;
            }
            repaint();
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        g2d.translate(centerX, centerY);

        double planetX = orbitRadius * Math.cos(planetAngle);
        double planetY = orbitRadius * Math.sin(planetAngle);

        double angleToSun = Math.atan2(planetY, planetX);

        g2d.setColor(Color.YELLOW);
        g2d.fillOval((int) (-sunRadius), (int) (-sunRadius), (int) (2 * sunRadius), (int) (2 * sunRadius));

        g2d.setColor(Color.BLUE);
        g2d.fillOval((int) (planetX - planetRadius), (int) (planetY - planetRadius),
                (int) (2 * planetRadius), (int) (2 * planetRadius));

        double halfPlanetAngle = Math.acos(planetRadius / orbitRadius);
        double startAngle = planetAngle - halfPlanetAngle;
        double endAngle = planetAngle + halfPlanetAngle;
        boolean isInShadow = (angleToSun >= startAngle && angleToSun <= endAngle);

        if (isInShadow) {
            g2d.setColor(new Color(0, 0, 0, 100));
            g2d.fillOval((int) (planetX - planetRadius), (int) (planetY - planetRadius),
                    (int) (2 * planetRadius), (int) (2 * planetRadius));
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sun and Earth");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        Planet animation = new Planet();
        frame.add(animation);

        frame.setVisible(true);
    }
}
