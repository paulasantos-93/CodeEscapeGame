package org.academiadecodigo.runners;


import org.academiadecodigo.runners.model.*;
import org.academiadecodigo.runners.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_R;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_SPACE;

public class Game implements KeyboardHandler{

    private SimpleGfxGrid grid;
    private Player player;

    List<Mc> mcs;
    private boolean gameRun;


    private Keyboard keyboard;

    private Picture startPic;

    private KeyboardEvent start;

    private KeyboardEvent reStart;

    private  boolean test = true;

    private boolean startGame;



    public Game() {
        this.grid = new SimpleGfxGrid();
    }

    public void init() {

        SoundHandler.RunMusic("./resources/Sounds/main.wav");

        /**
         * We need to expect keyboard input to start effectively the game
         */
        keyboard = new Keyboard(this);
        start = new KeyboardEvent();
        start.setKey(KEY_SPACE);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(start);


        while (test) {
            initialMenu();
        }
        start2();
    }
        /**The game will start now, after space is pressed test value will be false.
         * The start picture will be deleted and the Keyboard event removedˇ
         */
     public void start2(){

         startPic.delete();
        keyboard.removeEventListener(start);
        this.grid.init();
        this.player = new Player();
        this.mcs = new ArrayList<>();
        this.mcs.add(new Mc(McsPicsPath.GUSTAVO, 10, 10, this.player));
        this.mcs.add(new Mc(McsPicsPath.SARA, 210, 10, this.player));
        this.mcs.add(new Mc(McsPicsPath.CAROL, 410, 10, this.player));
        this.mcs.add(new Mc(McsPicsPath.BALJEET, 610, 10, this.player));
        this.mcs.add(new Mc(McsPicsPath.MARIANA, 810, 10, this.player));


         /**
          * The spot to be of start method
          */
        start();
        /* reStart = new KeyboardEvent();
         reStart.setKey(KEY_R);
         reStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
         keyboard.addEventListener(reStart);*/
    }

    /**
     * Game will run while player lives > 0 , then the game over method will be evoked
     */

    public void start(){
        while(player.getLives() > 0) {
           this.gameRun = this.mcs.get((int) (Math.random() * 5)).trowObstacles();
        }
        if (player.gameOver()){
            player.gameOver();
        }

    }

    /**
     * Method that will draw the initial picture known as The Entrance Of The Game
     */
    public void initialMenu(){
        startPic = new Picture(10, 10, "resources/images/Background/start.png");
        startPic.draw();
    }

    /**
     * Actualizing test to false just to make the game Start
     * @param keyboardEvent
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KEY_SPACE :
                 setTest(false);
                break;

        }
    }

    /**
     * Doing the same thing just to make sure it works
     * @param keyboardEvent
     */

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KEY_SPACE:
                setTest(true);
        }
    }

    /**
     * Easiest way to actualize test value
     * @param test
     */

    public void setTest(boolean test) {
        this.test = test;
    }
}



