package com.codec;

import java.util.Scanner;

/**
 * Mars Robot
 *
 */
public class Robot 
{
    public static void main(String[] args) {   

        // input 
        String grid;
        String command;
        try (Scanner reader = new Scanner(System.in)) {
            System.out.print("\nPlease enter the grid size of Mars Plateau: ");
            grid = reader.next();
            System.out.print("\nPlease enter the commands (please right click to paste): ");
            command = reader.next();
        }
        int xMax = grid.charAt(0) - '0';
        int yMax = grid.charAt(2)- '0';

        // output init
        Position finalPosition = new Position();

        // navigate
        navigate(command, xMax, yMax, finalPosition);

        // display result
        System.out.println("\nFinal position of the robot = "+ finalPosition + "\n");
        
    }

    public static void navigate(String command, int xMax, int yMax, Position finalPosition) {
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
                case 'L': turnLeft(finalPosition); break;
                case 'R': turnRight(finalPosition); break;
                case 'F': moveForward(finalPosition, xMax, yMax); break;
                default: break; // do nothing
            }
        }
    }

    public static void turnLeft(Position currentPosition) {
        Direction d = null;
        switch (currentPosition.getDir()) {
            case NORTH: d = Direction.WEST; break;
            case WEST: d = Direction.SOUTH; break;
            case SOUTH: d = Direction.EAST; break;
            case EAST: d = Direction.NORTH; break;
        }
        currentPosition.setDir(d);
    }

    public static void turnRight(Position currentPosition) {
        Direction d = null;
        switch (currentPosition.getDir()) {
            case NORTH: d = Direction.EAST; break;
            case WEST: d = Direction.NORTH; break;
            case SOUTH: d = Direction.WEST; break;
            case EAST: d = Direction.SOUTH; break;
        }
        currentPosition.setDir(d);
    }

    public static void moveForward(Position currentPosition, int xMax, int yMax) {
        switch (currentPosition.getDir()) {
            case NORTH: currentPosition.setY(currentPosition.getY()+1 > yMax ? currentPosition.getY(): currentPosition.getY()+1); break;
            case WEST: currentPosition.setX(currentPosition.getX()-1 <= 0 ? currentPosition.getX(): currentPosition.getX()-1); break;
            case SOUTH: currentPosition.setY(currentPosition.getY()-1 <= 0 ? currentPosition.getY() : currentPosition.getY()-1); break;
            case EAST: currentPosition.setX(currentPosition.getX()+1 > xMax ? currentPosition.getX() : currentPosition.getX()+1); break;
        }
    }

    public enum Direction {
        NORTH, EAST, SOUTH, WEST
    }
}
