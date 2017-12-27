package controller;

import action.Move;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 12/Dec/2017 - 13:16
 */
public class ReplayedMatch {
    private int pointer;
    
    private ArrayList<Move> moveHistory;
    
    public ReplayedMatch() {
        moveHistory = new ArrayList<>();
        resetMove();
    }
    
    private ReplayedMatch(ArrayList<Move> moveHistory) {
        this.moveHistory = new ArrayList<>(moveHistory);
        resetMove();
    }
    
    /**
     * copy all history to other object
     *
     * @return this replay match, with new object
     */
    public ReplayedMatch fork() {
        return new ReplayedMatch(this.moveHistory);
    }
    
    /**
     * reset current move to start
     *
     * @return move
     */
    public void resetMove() {
        pointer = 0;
    }
    
    /**
     * get next move
     *
     * @return move
     */
    public Move nextMove() {
        pointer++;
        if (pointer >= moveHistory.size()) return null;
        return getCurrentMove();
    }
    
    /**
     * get previous move
     *
     * @return move
     */
    public Move PreviousMove() {
        pointer--;
        if (pointer < 0) return null;
        return getCurrentMove();
    }
    
    /**
     * recursive all move from start
     */
    public void startReplay() {
        resetMove();
        Move m;
        
        getCurrentMove().show();
        while ((m = nextMove()) != null) {
            m.show();
        }
    }
    
    /**
     * for match, add new move
     *
     * @param move
     */
    protected void addMove(Move move) {
        moveHistory.add(move);
        pointer++;
    }
    
    /**
     * get current move
     *
     * @return move
     */
    private Move getCurrentMove() {
        return moveHistory.get(pointer);
    }
}
