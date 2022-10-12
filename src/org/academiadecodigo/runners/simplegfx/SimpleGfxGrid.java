package org.academiadecodigo.runners.simplegfx;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid {

    public static final int PADDING = 10;
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 900;
    private Rectangle field;

    private Rectangle life;



    public void init() {
        this.field = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        field.setColor(Color.RED);
        field.fill();
        this.life = new Rectangle (1010,10,100,900);
        life.setColor(Color.BLACK);
        life.fill();
    }
}
