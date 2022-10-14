package org.academiadecodigo.runners.model;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class Mc {

    private String name;
    private List<Obstacle> obstacles;
    private Picture picMc;
    private Player player;

    public Mc(McsPicsPath path, int col, int row, Player player) {
        this.picMc = new Picture(col, row, path.getPath());
        this.name = path.getName();
        this.picMc.draw();
        this.player = player;
        this.obstacles = new ArrayList<>();
        this.obstacles.add(new Obstacle(ObstaclesPicsPath.values()[0], this.picMc.getX()+50, this.picMc.getY() + 210, this.player));
        this.obstacles.add(new Obstacle(ObstaclesPicsPath.values()[1], this.picMc.getX()+50, this.picMc.getY() + 210, this.player));
        this.obstacles.add(new Obstacle(ObstaclesPicsPath.values()[2], this.picMc.getX()+50, this.picMc.getY() + 210, this.player));
        this.obstacles.add(new Obstacle(ObstaclesPicsPath.values()[3], this.picMc.getX()+50, this.picMc.getY() + 210, this.player));
        this.obstacles.add(new Obstacle(ObstaclesPicsPath.values()[4], this.picMc.getX()+50, this.picMc.getY() + 210, this.player));
    }

    public boolean trowObstacles(){
        return this.obstacles.get((int) (Math.random() * 5)).move();
    }
}
