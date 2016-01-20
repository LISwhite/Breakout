/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 500;	

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;


	public void run() {
		addTestRect();
        int cx = WIDTH /2;
		int cy = BRICK_Y_OFFSET + (BRICK_HEIGHT * NBRICK_ROWS /2) + (BRICK_SEP * NBRICK_ROWS / 2) - BRICK_SEP /2;
        addBricks(cx, cy);
        addPaddle();
        addMouseListeners();
	}
	
	private void addBricks(int cx, int cy) {
		for (int i = 0; i < NBRICK_ROWS; i++) {
			for ( int j = 0; j < NBRICKS_PER_ROW; j++) {
				addBrick(cx, cy, i);
				cx += BRICK_WIDTH + BRICK_SEP;
				pause(30);
			}
			cy += BRICK_HEIGHT + BRICK_SEP;
			cx = WIDTH / 2;
		}
	}
	
	// Insane math involved
	private void addBrick (int cx, int cy, int i) {
		int x = cx - BRICK_WIDTH * (NBRICKS_PER_ROW / 2) + BRICK_WIDTH /2 - BRICK_SEP * (NBRICKS_PER_ROW / 2) + BRICK_SEP /2;
		int y = cy - BRICK_HEIGHT * (NBRICK_ROWS / 2) + BRICK_HEIGHT /2 - BRICK_SEP * (NBRICK_ROWS / 2) + BRICK_SEP /2;
		GRect brick = new GRect(x - BRICK_WIDTH / 2, y + BRICK_HEIGHT / 2, BRICK_WIDTH, BRICK_HEIGHT);
		brick.setFilled(true);
		paintBrick(brick, i);
		add(brick);
	}
	
	//How it works?
	public void initor() {
		int PAUSE = 10;
		this.resize(WIDTH*2,HEIGHT);
        pause(PAUSE);
	}
	
	private void paintBrick(GObject brick, int i) {
		if (i < 2 * (NBRICK_ROWS / 10)) {
			brick.setColor(Color.RED);
		} else if (i < (4 * (NBRICK_ROWS / 10))) {
			brick.setColor(Color.ORANGE);
		} else if (i < (6 * (NBRICK_ROWS / 10))) {
			brick.setColor(Color.YELLOW);
 		} else if (i < (8 * (NBRICK_ROWS / 10))) {
 			brick.setColor(Color.GREEN);
 		} else if (i < (10 * (NBRICK_ROWS / 10))) {
 			brick.setColor(Color.CYAN);
 		}
	}
	
	private void addTestRect() {
		GRect test_rect = new GRect(0, 0, WIDTH, HEIGHT);
        test_rect.setFilled(true);
        add(test_rect);
	}
	
	
	private void addPaddle(){
        int cx = WIDTH /2;
		GRect paddle = new GRect(cx, (HEIGHT - PADDLE_Y_OFFSET), PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setColor(Color.CYAN);
		add(paddle);
	}
	

}
