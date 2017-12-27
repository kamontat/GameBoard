package view;

import action.ChessMove;
import action.Move;
import action.TicTacToeMove;
import controller.Match;
import controller.ReplayedMatch;
import logic.ChessLogic;
import logic.Logic;
import logic.TicTacToeLogic;
import object.Player;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 12/Dec/2017 - 13:14
 */
public class GameBoard {
    private static int id = 0;
    private Match match;
    private SupportGame gameType;
    
    /**
     * support game
     */
    public enum SupportGame {
        TIC_TAC_TOE(TicTacToeMove.class, TicTacToeLogic.class),
        CHESS(ChessMove.class, ChessLogic.class);
        
        private Class<? extends Move> move;
        
        private Logic logic;
        private Class<? extends Logic> logicClass;
        
        SupportGame(Class<? extends Move> move, Class<? extends Logic> logicClass) {
            this.move = move;
            this.logicClass = logicClass;
        }
        
        public Move getMove() {
            try {
                return move.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return new TicTacToeMove();
            }
        }
        
        public Logic getLogic() {
            if (logic == null) {
                try {
                    logic = logicClass.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                    logic = new TicTacToeLogic(3, 3, new Player("name1"), new Player("name2"));
                }
            }
            return logic;
        }
    }
    
    /**
     * create board with game type
     *
     * @param gameType
     *         game type
     */
    public GameBoard(SupportGame gameType, int row, int col, Player... args) {
        match = new Match(gameType, row, col, args);
        // save history
        GameHistory.getInstance().put(id++, this);
    }
    
    /**
     * mock game turn
     */
    public void startGame() {
        match.play();
    }
    
    public ReplayedMatch replayGame() {
        return match.replay();
    }
}
