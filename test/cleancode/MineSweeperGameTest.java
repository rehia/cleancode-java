/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cleancode;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jerome
 */
public class MineSweeperGameTest {
    
    private MineSweeperGame mineSweeper;
    
    public MineSweeperGameTest() {
    }
    
    @Before
    public void setUp() {
        List<int[]> gameBoard = initializeGameBoard();
        mineSweeper = new MineSweeperGame(gameBoard);
    }

    /**
     * Test of GetFgdCells method, of class MineSweeperGame.
     */
    @Test
    public void ShouldGetNoFlaggedCell() {
        List<int[]> flaggedCells = mineSweeper.getFlaggedCells();

        assertThat(flaggedCells.size(), is(equalTo(0)));
    }

    @Test
    public void ShouldGetSomeFlaggedCells() {
        mineSweeper.flagCell(1);
        mineSweeper.flagCell(7);
        mineSweeper.flagCell(9);

        List<int[]> flaggedCells = mineSweeper.getFlaggedCells();

        assertThat(flaggedCells.size(), is(equalTo(3)));
    }
    
    private List<int[]> initializeGameBoard() {
        return new ArrayList<int[]> ()
                   {{
                       add(new int[]{ 1, 6, 5 });
                       add(new int[]{ 3, 2, 1 });
                       add(new int[]{ 1, 3, 1 });
                       add(new int[]{ 3, 7, 4 });
                       add(new int[]{ 1, 4, 5 });
                       add(new int[]{ 3, 1, 6 });
                       add(new int[]{ 1, 5, 3 });
                       add(new int[]{ 1, 6, 2 });
                       add(new int[]{ 1, 2, 7 });
                       add(new int[]{ 1, 7, 6 });
                   }};
    }
}
