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
        this.obstacles = new ArrayList<>();
        this.obstacles.add(new Obstacle(ObstaclesPicsPath.SUPER_BOCK, this.pic.getX(), this.pic.getY() + 100, player));
        //alterar o SUPER_BOCK para um valor random do enum de obstáculos
    }

    private void init() {
        //Criar loop para lançar os objetos usando sleep
        this.trowObstacles();
    }

    public void trowObstacles(){
        //alterar o valor 0 por um random do enum de obstáculos
        this.obstacles.get(0).move();
    }
}
