package br.com.deno.sudoku.service;

import br.com.deno.sudoku.model.Board;
import br.com.deno.sudoku.model.Cell;
import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    private void initGame(Board board) {
        board.getCells().stream().forEach(c -> c.fillNumbers());
    }

    public void solveGame(Board board) {
        initGame(board);
        List<Cell> notDef = new ArrayList<>();
        notDef.addAll(board.getCells().stream().filter(c-> !c.isDef()).toList());
        List<Cell> defs = new ArrayList<>();
        while (!notDef.isEmpty()) {
            for(Cell c : notDef) {
                int index = board.getCells().indexOf(c);
                int lineIndex = board.getLineIndex(index);
                int colIndex = board.getColIndex(index);
                int sqrIndex = board.getSquareIndex(index);
                
                List<Cell> line = board.getLine(lineIndex);
                List<Cell> col = board.getColumn(colIndex);
                List<Cell> square = board.getSquare(sqrIndex);
                
                removeDefsInList(line, c);
                removeDefsInList(col, c);
                removeDefsInList(square, c);
                if(c.isDef()){
                    defs.add(c);
                }
             }
            notDef.removeAll(defs);
            defs.clear();
        }
    }
    
   private void removeDefsInList(List<Cell> l, Cell c){
       l.remove(c);
       l.stream().filter(ce->ce.isDef()).map(ce -> ce.getNumbers().get(0)).forEach(n -> c.removeNumber(n));
   }

}
