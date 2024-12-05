package ru.khusyainov.gb.java1.hw8;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GameCanvas extends JPanel {

    private long lastFrameTime;
    private final List<Sprite> sprites = new ArrayList<>();
    private final int[] rgb = {(int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)};
    private final boolean[] rgbSigns = {false, false, false};

    GameCanvas() {
        lastFrameTime = System.nanoTime();
        addMouseListener(new CustomMouseListener());
        addOrRemoveSprite(0, 0);
        setBackground(updateColor());
    }

    private int getLeft() {
        return 0;
    }

    private int getRight() {
        return getWidth();
    }

    private int getTop() {
        return 0;
    }

    private int getBottom() {
        return getHeight();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        int deltaTime = (int) ((currentTime - lastFrameTime) * 1e-6f);
        lastFrameTime = currentTime;

        onRepaint(g, deltaTime);

        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    private void onRepaint(Graphics g, int deltaTime) {
        setBackground(updateColor());
        for (Iterator<Sprite> it = sprites.iterator(); it.hasNext(); ) {
            Sprite sprite = it.next();
            sprite.update(deltaTime);
            if (isFitsIntoField(sprite)) {
                reflectFromBorders(sprite);
                reflectFromOthers(sprite);
                if (absorbByOthers(sprite)) {
                    it.remove();
                } else {
                    sprite.render(g);
                }
            } else {
                setBackground(sprite.getColor());
                it.remove();
            }
        }
    }

    private Color updateColor() {
        for (int i = 0; i < rgb.length; i++) {
            rgbSigns[i] = (rgb[i] == 0 || rgb[i] == 255) != rgbSigns[i];
            rgb[i] += (rgbSigns[i] ? -1 : 1);
        }
        return new Color(rgb[0], rgb[1], rgb[2]);
    }

    private void reflectFromBorders(Sprite sprite) {
        if (sprite.getLeft() < getLeft()) {
            sprite.setLeft(getLeft());
            sprite.revertVx();
        }
        if (sprite.getRight() > getRight()) {
            sprite.setRight(getRight());
            sprite.revertVx();
        }
        if (sprite.getTop() < getTop()) {
            sprite.setTop(getTop());
            sprite.revertVy();
        }
        if (sprite.getBottom() > getBottom()) {
            sprite.setBottom(getBottom());
            sprite.revertVy();
        }
    }

    private void reflectFromOthers(Sprite sprite) {
        sprites.forEach(otherSprite -> {
            if (!otherSprite.equals(sprite) && otherSprite.isCollidedAndSimilar(sprite)) {
                otherSprite.reflectFromOther(sprite);
            }
        });
    }

    private boolean absorbByOthers(Sprite sprite) {
        for (Sprite otherSprite : sprites) {
            if (!otherSprite.equals(sprite) && otherSprite.isCollidedAndBigger(sprite)) {
                otherSprite.absorb(sprite);
                return true;
            }
        }
        return false;
    }

    private boolean isFitsIntoField(Sprite sprite) {
        return sprite.getHeight() <= getHeight() && sprite.getWidth() <= getWidth();
    }

    private void addOrRemoveSprite(int x, int y) {
        boolean spritesNotClicked = true;
        for (Iterator<Sprite> it = sprites.iterator(); it.hasNext(); ) {
            Sprite sprite = it.next();
            if (sprite.isDotInArea(x, y)) {
                setBackground(sprite.getColor());
                it.remove();
                spritesNotClicked = false;
            }
        }
        if (spritesNotClicked) {
            sprites.add(new Ball(x, y));
        }
    }

    private class CustomMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            GameCanvas.this.addOrRemoveSprite(e.getX(), e.getY());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}