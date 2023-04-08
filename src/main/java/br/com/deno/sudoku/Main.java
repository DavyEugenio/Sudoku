package br.com.deno.sudoku;

import br.com.deno.sudoku.model.Board;
import br.com.deno.sudoku.model.Cell;
import br.com.deno.sudoku.service.Sudoku;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();
        b.defCell(0, 9);
        b.defCell(3, 4);
        b.defCell(6, 6);
        b.defCell(7,5);
        b.defCell(10, 3);
        b.defCell(12, 2);
        b.defCell(13, 5);
        b.defCell(17, 9);
        b.defCell(20, 4);
        b.defCell(23, 7);
        b.defCell(24, 2);
        b.defCell(26,3);
        b.defCell(27, 4);
        b.defCell(28, 1);
        b.defCell(33, 5);
        b.defCell(37, 7);
        b.defCell(43, 4);
        b.defCell(47, 8);
        b.defCell(52, 9);
        b.defCell(53, 2);
        b.defCell(54, 8);
        b.defCell(56, 2);
        b.defCell(57, 3);
        b.defCell(60, 1);
        b.defCell(63, 7);
        b.defCell(67, 2);
        b.defCell(68, 1);
        b.defCell(70, 8);
        b.defCell(73, 5);
        b.defCell(74, 3);
        b.defCell(77, 4);
        b.defCell(80, 7);
        
        Sudoku game = new Sudoku();
        game.solveGame(b);
        int col = 0;
        for(Cell c : b.getCells()) {
            if(col == 9) {
                System.out.println();
                col = 0;
            }
            System.out.print(c.getNumbers().get(0) + " - ");
            col++;
        }
    }
}
