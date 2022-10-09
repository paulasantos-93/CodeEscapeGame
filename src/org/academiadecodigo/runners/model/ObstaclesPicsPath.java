package org.academiadecodigo.runners.model;

public enum ObstaclesPicsPath {

    SUPER_BOCK("./resources/images/players/paula.png", "GOOD"),
    PUFF("", "BAD"),
    BOLA("", "BAD");

    private final String path;
    private final String type;

    ObstaclesPicsPath(String path, String type){
        this.path = path;
        this.type = type;
    }

    public String getPath(){
        return this.path;
    }

    public String getType(){
        return this.type;
    }
}
