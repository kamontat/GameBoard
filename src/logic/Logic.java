package logic;

import action.Move;
import object.Player;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 12/Dec/2017 - 14:44
 */
public interface Logic {
    void setBoard(int row, int col);
    
    void addPlayer(Player... args);
    
    <T extends Move> void insert(T move);
    
    void renderBoard();
    
    Player getCurrentPlayer();
    
    boolean isFinish();
}
