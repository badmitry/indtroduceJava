package hw82XZeroSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {

    private boolean isInit = true;

    private Window window;

    static int gameMode;
    static int cellSize;
    private static char simbol;

    public GamePanel(Window window) {
        this.window = window;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });

        setVisible(false);
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellSize;
        int cellY = e.getY() / cellSize;
        if (gameMode != 0) {
            if (simbol == 'X') {
                simbol = 'O';
            } else {
                simbol = 'X';
            }
            if (!Logic.gameFinished) {
                Logic.playerShot(simbol, cellX, cellY);
            }
        } else {
            if(!Logic.gameFinished) {
                Logic.playerShot(Logic.CHAR_X, cellX, cellY);
            }
            if(!Logic.gameFinished) {
                Logic.aiShot();
            }
        }

        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelHeight = getHeight();

        cellSize = panelHeight / SettingsPanel.fieldSize;
        for (int i = 0; i < SettingsPanel.fieldSize; i++) {
            int y = i * cellSize;
            g.drawLine(0, y, panelHeight, y);
            g.drawLine(y, 0, y, panelHeight);
        }

        for (int i = 0; i < SettingsPanel.fieldSize; i++) {
            for (int j = 0; j < SettingsPanel.fieldSize; j++) {
                if (Logic.playField[i][j] == Logic.CHAR_O) {
                    drawO(g, j, i);
                }
                if (Logic.playField[i][j] == Logic.CHAR_X) {
                    drawX(g, j, i);
                }
                if (Logic.playField[i][j] == Logic.winCharX) {
                    drawXWin(g, j, i);
                }
                if (Logic.playField[i][j] == Logic.winCharO) {
                    drawOWin(g, j, i);
                }
            }
        }
        Logic.printField();
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(new Color(0, 0, 255));
        g2D.drawOval(cellY * cellSize, cellX * cellSize, cellSize, cellSize);

    }

    private void drawOWin(Graphics g, int cellX, int cellY) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(new Color(0, 0, 255));
        g2D.drawOval(cellY * cellSize, cellX * cellSize, cellSize, cellSize);
        g2D.drawLine(cellY * cellSize, cellX * cellSize,
                (cellY + 1) * cellSize, (cellX + 1) * cellSize);
        g2D.drawLine((cellY + 1) * cellSize, cellX * cellSize,
                cellY * cellSize, (cellX + 1) * cellSize);

    }

    private void drawX(Graphics g, int cellX, int cellY) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(new Color(255, 3, 0));
        g2D.drawLine(cellY * cellSize, cellX * cellSize,
                (cellY + 1) * cellSize, (cellX + 1) * cellSize);
        g2D.drawLine((cellY + 1) * cellSize, cellX * cellSize,
                cellY * cellSize, (cellX + 1) * cellSize);

    }

    private void drawXWin(Graphics g, int cellX, int cellY) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(new Color(255, 3, 0));
        g2D.drawLine(cellY * cellSize, cellX * cellSize,
                (cellY + 1) * cellSize, (cellX + 1) * cellSize);
        g2D.drawLine((cellY + 1) * cellSize, cellX * cellSize,
                cellY * cellSize, (cellX + 1) * cellSize);
        g2D.drawOval(cellY * cellSize, cellX * cellSize, cellSize, cellSize);

    }

    void startNewGame() {
        Logic.gameFinished = false;
        Logic.counterMove = 1;
        simbol = 'Y';
        Logic.buildField();
        System.out.println(Logic.playField[1][1]);
        isInit = true;
        repaint();
        Window.jlMessage.setText("Move");
    }


}

