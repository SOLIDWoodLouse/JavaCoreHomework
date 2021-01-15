package lesson07.homework;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    public static final int GAME_MODE_HVA = 0;
    public static final int GAME_MODE_HVH = 1;

    GameMap() {
        setBackground(Color.GRAY);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        GridLayout gridLayout = new GridLayout(fieldSizeX, fieldSizeY);
        setLayout(gridLayout);
        for (int i = 0; i < fieldSizeX*fieldSizeY; i++ ){
            add(new Button());
        }
        this.revalidate();
    }

}
