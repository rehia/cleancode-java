/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleancode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jerome
 */
public class MineSweeperGame {

    private List<int[]> gameBoard;

    public MineSweeperGame(List<int[]> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<int[]>();
        for (int[] cell : gameBoard) {
            if (cell[CELL_STATUS] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
    private static final int FLAGGED = 4;
    private static final int CELL_STATUS = 0;

    public void flagCell(int id) {
        gameBoard.get(id)[CELL_STATUS] = FLAGGED;
    }
}
