package action;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 12/Dec/2017 - 13:15
 */
public class ChessMove implements Move {
    private Scanner s = new Scanner(System.in);
    
    private int character; // the chess character
    private int placeX; // location place to
    private int placeY; // location place to
    
    private Date date;
    
    @Override
    public void move() {
        System.out.print("Input character code: ");
        character = s.nextInt();
        System.out.print("Input result location (X Y): ");
        placeX = s.nextInt() - 1;
        placeY = s.nextInt() - 1;
        date = new Date();
    }
    
    public int getCharacter() {
        return character;
    }
    
    public int getPlaceX() {
        return placeX;
    }
    
    public int getPlaceY() {
        return placeY;
    }
    
    @Override
    public void show() {
        System.out.printf("Moving.. CHESS %d to (%d,%d) @ %s\n", character, placeX, placeY, dateFormat.format(date));
    }
}
