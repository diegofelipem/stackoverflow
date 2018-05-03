package swing.examples8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MousetriangulosTest extends javax.swing.JPanel {

    private Polygon[] polygons = {};
    private Polygon[] fixedPolygons = {};
    private Point ultimo = null;
    private Polygon selecionado = null;

    public MousetriangulosTest() {
        polygons = new Polygon[2];
        fixedPolygons = new Polygon[2];
        this.mover();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLUE);
        g2d.fillPolygon(polygons[0]);

        g2d.setColor(Color.RED);
        g2d.fillPolygon(polygons[1]);

        g2d.setColor(Color.BLUE);
        g2d.drawPolygon(fixedPolygons[0]);

        g2d.setColor(Color.RED);
        g2d.drawPolygon(fixedPolygons[1]);
        g2d.dispose();
    }

    public void trianguloGrande1() {
        int x[] = {90, 90, 392};
        int y[] = {512, 248, 512};
        fixedPolygons[0] = new Polygon(x, y, 3);
    }

    public void trianguloMedio1() {
        int x[] = {245, 90, 395};
        int y[] = {110, 242, 242};
        fixedPolygons[1] = new Polygon(x, y, 3);
    }

    public void trianguloGrande2() {
        int x[] = {630, 630, 923};
        int y[] = {273, 19, 273};
        polygons[0] = new Polygon(x, y, 3);
    }

    public void trianguloMedio2() {
        int x[] = {1152, 1000, 1295};
        int y[] = {86, 209, 209};
        polygons[1] = new Polygon(x, y, 3);
    }

    public Polygon[] getPolygons() {
        return polygons;
    }

    public void setPolygons(Polygon[] polygons) {
        this.polygons = polygons;
    }

    public Polygon[] getPolygons2() {
        return polygons;
    }

    public void setPolygons2(Polygon[] polygons2) {
        this.fixedPolygons = polygons2;
    }

    private void mover() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                onMouseDown(e);
                Graphics2D g = (Graphics2D) getGraphics();
                int x = e.getX();
                int y = e.getY();
                if (e.isMetaDown()) {
                    polygons[0].contains(x, y);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            	
            	if(fixedPolygons[0].getBounds().contains(polygons[0].getBounds())) {
            		JOptionPane.showMessageDialog(null, "Triangulos grandes sincronizados");
            	}
            	
            	if(fixedPolygons[1].getBounds().contains(polygons[1].getBounds())) {
            		JOptionPane.showMessageDialog(null, "Triangulos medios sincronizados");
            	}
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                onMouseDragged(e);
            }
        });
    }

    protected void onMouseDown(MouseEvent e) {
        ultimo = e.getPoint();
        for (Polygon polygon : polygons) {
            if (polygon.contains(ultimo)) {
                selecionado = polygon;
                return;
            }
        }
        selecionado = null;
    }

    protected void onMouseDragged(MouseEvent e) {
        Point now = e.getPoint();
        if (ultimo != null) {
            int xt = now.x - ultimo.x;
            int yt = now.y - ultimo.y;
            if (selecionado != null) {
                selecionado.translate(xt, yt);
                repaint();
            }
            ultimo = now;
        }	
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new JFrame("Teste");
                MousetriangulosTest teste2 = new MousetriangulosTest();

                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.getContentPane().add(teste2);
                jFrame.pack();
                jFrame.setResizable(false);
                jFrame.setVisible(true);
                jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

                teste2.trianguloGrande1();
                teste2.trianguloGrande2();
                teste2.trianguloMedio1();
                teste2.trianguloMedio2();
                teste2.setPolygons(teste2.polygons);
                teste2.setPolygons2(teste2.fixedPolygons);

            }
        });
    }
}
