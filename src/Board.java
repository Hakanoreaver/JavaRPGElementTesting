import com.sun.javafx.PlatformUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener, MouseWheelListener, MouseListener {
    private Timer timer;
    private boolean ingame;
    public final int B_WIDTH = 200;
    public final int B_HEIGHT = 200;
    private final int DELAY = 40;
    int dx, dy, screenOffsetX, screenOffsetY, xMoved, yMoved;
    Player player;

    InventorySystem p = new InventorySystem(5, 5, 1,10,40);

    public Board() {
        initBoard();
    }

    private void initBoard() {
        setFocusable(true);
        setBackground(Color.BLACK);
        addKeyListener(new TAdapter());
        addMouseListener(this);
        addMouseWheelListener(this);
        ingame = true;
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        this.setLayout(null);
        p.setLocation(272,(800- 79));
        initCharacters();
        this.add(p);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initCharacters() {
        player = new Player ( 400, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {
           drawObjects(g);

        } else drawGameOver(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawGameOver(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("Game Over" , 160, 140);
    }
    private void drawObjects(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(272, 700, 150, 16); //Draw Grey Health
        g.setColor(Color.RED); // Drawing Health
        g.fillRect(272, 700, (int) (Math.round(player.health * 1.5)), 15);
        g.setColor(Color.GRAY);// Draw Grey Mana
        g.fillRect(577, 700, 150, 16);
        g.setColor(Color.BLUE); //Drawing Mana
        g.fillRect(577, 700, (int) (Math.round(player.mana * 1.5)), 15);
        g.setColor(Color.BLACK); // Drawing Outlines for the Mana and Health Bars
        g.drawRect(272, 700, (int) (Math.round(player.health * 1.5)), 15);
        g.drawRect(577, 700, (int) (Math.round(player.mana * 1.5)), 15);
        g.drawImage(player.getImage(), player.getX(), player.getY(), this); //Drawing Player
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {keyPressed2(e);}

        public void keyReleased(KeyEvent e) {keyReleased2(e);}
    }

    public void moveScreen() {
        screenOffsetX += dx;
        screenOffsetY += dy;
        xMoved -= dx;
        yMoved -= dy;
    }

    public void keyPressed2(KeyEvent e) {

        int key = e.getKeyCode();


        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            dy = -10;
        }

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            dx = -10;
        }

        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            dy = 10;
        }

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            dx = 10;
        }
    }

    public void keyReleased2(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        p.mouseScrolled(e.getWheelRotation());
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            ItemDetails.itemRightClick("Sword", player);
            System.out.println("Here");
        }
        if (e.getButton() == MouseEvent.BUTTON2) {
            ItemDetails.itemRightClick("Sword", player);
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("Right Click");
        }
    }
}
