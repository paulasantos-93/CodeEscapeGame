package org.academiadecodigo.runners.model;

public enum ObstaclesPicsPath {

    SUPER_BOCK("./resources/images/obstacles/super.bock.png", "GOOD"),
    PUFF_VERDE("./resources/images/obstacles/puff.verde.jpeg", "BAD"),
    BOLA_PILATES("./resources/images/obstacles/bola.pilates.png", "BAD");


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
