package org.academiadecodigo.runners;


import org.academiadecodigo.runners.model.*;
import org.academiadecodigo.runners.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_LEFT;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_SPACE;

public class Game{

    private SimpleGfxGrid grid;
    private Player player;

    private Obstacle obstacle;
    List<Mc> mcs;
    private boolean gameRun;

    private Picture gameove;

    private Keyboard keyboard;

    private KeyboardEvent start;

    public Game() {
        this.grid = new SimpleGfxGrid();
    }

    public void init() {


        this.grid.init();
        this.player = new Player();
        this.mcs = new ArrayList<>();
        this.mcs.add(new Mc(McsPicsPath.GUSTAVO, 10, 10, this.player));
        this.mcs.add(new Mc(McsPicsPath.SARA, 210, 10, this.player));
        this.mcs.add(new Mc(McsPicsPath.CAROL, 410, 10, this.player));
        this.mcs.add(new Mc(McsPicsPath.BALJEET, 610, 10, this.player));
        this.mcs.add(new Mc(McsPicsPath.MARIANA, 810, 10, this.player));
        for (Mc mc : mcs) {
            mc.trowObstacles();
        }

    }

    public void start(){

        while(player.getLives() > 0) {
           this.gameRun = this.mcs.get((int) (Math.random() * 5)).trowObstacles();
        }
        if (player.gameOver() == true){
            player.gameOver();
        }
    }

}
