package assignment1 ;

public class Warrior extends MilitaryUnit {

    public Warrior(Tile position, double hp, String faction) {

        super(position, hp, 1, faction, 20.0, 1, 25);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Warrior)) {
            return false;
        }

        Warrior otherWarrior = (Warrior) obj;
        return super.equals(otherWarrior);
    }
}
