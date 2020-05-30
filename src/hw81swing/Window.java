package hw81swing;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static float outputX = 0;
    private static float temporaryY = 0;
    private static int action;

    public Window() {
        // прописываем расположение, размеры окна
        setBounds(600, 200, 500, 500);
        // завершаем приложение при закрытии окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // задаем название окна
        setTitle("Calc");
//        setLayout(null); // всем объектам необходимо будет задавать координаты через setBounds();


        JPanel jpanelN = new JPanel(); // создаем новую панель
        jpanelN.setLayout(new BoxLayout(jpanelN, BoxLayout.X_AXIS)); // задаем расположение элементов (по оси X)
        JTextField textField = new JTextField(); // создаем текстовое поле
        jpanelN.add(textField);
        JButton btnC = new JButton("C");
        jpanelN.add(btnC);
        add(jpanelN, "North");
        jpanelN.setPreferredSize(new Dimension(500, 40));

        JPanel jpanelC = new JPanel();
        jpanelC.setLayout(new GridLayout(1, 4));
        JButton btn1 = new JButton("+");
        jpanelC.add(btn1);
        JButton btn2 = new JButton("-");
        jpanelC.add(btn2);
        JButton btn3 = new JButton("*");
        jpanelC.add(btn3);
        JButton btn4 = new JButton("/");
        jpanelC.add(btn4);
        add(jpanelC, BorderLayout.CENTER);
        jpanelC.setPreferredSize(new Dimension(500, 300));

        JPanel jpanelS = new JPanel();
        jpanelS.setLayout(new GridLayout(1, 4));
        JButton btn5 = new JButton("=");
        jpanelS.add(btn5);
        add(jpanelS, BorderLayout.SOUTH);
        jpanelS.setPreferredSize(new Dimension(500, 200));

        //назначаем кнопкам действия:
        btnC.addActionListener(e -> {
            textField.setText("");
            outputX = 0;
            temporaryY = 0;
            action = 0;
        });

        btn1.addActionListener(e -> {
            temporaryY = Float.valueOf(textField.getText());
            makeLastAct();
            outputX = temporaryY;
            action = 1;
            textField.setText("" + outputX);

        });

        btn2.addActionListener(e -> {
            temporaryY = Float.valueOf(textField.getText());
            makeLastAct();
            outputX = temporaryY;
            action = 2;
            textField.setText("" + outputX);

        });

        btn3.addActionListener(e -> {
            temporaryY = Float.valueOf(textField.getText());
            makeLastAct();
            outputX = temporaryY;
            action = 3;
            textField.setText("" + outputX);

        });

        btn4.addActionListener(e -> {
            temporaryY = Float.valueOf(textField.getText());
            makeLastAct();
            outputX = temporaryY;
            action = 4;
            textField.setText("" + outputX);

        });

        btn5.addActionListener(e -> {
            temporaryY = Float.valueOf(textField.getText());
            makeLastAct();
            textField.setText("" + temporaryY);
            temporaryY = 0;
            outputX = 0;
            action = 0;
        });



        // делаем окно видимым
        setVisible(true);
    }

    private static void makeLastAct() {
        switch (action) {
            case (1):
                temporaryY = outputX + temporaryY;
                break;
            case (2):
                temporaryY = outputX - temporaryY;
                break;
            case (3):
                temporaryY = outputX * temporaryY;
                break;
            case (4):
                temporaryY = outputX / temporaryY;
                break;
        }
    }


}
