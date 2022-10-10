package org.academiadecodigo.runners;

import org.academiadecodigo.runners.grid.Grid;
import org.academiadecodigo.runners.model.*;
import org.academiadecodigo.runners.simplegfx.SimpleGfxGrid;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Grid grid;
    private Player player;

    private Obstacle obstacle;
    List<Mc> mcs;
    private boolean gameOver;

    public Game() {
        this.grid = new SimpleGfxGrid();
    }

    public void init() {
        this.grid.init();
        this.player = this.selectPlayer();
        this.mcs = new ArrayList<>();
        this.mcs.add(new Mc(McsPicsPath.GUSTAVO, 490, 50, this.player));
        this.mcs.add(new Mc(McsPicsPath.GUSTAVO, 690, 50, this.player));
        this.mcs.add(new Mc(McsPicsPath.GUSTAVO, 890, 50, this.player));
        for (Mc mc : mcs) {
            mc.trowObstacles();
        }

    }

    public void start(){

        while(!this.gameOver) {
           this.gameOver = this.mcs.get((int) (Math.random() * 3)).trowObstacles();

        }
    }

    public Player selectPlayer() {
        return new Player(PlayerPicsPath.PAULA);
        //colocar todas as opções de players
    }
}
