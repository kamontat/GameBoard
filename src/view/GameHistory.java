package view;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 12/Dec/2017 - 13:25
 */
public class GameHistory extends HashMap<Integer, GameBoard> {
    private static GameHistory instance;
    
    public static GameHistory getInstance() {
        if (instance == null) instance = new GameHistory();
        return instance;
    }
    
    // return @nullable
    public GameBoard getGameID(int id) {
        return GameHistory.getInstance().get(id);
    }
}
