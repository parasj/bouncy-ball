package processing.test.testapp;

import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class TestApp extends PApplet {

    private int xPos;
    private int speed = 0;
    private int xDir = 1; //what direction is the ball going?
    private int score = 0; //Inital score
    private int lives = 1; //Number of lives you start with
    private boolean lost = false; //Have you lost yet?
    private int speedDelta = sketchWidth()/400;

    public void setup() //Runs once when program launches
    {
        speedDelta = Math.max(sketchWidth()/300, 1);

        smooth();
        noStroke();
        xPos = width / 2; //Centers our ball
        fill(255, 255, 255); //Makes the ball and text green
        textSize(20*sketchWidth()/400); //Sets the size of our text
        String[] fontList = PFont.list();
        println(fontList);
    }

    public void draw() //Loops over and over again
    {
        background(0); //Black background
        ellipse(xPos, height / 2, 60*sketchWidth()/400, 60*sketchWidth()/400); //Draw the ball
        xPos = xPos + (speed * xDir); //update the ball's position
        text("score = " + score, 10, (int) (20 * (sketchWidth()/400.0))); //Print the score on the screen
        text("lives = " + lives, width - (int) (100 * (sketchWidth()/400.0)), (int) (20 * (sketchWidth()/400.0))); //Print remaining lives
        if (lives <= 0 || xPos > width - 20 || xPos < 20) //Check to see if you lost
        {
            textSize(40*sketchWidth()/400);
            textAlign(CENTER);
            text("Click to Restart", sketchWidth()/2, sketchHeight()/3);
            textAlign(LEFT);
            noLoop(); //Stop looping at the end of the draw function
            lost = true;
            textSize(20*sketchWidth()/400);
        }
    }

    public void mousePressed() //Runs whenever the mouse is pressed
    {
        //xprint("(" + mouseX + "  " + mouseY + ")..." + xPos + "  " + 400);
        if (dist(mouseX, mouseY, xPos, sketchHeight()/2) <= 60*sketchWidth()/400) //Did we hit the target?
        {
            xDir = -xDir;
            score = score + speed; //Increase the speed
            speed = speed + speedDelta; //Increase the Score
        } else //We missed
        {
            if (speed > 1) //If speed is greater than 1 decrease the speed
            {
                speed = speed - speedDelta;
            }
            lives = lives - 1; //Take away one life
        }
        if (lost) //If we lost the game, reset now and start over
        {
            speed = 1; //Reset all variables to initial conditions
            lives = 5;
            score = 0;
            xPos = width / 2;
            xDir = 1;
            lost = false;
            loop(); //Begin looping draw function again
        }
    }

    public int sketchWidth() {
        return displayWidth;
    }
    public int sketchHeight() {
        return displayHeight;
    }
}