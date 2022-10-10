package org.academiadecodigo.runners.model;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class Mc {

    private String name;
    private List<Obstacle> obstacles;
    private Picture pic;
    private Player player;

    public Mc(McsPicsPath path, int col, int row, Player player) {
        this.pic = new Picture(col, row, path.getPath());
        this.name = path.getName();
        this.pic.draw();
        this.player = player;
        this.obstacles = new ArrayList<>();
        this.obstacles.add(new Obstacle(ObstaclesPicsPath.values()[(int) (Math.random() * 3)], this.pic.getX(), this.pic.getY() + 100, this.player));

    }

    private void init() {
        //Criar loop para lançar os objetos usando sleep
        this.trowObstacles();
    }

    public boolean trowObstacles(){
        //alterar o valor 0 por um random do enum de obstáculos
        return this.obstacles.get(0).move();
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
}
