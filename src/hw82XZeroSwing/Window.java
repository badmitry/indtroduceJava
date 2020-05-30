package hw82XZeroSwing;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static final int X_POS_WINDOW = 200;
    private static final int Y_POS_WINDOW = 200;
    private static final int WINDOW_HEIGHT = 635;
    private static final int WINDOW_WIDTH = 575;


    private static SettingsPanel settingsPanel;
    private static GamePanel fieldGame;
    static String message = "Hello player!";
    public static JLabel jlMessage;


    public Window() {
        setBounds(X_POS_WINDOW, Y_POS_WINDOW, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("X_Zero");
        setResizable(false);
        settingsPanel = new SettingsPanel(this);
        fieldGame = new GamePanel(this);
        add(fieldGame, BorderLayout.CENTER);

        JPanel panelS = new JPanel();
        panelS.setLayout(new GridLayout(1, 2));
        JButton btnStartGame = new JButton("Start New Game");
        panelS.add(btnStartGame);
        JButton btnSettings = new JButton("Settings");
        panelS.add(btnSettings);
        add(panelS, BorderLayout.SOUTH);

        JPanel jMessage = new JPanel();
        jMessage.add(jlMessage= new JLabel(message));
        add(jMessage, BorderLayout.NORTH);


        btnStartGame.addActionListener(e -> {
            settingsPanel.setVisible(false);
            fieldGame.setVisible(true);
            if (SettingsPanel.btnHumVsHum.isSelected()){
                fieldGame.gameMode = 0;
            }
            if (SettingsPanel.btnHumVsAi.isSelected()){
                fieldGame.gameMode = 1;
            }
            startNewGame();
        });

        btnSettings.addActionListener(e -> {
            settingsPanel.setVisible(true);
            fieldGame.setVisible(false);
        });

        setVisible(true);
    }
    void startNewGame() {
        fieldGame.startNewGame();
    }
}
