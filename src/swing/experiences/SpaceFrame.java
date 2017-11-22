package swing.experiences;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SpaceFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }
                new SpaceFrame();
            }
        });
    }

    public SpaceFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new SpacePane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected class SpacePane extends JPanel implements Screen {

        private BufferedImage buffer;

        public SpacePane() {
        }

        @Override
        public void addNotify() {
            super.addNotify();
            // We need to make that the screen pane is actually on the screen...
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Thread thread = new Thread(new UpdaterThread(SpacePane.this));
                    thread.setDaemon(true);
                    thread.start();

                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (buffer != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(buffer, 0, 0, this);
            }
        }

        @Override
        public void renderBuffer(final BufferedImage image) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    buffer = image;
                    repaint();
                }
            });
        }
    }

    protected interface Screen {
        public Dimension getSize();
        public void renderBuffer(final BufferedImage image);
    }

    protected class UpdaterThread implements Runnable {

        private int cycle = 0;
        private BufferedImage[] buffers = new BufferedImage[2];
        private Screen screen;
        // A row of aliens...
        private RowOfAliens rowOfAliens;
        // Adjusts the speed at which the aliens move
        private int speed = 10;

        public UpdaterThread(Screen screen) {
            this.screen = screen;
        }

        public Screen getScreen() {
            return screen;
        }

        @Override
        public void run() {
            // We're only using 1 row...
            rowOfAliens = new RowOfAliens();
            rowOfAliens.setLocation(new Point(0, 0));
            rowOfAliens.setDirection(10);

            while (true) {

                try {
                    Thread.sleep(16); // 60 fps
                } catch (InterruptedException ex) {
                }

                cycle++;

                // Update the offscreen buffer...
                BufferedImage buffer = getBuffer();
                if (buffer != null) {

                    // Move the alients...
                    updateAliens();

                    // Paint the various layers
                    int width = buffer.getWidth();
                    int height = buffer.getHeight();
                    Graphics2D g2d = buffer.createGraphics();
                    // You could paint a space scape here
                    paintBackground(g2d, width, height);
                    // The aliens and other game arifcates
                    paintMidground(g2d, width, height);
                    // Special effects
                    paintForeground(g2d, width, height);
                    g2d.dispose();

                    // Send the buffer to the screen
                    paintBuffer(buffer);

                }

            }

        }

        protected void updateAliens() {
            Screen screen = getScreen();
            if (screen != null) {

                // Controls the speed at which the aliens move
                if (cycle % speed == 0) {
                    // Get the aliens current location and direction...
                    Point p = rowOfAliens.getLocation();
                    p.x += rowOfAliens.getDirection();

                    int screenWidth = screen.getSize().width;
                    int screenHeight = screen.getSize().height;
                    // Boundray check...
                    if (p.x + rowOfAliens.getBounds().width > screenWidth) {
                        p.x = screenWidth - rowOfAliens.getBounds().width;
                        // Reverse direction
                        rowOfAliens.setDirection(-10);
                        p.y += 10;
                    } else if (p.x < 0) {
                        p.x = 0;
                        p.y += 10;
                        // Reverse direction
                        rowOfAliens.setDirection(10);
                    }
                    // Set the location of the row...
                    rowOfAliens.setLocation(p);

                }

            }

        }

        protected void paintBackground(Graphics2D g2d, int width, int height) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, width, height);
        }

        protected void paintMidground(Graphics2D g2d, int width, int height) {
            Point p = rowOfAliens.getLocation();
            g2d.translate(p.x, p.y);
            rowOfAliens.paint(g2d);
            g2d.translate(-p.x, -p.y);
        }

        protected void paintForeground(Graphics2D g2d, int width, int height) {
        }

        protected BufferedImage getBuffer() {
            BufferedImage buffer = null;

            Screen screen = getScreen();
            if (screen != null) {
                // Determine which buffer to use
                int index = 0;
                if (cycle % 2 != 0) {
                    index = 1;
                }

                buffer = buffers[index];
                if (buffer == null || buffer.getWidth() != screen.getSize().width || buffer.getHeight() != screen.getSize().height) {
                    // Create a compataible graphics object, so it will render faster on the screen...
                    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    GraphicsDevice gs = ge.getDefaultScreenDevice();
                    GraphicsConfiguration gc = gs.getDefaultConfiguration();

                    buffer = gc.createCompatibleImage(screen.getSize().width, screen.getSize().height, Transparency.OPAQUE);
                    buffers[index] = buffer;
                }

            }

            return buffer;

        }

        protected void paintBuffer(BufferedImage buffer) {
            // Send the buffer to the screen...
            Screen screen = getScreen();
            if (screen != null) {
                screen.renderBuffer(buffer);
            }
        }
    }

    protected class RowOfAliens {

        private List<Alien> lstAliens;
        private Point location;
        private int direction;
        private Rectangle bounds;

        public RowOfAliens() {
            lstAliens = new ArrayList<Alien>(25);
            lstAliens.add(new AlienType1());
            lstAliens.add(new AlienType2());
            lstAliens.add(new AlienType3());
            lstAliens.add(new AlienType4());

            setLocation(new Point(0, 0));
            // Calculate the size of the row...
            bounds = new Rectangle(Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0);

            int index = 0;
            for (Alien alien : lstAliens) {

                Rectangle aBounds = alien.getBounds();
                aBounds.setLocation(alien.getLocation());
                System.out.println(index + ": " + aBounds);

                bounds.x = Math.min(bounds.x, aBounds.x);
                bounds.y = Math.min(bounds.y, aBounds.y);

                bounds.width = Math.max(bounds.width, aBounds.x + aBounds.width);
                bounds.height = Math.max(bounds.height, aBounds.y + aBounds.height);

            }

            System.out.println(bounds);

        }

        protected void paint(Graphics2D g2d) {
            // Paint the aliens
            Point pos = getLocation();

            for (Alien alien : lstAliens) {
                g2d.setColor(alien.getColor());
                Point p = alien.getLocation();
                // We need to take into account the current location of the row
                // in relation to the alien...
                int xPos = p.x - pos.x;
                g2d.translate(xPos, 0);
                g2d.fill(alien);
                g2d.translate(-xPos, 0);
            }

        }

        protected void layoutRow() {
            // Layout the aliens within there row based on the currrent location...
            // Techniqually, we could offset the aliens at 0x0 and simply adjust the
            // the x position by the width of each alien and it's gap
            // This would eliminate the need to adjust the position in the
            // paint method, but hay...
            Point p = new Point(getLocation());
            for (Alien alien : lstAliens) {
                alien.setLocation(p);
                p = new Point(p.x, p.y);
                p.x += alien.getBounds().width + 10;
            }

        }

        public Rectangle getBounds() {
            return bounds;
        }

        public void setLocation(Point point) {
            if (location == null || point == null || (!location.equals(point))) {
                location = point;
                layoutRow();
            }
        }

        public Point getLocation() {
            return new Point(location);
        }

        public void setDirection(int value) {
            direction = value;
        }

        public int getDirection() {
            return direction;
        }
    }

    protected abstract class Alien extends Path2D.Float {

        private Point location;
        private Color color;

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public void setLocation(Point location) {
            this.location = location;
        }

        public Point getLocation() {
            return location;
        }

        public void addRectangle(int x, int y, int width, int height) {
            moveTo(x, y);
            lineTo(x + width, y);
            lineTo(x + width, y + height);
            lineTo(x, y + height);
            lineTo(x, y);
        }
    }

    protected class AlienType1 extends Alien {

        public AlienType1() {
            setColor(Color.ORANGE);
            addRectangle(30, 0, 10, 10);
            addRectangle(40, 0, 10, 10);
            addRectangle(20, 10, 10, 10);
            addRectangle(30, 10, 10, 10);
            addRectangle(40, 10, 10, 10);
            addRectangle(50, 10, 10, 10);
            addRectangle(10, 20, 10, 10);
            addRectangle(20, 20, 10, 10);
            addRectangle(30, 20, 10, 10);
            addRectangle(40, 20, 10, 10);
            addRectangle(50, 20, 10, 10);
            addRectangle(60, 20, 10, 10);
            addRectangle(0, 30, 10, 10);
            addRectangle(10, 30, 10, 10);
            addRectangle(30, 30, 10, 10);
            addRectangle(40, 30, 10, 10);
            addRectangle(60, 30, 10, 10);
            addRectangle(70, 30, 10, 10);
            addRectangle(0, 40, 10, 10);
            addRectangle(10, 40, 10, 10);
            addRectangle(20, 40, 10, 10);
            addRectangle(30, 40, 10, 10);
            addRectangle(40, 40, 10, 10);
            addRectangle(50, 40, 10, 10);
            addRectangle(60, 40, 10, 10);
            addRectangle(70, 40, 10, 10);
            addRectangle(20, 50, 10, 10);
            addRectangle(50, 50, 10, 10);
            addRectangle(10, 60, 10, 10);
            addRectangle(30, 60, 10, 10);
            addRectangle(40, 60, 10, 10);
            addRectangle(60, 60, 10, 10);
            addRectangle(0, 70, 10, 10);
            addRectangle(20, 70, 10, 10);
            addRectangle(50, 70, 10, 10);
            addRectangle(70, 70, 10, 10);
            closePath();
        }
    }

    protected class AlienType2 extends Alien {

        public AlienType2() {
            setColor(Color.RED);
            addRectangle(20, 0, 10, 10);
            addRectangle(80, 0, 10, 10);
            addRectangle(0, 10, 10, 10);
            addRectangle(30, 10, 10, 10);
            addRectangle(70, 10, 10, 10);
            addRectangle(100, 10, 10, 10);
            addRectangle(0, 20, 10, 10);
            addRectangle(20, 20, 10, 10);
            addRectangle(30, 20, 10, 10);
            addRectangle(40, 20, 10, 10);
            addRectangle(50, 20, 10, 10);
            addRectangle(60, 20, 10, 10);
            addRectangle(70, 20, 10, 10);
            addRectangle(80, 20, 10, 10);
            addRectangle(100, 20, 10, 10);
            addRectangle(0, 30, 10, 10);
            addRectangle(10, 30, 10, 10);
            addRectangle(20, 30, 10, 10);
            addRectangle(40, 30, 10, 10);
            addRectangle(50, 30, 10, 10);
            addRectangle(60, 30, 10, 10);
            addRectangle(80, 30, 10, 10);
            addRectangle(90, 30, 10, 10);
            addRectangle(100, 30, 10, 10);
            addRectangle(0, 40, 10, 10);
            addRectangle(10, 40, 10, 10);
            addRectangle(20, 40, 10, 10);
            addRectangle(30, 40, 10, 10);
            addRectangle(40, 40, 10, 10);
            addRectangle(50, 40, 10, 10);
            addRectangle(60, 40, 10, 10);
            addRectangle(70, 40, 10, 10);
            addRectangle(80, 40, 10, 10);
            addRectangle(90, 40, 10, 10);
            addRectangle(100, 40, 10, 10);
            addRectangle(10, 50, 10, 10);
            addRectangle(20, 50, 10, 10);
            addRectangle(30, 50, 10, 10);
            addRectangle(40, 50, 10, 10);
            addRectangle(50, 50, 10, 10);
            addRectangle(60, 50, 10, 10);
            addRectangle(70, 50, 10, 10);
            addRectangle(80, 50, 10, 10);
            addRectangle(90, 50, 10, 10);
            addRectangle(20, 60, 10, 10);
            addRectangle(80, 60, 10, 10);
            addRectangle(10, 70, 10, 10);
            addRectangle(90, 70, 10, 10);
            closePath();
        }
    }

    protected class AlienType3 extends Alien {

        public AlienType3() {
            setColor(Color.YELLOW);
            addRectangle(20, 0, 10, 10);
            addRectangle(20, 0, 10, 10);
            addRectangle(80, 0, 10, 10);
            addRectangle(30, 10, 10, 10);
            addRectangle(70, 10, 10, 10);
            addRectangle(20, 20, 10, 10);
            addRectangle(30, 20, 10, 10);
            addRectangle(40, 20, 10, 10);
            addRectangle(50, 20, 10, 10);
            addRectangle(60, 20, 10, 10);
            addRectangle(70, 20, 10, 10);
            addRectangle(80, 20, 10, 10);
            addRectangle(10, 30, 10, 10);
            addRectangle(20, 30, 10, 10);
            addRectangle(40, 30, 10, 10);
            addRectangle(50, 30, 10, 10);
            addRectangle(60, 30, 10, 10);
            addRectangle(80, 30, 10, 10);
            addRectangle(90, 30, 10, 10);
            addRectangle(0, 40, 10, 10);
            addRectangle(10, 40, 10, 10);
            addRectangle(20, 40, 10, 10);
            addRectangle(30, 40, 10, 10);
            addRectangle(40, 40, 10, 10);
            addRectangle(50, 40, 10, 10);
            addRectangle(60, 40, 10, 10);
            addRectangle(70, 40, 10, 10);
            addRectangle(80, 40, 10, 10);
            addRectangle(90, 40, 10, 10);
            addRectangle(100, 40, 10, 10);
            addRectangle(0, 50, 10, 10);
            addRectangle(20, 50, 10, 10);
            addRectangle(30, 50, 10, 10);
            addRectangle(40, 50, 10, 10);
            addRectangle(50, 50, 10, 10);
            addRectangle(60, 50, 10, 10);
            addRectangle(70, 50, 10, 10);
            addRectangle(80, 50, 10, 10);
            addRectangle(100, 50, 10, 10);
            addRectangle(0, 60, 10, 10);
            addRectangle(20, 60, 10, 10);
            addRectangle(80, 60, 10, 10);
            addRectangle(100, 60, 10, 10);
            addRectangle(30, 70, 10, 10);
            addRectangle(40, 70, 10, 10);
            addRectangle(60, 70, 10, 10);
            addRectangle(70, 70, 10, 10);
            closePath();
        }
    }

     class AlienType4 extends Alien {

        public AlienType4() {
            setColor(Color.GREEN);
            addRectangle(50, 0, 10, 10);
            addRectangle(60, 0, 10, 10);
            addRectangle(70, 0, 10, 10);
            addRectangle(80, 0, 10, 10);
            addRectangle(90, 0, 10, 10);
            addRectangle(100, 0, 10, 10);
            addRectangle(30, 10, 10, 10);
            addRectangle(40, 10, 10, 10);
            addRectangle(50, 10, 10, 10);
            addRectangle(60, 10, 10, 10);
            addRectangle(70, 10, 10, 10);
            addRectangle(80, 10, 10, 10);
            addRectangle(90, 10, 10, 10);
            addRectangle(100, 10, 10, 10);
            addRectangle(110, 10, 10, 10);
            addRectangle(120, 10, 10, 10);
            addRectangle(20, 20, 10, 10);
            addRectangle(30, 20, 10, 10);
            addRectangle(40, 20, 10, 10);
            addRectangle(50, 20, 10, 10);
            addRectangle(60, 20, 10, 10);
            addRectangle(70, 20, 10, 10);
            addRectangle(80, 20, 10, 10);
            addRectangle(90, 20, 10, 10);
            addRectangle(100, 20, 10, 10);
            addRectangle(110, 20, 10, 10);
            addRectangle(120, 20, 10, 10);
            addRectangle(130, 20, 10, 10);
            addRectangle(10, 30, 10, 10);
            addRectangle(20, 30, 10, 10);
            addRectangle(40, 30, 10, 10);
            addRectangle(50, 30, 10, 10);
            addRectangle(70, 30, 10, 10);
            addRectangle(80, 30, 10, 10);
            addRectangle(100, 30, 10, 10);
            addRectangle(110, 30, 10, 10);
            addRectangle(130, 30, 10, 10);
            addRectangle(140, 30, 10, 10);
            addRectangle(0, 40, 10, 10);
            addRectangle(10, 40, 10, 10);
            addRectangle(20, 40, 10, 10);
            addRectangle(30, 40, 10, 10);
            addRectangle(40, 40, 10, 10);
            addRectangle(50, 40, 10, 10);
            addRectangle(60, 40, 10, 10);
            addRectangle(70, 40, 10, 10);
            addRectangle(80, 40, 10, 10);
            addRectangle(90, 40, 10, 10);
            addRectangle(100, 40, 10, 10);
            addRectangle(110, 40, 10, 10);
            addRectangle(120, 40, 10, 10);
            addRectangle(130, 40, 10, 10);
            addRectangle(140, 40, 10, 10);
            addRectangle(150, 40, 10, 10);
            addRectangle(20, 50, 10, 10);
            addRectangle(30, 50, 10, 10);
            addRectangle(40, 50, 10, 10);
            addRectangle(70, 50, 10, 10);
            addRectangle(80, 50, 10, 10);
            addRectangle(110, 50, 10, 10);
            addRectangle(120, 50, 10, 10);
            addRectangle(130, 50, 10, 10);
            addRectangle(30, 60, 10, 10);
            addRectangle(120, 60, 10, 10);
            closePath();
        }
    }
}