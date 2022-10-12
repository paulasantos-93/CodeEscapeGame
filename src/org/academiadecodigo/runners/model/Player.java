package org.academiadecodigo.runners.model;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import org.academiadecodigo.simplegraphics.graphics.Text;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class Player implements KeyboardHandler {

    private String name;
    private int lives;
    private int score;
    private Picture pic;
    private Picture picr;
    private Picture picl;
    private Keyboard keyboard;
    private Picture gameove;
    private int limit;
    private KeyboardEvent key;

    private KeyboardEvent key1;
    private KeyboardEvent l;

    private KeyboardEvent r;


    private Picture heart;
    private Picture heart2;
    private Picture heart3;
    private Picture half;
    private Picture half2;
    private Picture half3;

    private Text scoretxt;




    public Player() {
        this.keyboard = new Keyboard(this);
        //alterado posicao
        this.pic = new Picture(435, 740, "./resources/images/players/player_stop resized.png");
        this.picr= new Picture(435, 740, "./resources/images/players/player_right resized.png");
        this.picl= new Picture(435, 740, "./resources/images/players/player_left resized.png");
        this.pic.draw();
        this.limit = 0;
        this.lives = 6;
        this.init();


        this.heart = new Picture(1010, 10, "./resources/images/lifes/lifes.png");
        this.heart2 = new Picture(1010, 110, "./resources/images/lifes/lifes.png");
        this.heart3 = new Picture(1010, 210, "./resources/images/lifes/lifes.png");
        this.half = new Picture(1010, 10, "./resources/images/lifes/half_heart.png");
        this.half2 = new Picture(1010, 110, "./resources/images/lifes/half_heart.png");
        this.half3 = new Picture(1010, 210, "./resources/images/lifes/half_heart.png");

        this.scoretxt = new Text(1045, 350, "Score: " + getScore());
        this.scoretxt.setColor(Color.WHITE);
        this.scoretxt.grow(10,10);
        this.scoretxt.draw();

        this.heart.draw();
        this.heart2.draw();
        this.heart3.draw();
        this.half.draw();
        this.half2.draw();
        this.half3.draw();


    }
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

        r = new KeyboardEvent();
        r.setKey(KEY_RIGHT);
        r.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(l);
        keyboard.addEventListener(r);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KEY_LEFT:
                pic.delete();
                picr.delete();
                picl.draw();
                //alterado
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
                //aterado
                if (this.limit <= 1) {
                    pic.translate(200, 0);
                    picr.translate(200, 0);
                    picl.translate(200, 0);
                    this.limit++;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        picl.delete();
        picr.delete();
        pic.draw();
    }


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

    public Picture getPic(){
        return pic;
    }

    public boolean gameOver() {


        if (getLives() > 0) {


            this.heart.draw();
            this.heart2.draw();
            this.heart3.draw();
            this.half.draw();
            this.half2.draw();
            this.half3.draw();


            if (this.getLives() == 5) {
                heart3.delete();
            } else if (this.getLives() == 4) {
                half3.delete();
            } else if (this.getLives() == 3) {
                heart2.delete();
            } else if (this.getLives() == 2) {
                half2.delete();;
            } else if (this.getLives() == 1) {
                heart.delete();
            } else{
                half.delete();
            }



            return true;
        } else {
            keyboard.removeEventListener(l);
            keyboard.removeEventListener(r);
            keyboard.removeEventListener(key);
            keyboard.removeEventListener(key1);
            pic.delete();
            picl.delete();
            picr.delete();
            this.gameove = new Picture(10,10,"resources/images/Gameover/gameover.png");
            gameove.draw();
            return false;
        }
    }
}
