package org.academiadecodigo.runners.model;

public enum ObstaclesPicsPath {

    SUPER_BOCK("./resources/images/obstacles/super.png", "GOOD"),
    SQL("./resources/images/obstacles/sql.png", "BAD"),
    JAVA("./resources/images/obstacles/java.png", "BAD");


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
