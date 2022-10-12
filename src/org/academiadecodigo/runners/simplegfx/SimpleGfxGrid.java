package org.academiadecodigo.runners.simplegfx;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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

        Text txt = new Text(1025, 400, "CATCH THIS:");
        txt.setColor(Color.WHITE);
        txt.grow(10,10);
        txt.draw();

        Picture min1 = new Picture(1010, 420, "./resources/images/miniatures/beer.png");
        min1.draw();
        Picture min2 = new Picture(1050, 420, "./resources/images/miniatures/weed.png");
        min2.draw();


    }
}
