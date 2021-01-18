package lesson07.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_POSITION_X = 650;
    private static final int WINDOW_POSITION_Y = 250;

    private final Settings settings;
    private final GameMap gameMap;


    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POSITION_X, WINDOW_POSITION_Y);

        gameMap = new GameMap();
        settings = new Settings(this);

        JButton btnStartGame = new JButton("Новая игра");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JButton btnExit = new JButton("Выйти из игры");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnStartGame);
        panelBottom.add(btnExit);
        add(panelBottom, BorderLayout.SOUTH);

        setTitle("Крестики-Нолики");
        add(gameMap);
        setResizable(false);
        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }

}
