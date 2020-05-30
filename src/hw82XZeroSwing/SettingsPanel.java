package hw82XZeroSwing;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JFrame {
    private static final int X_POS_WINDOW = 200;
    private static final int Y_POS_WINDOW = 200;
    private static final int WINDOW_HEIGHT = 610;
    private static final int WINDOW_WIDTH = 575;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 5;
    private static final int MIN_WIN_LENGTH = 3;

    static JRadioButton btnHumVsHum;
    static JRadioButton btnHumVsAi;
    static ButtonGroup gameMode;

    private JSlider jsFieldSize;
    static int fieldSize = MIN_FIELD_SIZE;
    private JSlider jsWinLength;

    private Window window;


    public SettingsPanel(Window window) {
        this.window = window;
        setBounds(X_POS_WINDOW, Y_POS_WINDOW, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("X_Zero");
        setResizable(false);
        setLayout(new GridLayout(7,1));

        add (new JLabel("Choose game mode"));
        btnHumVsHum = new JRadioButton("Human vs Ai",true);
        btnHumVsAi = new JRadioButton("Human vs Human");
        gameMode = new ButtonGroup();
        gameMode.add(btnHumVsHum);
        gameMode.add(btnHumVsAi);
        add(btnHumVsHum);
        add(btnHumVsAi);

        add(new JLabel("Choose field size"));
        jsFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        jsFieldSize.setMajorTickSpacing(1);
        jsFieldSize.setPaintLabels(true);
        jsFieldSize.setPaintTicks(true);
        add(jsFieldSize);
        jsFieldSize.addChangeListener(e -> {
            fieldSize = jsFieldSize.getValue();
            Logic.size = jsFieldSize.getValue();
            jsWinLength.setMaximum(fieldSize);
        });

        add(new JLabel("Chooze winning lingth"));
        jsWinLength = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);
        jsWinLength.setMajorTickSpacing(1);
        jsWinLength.setPaintLabels(true);
        jsWinLength.setPaintTicks(true);
        add(jsWinLength);
        jsWinLength.addChangeListener(e -> {
            Logic.lengthLine = jsWinLength.getValue();
        });



        setVisible(false);
    }
}
