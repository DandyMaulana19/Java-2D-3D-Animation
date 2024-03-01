import java.awt.*;
import java.awt.geom.*;

public class Alphabet extends Frame {

    public Alphabet() {
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        BasicStroke bs = new BasicStroke(10.0f);
        g2d.setStroke(bs);

        int[] xd = new int[6];
        int[] yd = new int[6];

        xd[1] = 50;
        yd[1] = 50;

        xd[2] = 50;
        yd[2] = 450;

        xd[3] = 400;
        yd[3] = 250;

        xd[4] = 50;
        yd[4] = 450;

        xd[5] = 50;
        yd[5] = 250;

        QuadCurve2D.Double q1;
        QuadCurve2D.Double q2;

        q1 = new QuadCurve2D.Double(xd[1], yd[1], xd[3], yd[3], xd[2], yd[2]);
        q2 = new QuadCurve2D.Double(xd[1], yd[1], xd[5], yd[5], xd[4], yd[4]);

        g2d.draw(q1);
        g2d.draw(q2);

    }

    public static void main(String[] argv) {
        Alphabet f = new Alphabet();
        f.setTitle("Alphabet");

        f.setSize(270, 470);
        f.setVisible(true);
    }

}
