package ru.khusyainov.gb.java1.hw8;

import javax.swing.*;
import java.awt.*;

public class HomeWork8 extends JFrame {
    public static void main(String[] args) {
        new HomeWork8();
    }

    private HomeWork8() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(600, 200);
        setSize(800, 600);
        setResizable(false);
        setTitle("Кружки");
        add(new GameCanvas(), BorderLayout.CENTER);
        setVisible(true);
    }

}
