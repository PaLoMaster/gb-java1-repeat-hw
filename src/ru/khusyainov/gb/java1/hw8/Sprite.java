package ru.khusyainov.gb.java1.hw8;

import java.awt.*;

abstract class Sprite {

    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;
    protected float vY;
    protected float vX;

    abstract public void update(float deltaTime);

    abstract public void render(Graphics g);

    float getLeft(){ return x - halfWidth; }

    void setLeft(float left){ x = left + halfWidth; }

    float getRight(){ return x + halfWidth; }

    void setRight(float right){ x = right - halfWidth;}

    float getTop(){ return y - halfHeight; }

    void setTop(float top){ y = top + halfHeight; }

    float getBottom(){ return y + halfHeight; }

    void setBottom(float bottom){ y = bottom - halfHeight; }

    float getWidth(){ return 2f * halfWidth; }

    float getHeight(){return 2f * halfHeight; }

    void revertVx() { this.vX = -this.vX; }

    void revertVy() { this.vY = -this.vY; }
}