package controller;

import action.Move;
import logic.Logic;
import object.Player;
import view.GameBoard;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 12/Dec/2017 - 13:15
 */
public class Match {
    ReplayedMatch match;
    private GameBoard.SupportGame game;
    
    private Logic logic;
    
    public Match(GameBoard.SupportGame gameType, int row, int col, Player... args) {
        match = new ReplayedMatch();
        
        this.game = gameType;
        
        logic = this.game.getLogic();
        logic.setBoard(row, col);
        logic.addPlayer(args);
        logic.renderBoard();
    }
    
    /**
     * play game xx turn
     */
    public void play() {
        while (!logic.isFinish()) {
            System.out.println("current player: " + logic.getCurrentPlayer());
            Move m = game.getMove();
            match.addMove(m);
            logic.insert(m);
            logic.renderBoard();
        }
    }
    
    /**
     * return match repeatable
     */
    public ReplayedMatch replay() {
        return match.fork();
    }
}
