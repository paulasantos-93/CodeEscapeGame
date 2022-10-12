package org.academiadecodigo.runners.model;

public enum ObstaclesPicsPath {

    SUPER_BOCK("./resources/images/obstacles/beer.png", "GOOD"),
    JAVASCRIPT("./resources/images/obstacles/javascript.png", "BAD"),
    WEED("./resources/images/obstacles/weed.png", "GOOD"),
    JAVA("./resources/images/obstacles/java.png", "BAD"),
    CMAIS("./resources/images/obstacles/c++.png", "BAD");



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
