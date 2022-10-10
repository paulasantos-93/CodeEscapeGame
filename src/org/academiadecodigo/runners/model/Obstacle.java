package org.academiadecodigo.runners.model;

import org.academiadecodigo.runners.grid.position.GridPosition;
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
        this.limit = 7;
        this.player = player;
    }

    public boolean move() {
        this.pic = new Picture(col, row, path.getPath());
        this.pic.draw();

        int i = 0;

        while(i <= limit) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pic.translate(0, 100);

            if (checkCollision()) {
                if(path.getType().equals("GOOD")) {
                    player.setScore(player.getScore() + 1);
                } else {
                    player.setLives(player.getLives() - 1);
                    if(player.getLives() < 1) {
                        return false;
                    }
                    }
                }
            i++;
            }
        this.pic.delete();
        return true;
        }


    public boolean checkCollision() {
        return pic.getX() == player.getPic().getX() && pic.getY() >= player.getPic().getY();
    }


}
