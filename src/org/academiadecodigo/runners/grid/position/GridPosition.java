package org.academiadecodigo.runners.grid.position;

public interface GridPosition {

    int getCol();

    int getRow();

    void setPos(int col, int row);

    boolean equals(GridPosition position);


}
