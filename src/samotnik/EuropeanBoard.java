/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

/**
 *
 * @author BRudzki
 */
public class EuropeanBoard extends GameBoard {

    public EuropeanBoard(GamePanel parent) {
        super(parent);
    }
    
    @Override
    protected void fillBoard() {
        for(int i=0;i<SIZE;i++)
            for(int j=2;j<=4;j++){
                board[i][j] = new BoardCell(parent,i,j);
                board[j][i] = new BoardCell(parent,j,i);
            }
        board[1][1] = new BoardCell(parent,1,1);
        board[1][5] = new BoardCell(parent,1,5);
        board[5][1] = new BoardCell(parent,5,1);
        board[5][5] = new BoardCell(parent,5,5);
        board[3][3].deletePawn();
    }
    
    
}
