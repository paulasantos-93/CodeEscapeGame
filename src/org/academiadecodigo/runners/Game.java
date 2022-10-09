package org.academiadecodigo.runners;

import org.academiadecodigo.runners.grid.Grid;
import org.academiadecodigo.runners.model.Mc;
import org.academiadecodigo.runners.model.McsPicsPath;
import org.academiadecodigo.runners.model.Player;
import org.academiadecodigo.runners.model.PlayerPicsPath;
import org.academiadecodigo.runners.simplegfx.SimpleGfxGrid;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Grid grid;

    private Player player;

    private CollisionDetector collisionDetector;

    List<Mc> mcs;
    private boolean gameOver;

    public Game() {
        this.grid = new SimpleGfxGrid();
    }

    public void init() {
        this.collisionDetector = new CollisionDetector();
        this.mcs = new ArrayList<>();
        this.mcs.add(new Mc(McsPicsPath.GUSTAVO, 490, 50, this.player));
        this.mcs.add(new Mc(McsPicsPath.GUSTAVO, 690, 50, this.player));
        this.mcs.add(new Mc(McsPicsPath.GUSTAVO, 890, 50, this.player));
        for (Mc mc : mcs) {
            mc.trowObstacles();
        }
        this.grid.init();
    }

    public void start(){
        this.player = this.selectPlayer();

        while(!this.gameOver) {
            this.mcs.get((int) Math.random() * 3).trowObstacles();
        }
    }

    public Player selectPlayer() {
        return new Player(PlayerPicsPath.PAULA);
    }

    public boolean setGameOver() {
        return true;
    }
}
