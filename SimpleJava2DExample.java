import java.awt.*;

public class SimpleJava2DExample extends Frame {
    SimpleJava2DExample() {
        addWindowListener(new MyFinishWindow());
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("Hello World", 30, 50);
    }

    public static void main(String[] args) {
        SimpleJava2DExample frame = new SimpleJava2DExample();
        frame.setTitle("The First java 2D program");
        frame.setSize(350, 80);
        frame.setVisible(true);
    }
}
