package org.academiadecodigo.runners.model;

public enum McsPicsPath {

    GUSTAVO("./resources/images/mcs/guga.png", "Gustavo"),
    SARA("./resources/images/mcs/sara.png", "Sara"),
    MARIANA("./resources/images/mcs/mariana.png", "Mariana"),

    BALJEET( "./resources/images/mcs/baljeet.png", "Baljeet"),

    CAROL("./resources/images/mcs/carol.png", "Carol");

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
