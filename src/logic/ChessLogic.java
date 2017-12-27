package logic;

import action.ChessMove;
import action.Move;
import object.Player;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 12/Dec/2017 - 14:35
 */
public class ChessLogic implements Logic {
    private int[][] board;
    
    private int pointer;
    private Player[] players;
    
    private int numberOfPlayer;
    private Player currentPlayer;
    
    public ChessLogic() {
        setBoard(20, 20);
    }
    
    public ChessLogic(int row, int col, Player... args) {
        setBoard(row, col);
        addPlayer(args);
    }
    
    @Override
    public void setBoard(int row, int col) {
        this.board = new int[row][col];
    }
    
    @Override
    public void addPlayer(Player... args) {
        this.players = args;
        this.numberOfPlayer = players.length;
        this.pointer = 0;
    }
    
    @Override
    public <T extends Move> void insert(T move) {
        if (!(move instanceof ChessMove)) return;
        
        move.move();
        
        int c = ((ChessMove) move).getCharacter();
        int x = ((ChessMove) move).getPlaceX();
        int y = ((ChessMove) move).getPlaceY();
        if (x >= board.length) {
            System.out.println("OUT OF LENGTH X");
            return;
        }
        if (y >= board[0].length) {
            System.out.println("OUT OF LENGTH Y");
            return;
        }
        if (board[x][y] != 0) {
            System.out.println("CANNOT INSERT");
            return;
        }
        
        
        board[x][y] = players[pointer].getId() + c;
        nextPointer();
    }
    
    public void renderBoard() {
        System.out.printf("%4s |", " ");
        for (int j = 0; j < board[0].length; j++) {
            System.out.printf("%4s |", j + 1);
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.printf("%4s |", i + 1);
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("%4s |", board[i][j]);
            }
            System.out.println();
        }
    }
    
    @Override
    public Player getCurrentPlayer() {
        return players[pointer];
    }
    
    @Override
    public boolean isFinish() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }
    
    private void nextPointer() {
        pointer++;
        if (pointer >= numberOfPlayer) pointer = 0;
    }
}
