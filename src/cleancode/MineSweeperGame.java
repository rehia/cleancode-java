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

    private List<int[]> theList;

    public MineSweeperGame(List<int[]> theList) {
        this.theList = theList;
    }

    public List<int[]> GetFgdCells() {
        List<int[]> list1 = new ArrayList<int[]>();
        for (int[] x : theList) {
            if (x[0] == 4) {
                list1.add(x);
            }
        }
        return list1;
    }

    public void Flg(int id) {
        theList.get(id)[0] = 4;
    }
}
