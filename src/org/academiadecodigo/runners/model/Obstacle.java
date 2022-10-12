package org.academiadecodigo.runners.model;


import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {

    private Picture pic;
    private double limit;
    private ObstaclesPicsPath path;
    private int col;
    private int row;
    private Player player;

    private int speed = 70;



    public Obstacle(ObstaclesPicsPath path, int col, int row, Player player) {
        this.path = path;
        this.col = col;
        this.row = row;
        this.limit = 12;
        this.player = player;

    }

    public boolean move() {
        this.pic = new Picture(col, row, path.getPath());
        this.pic.draw();
        int i = 0;

        while(i <= limit) {


            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pic.translate(0, 40);

            //System.out.println(pic.getX() + " this is object");
            //System.out.println(pic.getY() + " this is object");

            //System.out.println(player.getPic().getX());
            //System.out.println(player.getPic().getY());
            if (checkCollision()) {
                if(path.getType().equals("GOOD")) {
                    this.pic.delete();
                    player.setScore(player.getScore() + 1);


                    player.getScoretxt().setText("Score :" + player.getScore());

                    System.out.println("score " + player.getScore());
                } else {
                    this.pic.delete();
                    player.setLives(player.getLives() - 1);


                    if (player.getLives() == 5) {
                        player.getHeart3().delete();
                    } else if (player.getLives() == 4) {
                        player.getHalf3().delete();
                    } else if (player.getLives() == 3) {
                        player.getHeart2().delete();
                    } else if (player.getLives() == 2) {
                        player.getHalf2().delete();;
                    } else if (player.getLives() == 1) {
                        player.getHeart().delete();
                    } else{
                        player.getHalf().delete();
                    }




                    System.out.println("lives " + player.getLives());
                    if(player.getLives() < 1) {
                        return false;
                    }
                }
            }
            /*if (player.getScore() == 5 ){
                this.speed -= 40;
            }*/

            i++;
            }
        this.pic.delete();
        return true;
        }

    public boolean checkCollision() {
        if ((pic.getY()  == player.getPic().getY()) && (pic.getX() == (player.getPic().getX() + 25))){
            return true;
        }
        return false;


    }


}
