import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class HeartBeat extends JPanel implements ActionListener {
    private int x;
    private int y;
    private int width = 50;
    private int height = 50;
    private boolean expanding = true;
    private Timer timer;
    private int lineY;

    public HeartBeat() {
        timer = new Timer(30, this);
        timer.start();
        x = 100;
        y = 100;
        lineY = this.getHeight() / 2;
    }

    public void actionPerformed(ActionEvent e) {
        x++;
        if (x > getWidth() + width) {
            x = -width;
        }

        lineY = this.getHeight() / 2;

        if (expanding) {
            width++;
            height++;
            lineY++;
        } else {
            width--;
            height--;
            lineY--;
        }

        if (width >= 150 || width <= 50) {
            expanding = !expanding;
        }

        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, lineY, getWidth(), lineY);

        g2d.setColor(Color.RED);
        g2d.fillArc(x, y, width / 2, height / 2, 0, 180);
        g2d.fillArc(x + width / 2, y, width / 2, height / 2, 0, 180);
        g2d.fillRect(x, y + height / 4, width, height / 4);

        GeneralPath triangle = new GeneralPath();
        triangle.moveTo(x, y + height / 2);
        triangle.lineTo(x + width / 2, y + height);
        triangle.lineTo(x + width, y + height / 2);
        triangle.closePath();
        g2d.fill(triangle);
    }

    public static void main(String[] argv) {
        JFrame frame = new JFrame("Heart Beat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HeartBeat animation = new HeartBeat();
        frame.add(animation);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
