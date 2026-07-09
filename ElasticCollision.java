import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class ElasticCollision extends JPanel {
    static double v1i = -5.0;
    static double v2i = 5.0;
    static double v3i = 5.0;

    static int fw = 500;
    static int fh = 500;

    static double v1f;
    static double v2f = -3.0;
    static double v1fB3;
    static double v2fB3;
    static double v3fB1;
    static double v3fB2;

    static int dx1 = 425;
    static int dx2 = 15;
    static int dx3 = 430;

    static int dy1 = 415;
    static int dy2 = 415;
    static int dy3 = 415;

    static int dw1 = 45;
    static int dw2 = 45;
    static int dw3 = 45;

    static int dh1 = 45;
    static int dh2 = 45;
    static int dh3 = 45;

    static int m1 = 4;
    static int m2 = 5;
    static int m3 = 6;

    static Timer timer;
    static JFrame frame;

    static String frameTitle = "Elastic Collision Simulation";

    static boolean frameResizable = false;
    static boolean frameVisible = true;

    static int colorBlack[] = { 0, 0, 0 };

    public static void main(String[] args) {
        frame = new JFrame(frameTitle);
        ElasticCollision panel = new ElasticCollision();
        frame.setSize(fw, fh);
        frame.setResizable(frameResizable);
        panel.setBackground(new Color(colorBlack[0], colorBlack[1], colorBlack[2]));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(frameVisible);

        v1f = ((m1 * v1i + m2 * v2i) - m2 * v2f) / m1;
        v2f = ((m2 * v2i + m1 * v1i) - m1 * v1f) / m2;

        v3fB1 = ((m1 * v1i + m3 * v3i) - m1 * v1f) / m3;
        v3fB2 = ((m2 * v2i + m3 * v3i) - m2 * v2f) / m3;

        v1fB3 = ((m3 * v3i + m1 * v1i) - m3 * v3fB1) / m1;
        v2fB3 = ((m3 * v3i + m2 * v2i) - m3 * v3fB2) / m2;

        timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dx1 += v1i;
                dx2 += v2i;
                dx3 += v3i;

                panel.repaint();

                collision1();
                collision2();
                collision3();
            }
        });
        timer.start();
    }

    public static void collision1() {
        if (dx1 <= 0) {
            v1i = -v1i;
        }

        if (dx1 >= 440) {
            v1i = -v1i;
        }
    }

    public static void collision2() {
        if (dx2 >= 440) {
            v2i = -v2i;
        }

        if (dx2 <= 0) {
            v2i = -v2i;
        }
    }

    public static void collision3() {
        if (dx3 >= 440) {
            v3i = -v3i;
        }

        if (dx3 <= 0) {
            v3i = -v3i;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
         * Red -> <- Blue *
         */

        // Object 1 - Blue
        g.setColor(new Color(0, 0, 255));
        g.fillOval(dx1, dy1, dw1, dh1);
        g.drawOval(dx1, dy1, dw1, dh1);

        // Object 2 - Red
        g.setColor(new Color(255, 0, 0));
        g.fillOval(dx2, dy2, dw2, dh2);
        g.drawOval(dx2, dy2, dw2, dh2);

        // Object 3 - White
        g.setColor(new Color(255, 255, 255));
        g.drawOval(dx3, dy3, dw3, dh3);
        g.fillOval(dx3, dy3, dw3, dh3);

        Rectangle b1 = new Rectangle(dx1, dy1, dw1, dh1);
        Rectangle b2 = new Rectangle(dx2, dy2, dw2, dh2);
        Rectangle b3 = new Rectangle(dx3, dy3, dw3, dh3);

        if (b1.intersects(b2)) {
            v1i = v1f;
            v2i = v2f;
        }

        if (b1.intersects(b3)) {
            v3i = v3fB1;
        }

        if (b2.intersects(b3)) {
            v3i = v3fB2;
        }

        if (b3.intersects(b1)) {
            v1i = v1fB3;
        }

        if (b3.intersects(b2)) {
            v2i = v2fB3;
        }
    }
}