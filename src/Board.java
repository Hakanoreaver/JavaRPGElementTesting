import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private boolean ingame;
    public final int B_WIDTH = 200;
    public final int B_HEIGHT = 200;
    private final int DELAY = 40;
    int dx, dy, screenOffsetX, screenOffsetY, xMoved, yMoved;
    Player player;

    InventorySystem p = new InventorySystem(500, 130, 2,8,40,0);

    public Board() {
        initBoard();
    }

    private void initBoard() {
        setFocusable(true);
        setBackground(Color.WHITE);
        addKeyListener(new TAdapter());
        ingame = true;
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        this.setLayout(null);
        p.setLocation(250,(800-150));
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
        g.setColor(Color.RED);
        g.fillRect(20, 650, player.health, 20);
        g.setColor(Color.BLUE);
        g.fillRect(20, 700, player.mana, 20);
        g.setColor(Color.BLACK);
        g.drawRect(20, 650, player.health, 20);
        g.drawRect(20, 700, player.mana, 20);
        g.drawImage(player.getImage(), player.getX(), player.getY(), this);
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
}
