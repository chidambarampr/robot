package com.codec;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.codec.Robot.Direction;
import static com.codec.Robot.moveForward;
import static com.codec.Robot.navigate;
import static com.codec.Robot.turnLeft;
import static com.codec.Robot.turnRight;

/**
 * Test Cases for Robot App.
 */
public class RobotTest 
{
    
    // Turn Left Unit Tests 
    @Test
    public void shouldTurnLeft() {
        Position position = new Position();
        assertEquals(Direction.NORTH, position.getDir());
        turnLeft(position);
        assertEquals(Direction.WEST, position.getDir());
        turnLeft(position);
        assertEquals(Direction.SOUTH, position.getDir());
        turnLeft(position);
        assertEquals(Direction.EAST, position.getDir());
        turnLeft(position);
        assertEquals(Direction.NORTH, position.getDir());
    }

    // Turn Left Unit Tests 
    @Test
    public void shouldTurnRight() {
        Position position = new Position();
        assertEquals(Direction.NORTH, position.getDir());
        turnRight(position);
        assertEquals(Direction.EAST, position.getDir());
        turnRight(position);
        assertEquals(Direction.SOUTH, position.getDir());
        turnRight(position);
        assertEquals(Direction.WEST, position.getDir());
        turnRight(position);
        assertEquals(Direction.NORTH, position.getDir());
    }

    // Move Forward Unit Tests when in north direction
    @Test
    public void shouldMoveForwardWhenInNorth() {
        Position position = new Position(3, 3, Direction.NORTH);
        assertEquals(3, position.getX());
        assertEquals(3, position.getY());
        // move forward
        moveForward(position, 5,5);
        assertEquals(3, position.getX());
        assertEquals(4, position.getY());
        // move forward again
        moveForward(position, 5,5);
        assertEquals(3, position.getX());
        assertEquals(5, position.getY());
         // move forward - should not go beyond max
        moveForward(position, 5,5);
        assertEquals(3, position.getX());
        assertEquals(5, position.getY());
    }

    // Move Forward Unit Tests when in north direction
    @Test
    public void shouldMoveForwardWhenInSouth() {
        Position position = new Position(3, 3, Direction.SOUTH);
        assertEquals(3, position.getX());
        assertEquals(3, position.getY());
        // move forward
        moveForward(position, 5,5);
        assertEquals(3, position.getX());
        assertEquals(2, position.getY());
        // move forward again
        moveForward(position, 5,5);
        assertEquals(3, position.getX());
        assertEquals(1, position.getY());
         // move forward - should not go beyond 1
        moveForward(position, 5,5);
        assertEquals(3, position.getX());
        assertEquals(1, position.getY());
    }

    // Move Forward Unit Tests when in north direction
    @Test
    public void shouldMoveForwardWhenInEast() {
        Position position = new Position(3, 3, Direction.EAST);
        assertEquals(3, position.getX());
        assertEquals(3, position.getY());
        // move forward
        moveForward(position, 5,5);
        assertEquals(4, position.getX());
        assertEquals(3, position.getY());
        // move forward again
        moveForward(position, 5,5);
        assertEquals(5, position.getX());
        assertEquals(3, position.getY());
         // move forward - should not go beyond max
        moveForward(position, 5,5);
        assertEquals(5, position.getX());
        assertEquals(3, position.getY());
    }

    // Move Forward Unit Tests when in north direction
    @Test
    public void shouldMoveForwardWhenInWest() {
        Position position = new Position(3, 3, Direction.WEST);
        assertEquals(3, position.getX());
        assertEquals(3, position.getY());
        // move forward
        moveForward(position, 5,5);
        assertEquals(2, position.getX());
        assertEquals(3, position.getY());
        // move forward again
        moveForward(position, 5,5);
        assertEquals(1, position.getX());
        assertEquals(3, position.getY());
         // move forward - should not go beyond 1
        moveForward(position, 5,5);
        assertEquals(1, position.getX());
        assertEquals(3, position.getY());
    }

    // Sample Integration Test
    @Test
    public void shouldNavigateAsExpected() {
        Position position = new Position();
        navigate("FFRFLFLF", 5, 5, position);
        assertEquals("1,4,WEST", position.toString());
    }

}
