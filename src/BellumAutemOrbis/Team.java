package BellumAutemOrbis;

public class Team
{
    public static final int GOLD = 100;
    public static final int WOOD = 100;
    public static final int FOOD = 10;
    public int team;
    public int race;
    public int gold;
    public int wood;
    public int food;
    
    public Team(int team, int race)
    {
        this.team = team;
        this.race = race;
        gold = GOLD;
        wood = WOOD;
        food = FOOD;
    }
}
