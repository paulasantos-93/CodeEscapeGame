package org.academiadecodigo.runners.model;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    private Picture pic;
    private int limit;
    private ObstaclesPicsPath path;
    private int col;
    private int row;
    private Player player;

    public Obstacle(ObstaclesPicsPath path, int col, int row, Player player) {
        this.path = path;
        this.col = col;
        this.row = row;
        this.limit = 3;
        this.player = player;
    }

    public void move() {
        this.pic = new Picture(col, row, path.getPath());
        this.pic.draw();

        int i = 0;

        while(i <= limit) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pic.translate(0, -220);
            /*verificar se colidiu com o player (posição do player = obstáculo) se colidiu e o obstáculo for do tipo
            GOOD aumenta score do Player, se for obstáculo BAD perde vidas do Player */
            i++;
        }
        this.pic.delete();
    }

    public Picture getPic() {
        return pic;
    }
}
