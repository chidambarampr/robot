package com.codec;

import com.codec.Robot.Direction;

public class Position {
    private int x;
    private int y;
    private Direction dir;

    public Position() {
        this.x = 1;
        this.y = 1;
        this.dir = Direction.NORTH;
    }

    public Position(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Direction getDir() {
        return dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return this.x + "," + this.y + "," + this.dir;
    }
    
    
}
