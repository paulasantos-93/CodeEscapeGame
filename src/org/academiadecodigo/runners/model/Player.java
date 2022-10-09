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
    private Keyboard keyboard;
    private int limit;

    public Player(PlayerPicsPath path) {
        this.keyboard = new Keyboard(this);
        this.pic = new Picture(490, 350, path.getPath());
        this.pic.draw();
        this.name = path.getName();
        this.limit = 0;
        this.lives = 3;
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
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (this.limit >= 0) {
                    pic.translate(-100, 0);
                    this.limit--;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (this.limit <= 0) {
                    pic.translate(100, 0);
                    this.limit++;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
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
