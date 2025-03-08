package oop;

public class Boardgame extends LibraryItem {
    private String type;
    private int player;
    private String playtime;

    public Boardgame(String name, String type, int player, String playtime) {
        super(name);
        this.type = type;
        this.player = player;
        this.playtime = playtime;
    }

    public String getType() {
        return type;
    }

    public int getPlayer() {
        return player;
    }

    public String getPlaytime() {
        return playtime;
    }
}
