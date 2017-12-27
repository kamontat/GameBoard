package object;

import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since Tue 12/Dec/2017 - 14:37
 */
public class Player {
    private static int ID = 1;
    private int id;
    private String name;
    
    public Player(String name) {
        this.name = name;
        this.id = Player.ID;
        Player.ID++;
        
        Players.getInstant().addPlayer(this);
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "id=" + id + ", name='" + name;
    }
}

class Players {
    private static Players instant;
    
    public static Players getInstant() {
        if (instant == null) instant = new Players();
        return instant;
    }
    
    private Players() {
        players = new HashMap<>();
    }
    
    private HashMap<Integer, Player> players;
    
    protected void addPlayer(Player... args) {
        for (Player p : args) {
            players.put(p.getId(), p);
        }
    }
    
    protected Player getPlayer(int id) {
        return players.get(id);
    }
}