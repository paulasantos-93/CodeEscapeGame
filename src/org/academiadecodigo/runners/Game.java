package org.academiadecodigo.runners;


import org.academiadecodigo.runners.model.*;
import org.academiadecodigo.runners.simplegfx.SimpleGfxGrid;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private SimpleGfxGrid grid;
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
        this.mcs.add(new Mc(McsPicsPath.GUSTAVO, 10, 10, this.player));
        this.mcs.add(new Mc(McsPicsPath.SARA, 210, 10, this.player));
        this.mcs.add(new Mc(McsPicsPath.MARIANA, 410, 10, this.player));
        for (Mc mc : mcs) {
            mc.trowObstacles();
        }

    }

    public void start(){

        while(player.getLives() > 0) {
           this.gameOver = this.mcs.get((int) (Math.random() * 3)).trowObstacles();

        }
    }

    public Player selectPlayer() {
        return new Player(PlayerPicsPath.PAULA);
        //colocar todas as opções de players
    }
}
