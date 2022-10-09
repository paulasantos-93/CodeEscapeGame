package org.academiadecodigo.runners.simplegfx;

import org.academiadecodigo.runners.grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    private Rectangle field;




    @Override
    public void init() {
        this.field = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
    }
}
