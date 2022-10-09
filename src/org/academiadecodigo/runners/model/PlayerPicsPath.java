package org.academiadecodigo.runners.model;

public enum PlayerPicsPath {

    PAULA("./resources/images/players/paula.png", "Paula"),
    ACACIO("", "Acácio"),
    EDUARDO("", "Eduardo"),
    PEDRO("", "Pedro"),
    JOAO("", "João");

    private final String path;

    private final String name;

    PlayerPicsPath(String path, String name){
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
