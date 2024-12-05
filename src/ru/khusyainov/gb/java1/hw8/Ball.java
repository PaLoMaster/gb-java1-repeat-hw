package ru.khusyainov.gb.java1.hw8;

import java.awt.*;

class Ball extends Sprite {
    public static final int RADIUS_MINIMUM = 20;
    public static final int RADIUS_MAXIMUM = 50;
    protected int radius;

    public Ball(int x, int y) {
        this();
        this.x = x;
        this.y = y;
        radius = halfWidth = halfHeight = random.nextInt(RADIUS_MINIMUM, RADIUS_MAXIMUM);
    }

    public Ball() {
        super();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval(getLeft(), getTop(), getWidth(), getHeight());
    }

    @Override
    public int getArea() {
        return (int) (Math.PI * Math.pow(radius, 2));
    }

    private boolean isCollidedByCircleExecutor(int xSign, int ySign, Sprite sprite) {
        int xStart, xEnd;
        if (xSign < 0) {
            xStart = x - radius;
            xEnd = x;
        } else {
            xStart = x;
            xEnd = x + radius;
        }
        for (int ballCircleX = xStart, ballCircleY; ballCircleX <= xEnd; ballCircleX++) {
            ballCircleY = (int) (y + ySign * radius * Math.sin(Math.acos((ballCircleX - x) / (double) radius)));
            if (sprite.isDotInArea(ballCircleX, ballCircleY)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean isCollidedByLeftTopAngle(Sprite sprite) {
        return isCollidedByCircleExecutor(-1, -1, sprite);
    }

    @Override
    protected boolean isCollidedByRightTopAngle(Sprite sprite) {
        return isCollidedByCircleExecutor(1, -1, sprite);
    }

    @Override
    protected boolean isCollidedByLeftBottomAngle(Sprite sprite) {
        return isCollidedByCircleExecutor(-1, 1, sprite);
    }

    @Override
    protected boolean isCollidedByRightBottomAngle(Sprite sprite) {
        return isCollidedByCircleExecutor(1, 1, sprite);
    }

    @Override
    protected boolean isDotInArea(int x, int y) {
        return Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) <= Math.pow(radius, 2);
    }

    @Override
    public void absorb(Sprite sprite) {
        radius = halfHeight = halfWidth = (int) Math.sqrt((getArea() + sprite.getArea()) / Math.PI);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                " / " + halfWidth +
                " / " + halfHeight +
                ", vY=" + vY +
                ", vX=" + vX +
                ", color=" + color +
                '}';
    }
}