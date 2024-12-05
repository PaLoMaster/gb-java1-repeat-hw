package ru.khusyainov.gb.java1.hw8;

import java.awt.*;
import java.util.Objects;
import java.util.Random;

abstract class Sprite {
    private static final int VELOCITY_MINIMUM = 20;
    private static final int VELOCITY_MAXIMUM = 100;
    private static final int VELOCITY_DELTA_TIME_FACTOR = 300;
    private static final int COLOR_MINIMUM = 0xff000000;
    private static final int COLOR_MAXIMUM = 0x000000ff;
    protected final Random random = new Random();
    protected int x;
    protected int y;
    protected int halfWidth;
    protected int halfHeight;
    protected int vY;
    protected int vX;
    protected Color color;

    public Sprite() {
        vY = random.nextInt(VELOCITY_MINIMUM, VELOCITY_MAXIMUM);
        vX = random.nextInt(VELOCITY_MINIMUM, VELOCITY_MAXIMUM);
        color = new Color(random.nextInt(COLOR_MINIMUM, COLOR_MAXIMUM));
    }

    public void update(int deltaTime) {
        x += vX * deltaTime / VELOCITY_DELTA_TIME_FACTOR;
        y += vY * deltaTime / VELOCITY_DELTA_TIME_FACTOR;
        color = new Color(color.getRGB() < COLOR_MAXIMUM ? color.getRGB() + 1 : COLOR_MINIMUM);
    }

    public abstract void render(Graphics g);

    public int getLeft() {
        return x - halfWidth;
    }

    public void setLeft(int left) {
        x = left + halfWidth;
    }

    public int getRight() {
        return x + halfWidth;
    }

    public void setRight(int right) {
        x = right - halfWidth;
    }

    public int getTop() {
        return y - halfHeight;
    }

    public void setTop(int top) {
        y = top + halfHeight;
    }

    public int getBottom() {
        return y + halfHeight;
    }

    public void setBottom(int bottom) {
        y = bottom - halfHeight;
    }

    public int getWidth() {
        return 2 * halfWidth;
    }

    public int getHeight() {
        return 2 * halfHeight;
    }

    public void revertVx() {
        vX = -vX;
    }

    public void revertVy() {
        vY = -vY;
    }

    public int getArea() {
        return getWidth() * getHeight();
    }

    public Color getColor() {
        return color;
    }

    public boolean isCollidedAndSimilar(Sprite sprite) {
        return isCollided(sprite) && isSimilar(sprite);
    }

    public boolean isCollidedAndBigger(Sprite sprite) {
        return isCollided(sprite) && isBigger(sprite);
    }

    public boolean isSimilar(Sprite sprite) {
        return halfHeight == sprite.halfHeight && halfWidth == sprite.halfWidth;
    }

    public boolean isBigger(Sprite sprite) {
        return getArea() > sprite.getArea();
    }

    public boolean isCollided(Sprite sprite) {
        return isCollidedByLeftTopAngle(sprite) || isCollidedByRightTopAngle(sprite)
                || isCollidedByLeftBottomAngle(sprite) || isCollidedByRightBottomAngle(sprite);
    }

    protected boolean isCollidedByLeftTopAngle(Sprite sprite) {
        return isDotInArea(getLeft(), getTop(), sprite.getLeft(), sprite.getRight(), sprite.getTop(),
                sprite.getBottom());
    }

    protected boolean isCollidedByRightTopAngle(Sprite sprite) {
        return isDotInArea(getRight(), getTop(), sprite.getLeft(), sprite.getRight(), sprite.getTop(),
                sprite.getBottom());
    }

    protected boolean isCollidedByLeftBottomAngle(Sprite sprite) {
        return isDotInArea(getLeft(), getBottom(), sprite.getLeft(), sprite.getRight(), sprite.getTop(),
                sprite.getBottom());
    }

    protected boolean isCollidedByRightBottomAngle(Sprite sprite) {
        return isDotInArea(getRight(), getBottom(), sprite.getLeft(), sprite.getRight(), sprite.getTop(),
                sprite.getBottom());
    }

    protected boolean isDotInArea(int x, int y) {
        return isDotInArea(x, y, getLeft(), getRight(), getTop(), getBottom());
    }

    protected boolean isDotInArea(int x, int y, int areaLeftX, int areaRightX, int areaTopY, int areaBottomY) {
        return x >= areaLeftX && x <= areaRightX && y >= areaTopY && y <= areaBottomY;
    }

    public void absorb(Sprite sprite) {
        halfHeight = halfWidth = (int) Math.sqrt((getArea() + sprite.getArea()) / 4.0);
    }

    public void reflectFromOther(Sprite sprite) {
        boolean revert = false;
        if (isCollidedByLeftTopAngle(sprite)) {
            setTop(sprite.getBottom() - 1);
            setLeft(sprite.getRight() - 1);
            revert = true;
        }
        if (isCollidedByRightTopAngle(sprite)) {
            setRight(sprite.getLeft() + 1);
            setTop(sprite.getBottom() - 1);
            revert = true;
        }
        if (isCollidedByLeftBottomAngle(sprite)) {
            setLeft(sprite.getRight() - 1);
            setBottom(sprite.getTop() + 1);
            revert = true;
        }
        if (isCollidedByRightBottomAngle(sprite)) {
            setRight(sprite.getLeft() + 1);
            setBottom(sprite.getTop() + 1);
            revert = true;
        }
        if (revert) {
            revertVx();
            revertVy();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return x == ball.x && y == ball.y && halfWidth == ball.halfWidth && vX == ball.vX && vY == ball.vY
                && Objects.equals(color, ball.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, halfWidth, vX, vY, color);
    }

    @Override
    public String toString() {
        return "Sprite{" +
                "x=" + x +
                ", y=" + y +
                ", halfWidth=" + halfWidth +
                ", halfHeight=" + halfHeight +
                ", vY=" + vY +
                ", vX=" + vX +
                ", color=" + color +
                '}';
    }
}