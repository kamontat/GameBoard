package main;

import controller.ReplayedMatch;
import object.Player;
import view.GameBoard;
import view.GameHistory;

public class Main {
    
    public static void main(String[] args) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        
        startGame(GameBoard.SupportGame.TIC_TAC_TOE, 3, 3, player1, player2);
        
        replayGame(0);
    }
    
    public static void startGame(GameBoard.SupportGame game, int row, int col, Player... args) {
        System.out.println("NEW " + game + " GAME ");
        
        // create new chess board game
        GameBoard board = new GameBoard(game, row, col, args);
        
        // start game
        board.startGame();
    }
    
    public static void replayGame(int id) {
        System.out.println("Replay game id=" + id);
        
        GameBoard b = GameHistory.getInstance().getGameID(id);
        
        ReplayedMatch replayMatch2 = b.replayGame();
        replayMatch2.startReplay();
    }
}
