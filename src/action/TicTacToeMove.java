package action;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 12/Dec/2017 - 13:15
 */
public class TicTacToeMove implements Move {
    private Scanner s = new Scanner(System.in);
    
    private int placeX; // location place to
    private int placeY; // location place to
    
    private Date date;
    
    @Override
    public void move() {
        System.out.print("Input location (X Y): ");
        placeX = s.nextInt() - 1;
        placeY = s.nextInt() - 1;
        date = new Date();
        // System.out.printf("Adding.. TICTACTOE at (%d,%d) @ %s\n", placeX, placeY, dateFormat.format(date));
    }
    
    @Override
    public void show() {
        System.out.printf("Adding.. TICTACTOE at (%d,%d) @ %s\n", placeX, placeY, dateFormat.format(date));
    }
    
    public int getPlaceX() {
        return placeX;
    }
    
    public int getPlaceY() {
        return placeY;
    }
}
