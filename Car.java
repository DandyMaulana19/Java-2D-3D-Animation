import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;

public class Car extends Frame {
    Car() {
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Use of antialiasing to have nicer lines.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // The lines should have a thickness of 3.0 instead of 1.0.
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);

        // The GeneralPath to describe the car.
        GeneralPath gp = new GeneralPath();

        // Start at the lower front of the car.
        gp.moveTo(60, 120);
        // front underbody
        gp.lineTo(80, 120);
        // front wheel
        gp.quadTo(90, 140, 100, 120);
        // middle underbody
        gp.lineTo(160, 120);
        // rear wheel
        gp.quadTo(170, 140, 180, 120);
        // rear underbody
        gp.lineTo(200, 120);
        // rear
        gp.curveTo(195, 100, 200, 80, 160, 80);
        // roof
        gp.lineTo(110, 80);
        // windscreen
        gp.curveTo(100, 85, 95, 95, 90, 100); // Modify to make it rounded
        // bonnet
        gp.lineTo(60, 100);
        // front
        gp.lineTo(60, 120);

        // Draw the car.
        g2d.draw(gp);

        g2d.setStroke(new BasicStroke(1.0f));
        // Draw a coordinate system.
        drawSimpleCoordinateSystem(200, 150, g2d);

    }

    public static void drawSimpleCoordinateSystem(int xmax, int ymax,
            Graphics2D g2d) {
        int xOffset = 30;
        int yOffset = 50;
        int step = 20;
        String s;
        Font fo = g2d.getFont();
        g2d.setFont(new Font("sansserif", Font.PLAIN, 9));
        g2d.drawLine(xOffset, yOffset, xmax, yOffset);
        for (int i = xOffset + step; i <= xmax; i = i + step) {
            g2d.drawLine(i, yOffset - 2, i, yOffset + 2);
            g2d.drawString(String.valueOf(i), i - 7, yOffset - 7);
        }

        g2d.drawLine(xOffset, yOffset, xOffset, ymax);

        s = "  ";
        for (int i = yOffset + step; i <= ymax; i = i + step) {
            g2d.drawLine(xOffset - 2, i, xOffset + 2, i);
            if (i > 99) {
                s = "";
            }
            g2d.drawString(s + String.valueOf(i), xOffset - 25, i + 5);
        }

        g2d.setFont(fo);
    }

    public static void main(String[] argv) {
        GeneralPathCar f = new GeneralPathCar();
        f.setTitle("GeneralPath example");
        f.setSize(250, 200);
        f.setVisible(true);
    }
}

class MyFinishWindow extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
