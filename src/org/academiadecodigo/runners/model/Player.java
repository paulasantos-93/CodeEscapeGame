package org.academiadecodigo.runners.model;

import org.academiadecodigo.runners.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import org.academiadecodigo.simplegraphics.graphics.Text;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class Player implements KeyboardHandler {


    private int lives;
    private int score;
    private int limit;


    private Keyboard keyboard;
    private KeyboardEvent key;
    private KeyboardEvent key1;
    private KeyboardEvent l;
    private KeyboardEvent r;

    private KeyboardEvent quit;
    private KeyboardEvent reload;


    private Picture pic;
    private Picture picr;
    private Picture picl;
    private Picture end;
    private Picture heart;
    private Picture heart2;
    private Picture heart3;
    private Picture half;
    private Picture half2;
    private Picture half3;


    private Text scoretxt;
    private Text scoretxtfinal;

    /**
     * When we create a new player will create all the images, that will be drawn for each respective method
     */

    public Player() {
        this.keyboard = new Keyboard(this);

        this.pic = new Picture(435, 740, "./resources/images/players/player_stop resized.png");
        this.picr = new Picture(435, 740, "./resources/images/players/player_right resized.png");
        this.picl = new Picture(435, 740, "./resources/images/players/player_left resized.png");
        this.pic.draw();
        this.limit = 0;
        this.lives = 6;
        this.init();

        this.end = new Picture(10, 10, "resources/images/Gameover2/gameover.jpeg");
        this.heart = new Picture(1010, 10, "./resources/images/lifes/lifes.png");
        this.heart2 = new Picture(1010, 110, "./resources/images/lifes/lifes.png");
        this.heart3 = new Picture(1010, 210, "./resources/images/lifes/lifes.png");
        this.half = new Picture(1010, 10, "./resources/images/lifes/half_heart.png");
        this.half2 = new Picture(1010, 110, "./resources/images/lifes/half_heart.png");
        this.half3 = new Picture(1010, 210, "./resources/images/lifes/half_heart.png");

        this.scoretxt = new Text(1045, 350, "Score: " + getScore());
        this.scoretxt.setColor(Color.WHITE);
        this.scoretxt.grow(10, 10);
        this.scoretxt.draw();

        this.heart.draw();
        this.heart2.draw();
        this.heart3.draw();
        this.half.draw();
        this.half2.draw();
        this.half3.draw();
    }

    /**
     * Start all the Keyboard Listeners for the player movement
     */
    private void init() {
        key = new KeyboardEvent();
        key.setKey(KEY_LEFT);
        key.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key);

        key1 = new KeyboardEvent();
        key1.setKey(KEY_RIGHT);
        key1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key1);

        l = new KeyboardEvent();
        l.setKey(KEY_LEFT);
        l.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(l);

        r = new KeyboardEvent();
        r.setKey(KEY_RIGHT);
        r.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(r);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KEY_LEFT:
                pic.delete();
                picr.delete();
                picl.draw();

                if (this.limit >= -1) {
                    pic.translate(-200, 0);
                    picr.translate(-200, 0);
                    picl.translate(-200, 0);
                    this.limit--;
                }
                break;
            case KEY_RIGHT:
                pic.delete();
                picl.delete();
                picr.draw();

                if (this.limit <= 1) {
                    pic.translate(200, 0);
                    picr.translate(200, 0);
                    picl.translate(200, 0);
                    this.limit++;
                }
                break;
            case KEY_Q:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        picl.delete();
        picr.delete();
        pic.draw();
    }

    /**
     * Gameover method evaluates the lives of the player and deletes hearths every time player loses a live
     *
     * @return
     */

    public boolean gameOver() {


        quit = new KeyboardEvent();
        quit.setKey(KEY_Q);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(quit);


        if (getLives() > 0) {
            return true;

        } else {

            /**
             * To have only the gameover picture showed we remove the eventlistener and delete the player pic
             */

            keyboard.removeEventListener(l);
            keyboard.removeEventListener(r);
            keyboard.removeEventListener(key);
            keyboard.removeEventListener(key1);

            end.draw();
            this.scoretxtfinal = new Text(950, 120, "" + getScore());
            this.scoretxtfinal.setColor(Color.BLACK);
            this.scoretxtfinal.grow(80, 70);
            this.scoretxtfinal.draw();

            return false;
        }
    }

    /**
     * Setters and Getters to literally everything
     *
     * @return
     */

    public Picture getHeart() {
        return heart;
    }

    public Picture getHeart2() {
        return heart2;
    }

    public Picture getHeart3() {
        return heart3;
    }

    public Picture getHalf() {
        return half;
    }

    public Picture getHalf2() {
        return half2;
    }

    public Picture getHalf3() {
        return half3;
    }

    public Text getScoretxt() {
        return scoretxt;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Picture getPic() {
        return pic;
    }
}
