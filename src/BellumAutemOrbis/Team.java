package BellumAutemOrbis;

public class Team
{
    public static final int GOLD = 100;
    public static final int WOOD = 100;
    public static final int FOOD = 10;
    public boolean team;
    public boolean race;
    public int gold;
    public int wood;
    public int food;
    
    public Team(boolean team, boolean race)
    {
        this.team = team;
        this.race = race;
        gold = GOLD;
        wood = WOOD;
        food = FOOD;
    }
}
