package assignment1 ;

public class Archer extends MilitaryUnit {

    private int arrows;

    public Archer(Tile position, double hp, String faction) {
        super(position, hp, 2, faction, 15.0, 2, 0);
        this.arrows = 5;
    }

    public void takeAction(Tile targetTile) {
        if (arrows == 0) {
            arrows = 5;
        } else {
            super.takeAction(targetTile);
            arrows--;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Archer)) {
            return false;
        }

        Archer otherArcher = (Archer) obj;
        return super.equals(otherArcher) && this.arrows == otherArcher.arrows;
    }
}
