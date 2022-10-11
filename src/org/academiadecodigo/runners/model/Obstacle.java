package org.academiadecodigo.runners.model;


import org.academiadecodigo.simplegraphics.graphics.Text;
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
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pic.translate(0, 50);

            //System.out.println(pic.getX() + " this is object");
            //System.out.println(pic.getY() + " this is object");

            //System.out.println(player.getPic().getX());
            //System.out.println(player.getPic().getY());
            if (checkCollision()) {
                if(path.getType().equals("GOOD")) {
                    this.pic.delete();
                    player.setScore(player.getScore() + 1);
                    System.out.println("score " + player.getScore());
                } else {
                    this.pic.delete();
                    player.setLives(player.getLives() - 1);
                    System.out.println("lives " + player.getLives());
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
        if ((pic.getY() == player.getPic().getY()) && (pic.getX() == player.getPic().getX())){
            return true;
        }
        return false;


    }


}
