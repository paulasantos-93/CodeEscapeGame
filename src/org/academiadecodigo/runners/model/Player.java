package org.academiadecodigo.runners.model;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler {

    private String name;
    private int lives;
    private int score;
    private Picture pic;
    private Picture picr;
    private Picture picl;
    private Keyboard keyboard;
    private int limit;

    public Player(PlayerPicsPath path) {
        this.keyboard = new Keyboard(this);
        this.pic = new Picture(235, 636, "./resources/images/players/player_stop (1).png");
        this.picr= new Picture(235, 636, "./resources/images/players/player_right (1).png");
        this.picl= new Picture(235, 636, "./resources/images/players/player_left (1).png");
        this.pic.draw();
        this.name = path.getName();
        this.limit = 0;
        this.lives = 4;
        this.init();
    }
    private void init() {
        KeyboardEvent key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_LEFT);
        key.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_RIGHT);
        key.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(key);

        KeyboardEvent l = new KeyboardEvent();
        l.setKey(KeyboardEvent.KEY_LEFT);
        l.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent r = new KeyboardEvent();
        r.setKey(KeyboardEvent.KEY_RIGHT);
        r.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(l);
        keyboard.addEventListener(r);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                pic.delete();
                picr.delete();
                picl.draw();
                if (this.limit >= 0) {
                    pic.translate(-200, 0);
                    picr.translate(-200, 0);
                    picl.translate(-200, 0);
                    this.limit--;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                pic.delete();
                picl.delete();
                picr.draw();
                if (this.limit <= 0) {
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

}
