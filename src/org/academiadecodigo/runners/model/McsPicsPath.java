package org.academiadecodigo.runners.model;

public enum McsPicsPath {

    GUSTAVO("./resources/images/players/paula.png", "Gustavo"),
    SARA("", "Sara"),
    MARIANA("", "Mariana");

    private final String path;
    private final String name;

    McsPicsPath(String path, String name){
        this.path = path;
        this.name = name;
    }

    public String getPath(){
        return this.path;
    }

    public String getName(){
        return this.name;
    }
}
