package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 12/Dec/2017 - 13:14
 */
public interface Move {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    void move();
    
    void show();
}
