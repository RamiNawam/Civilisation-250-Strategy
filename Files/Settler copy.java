package assignment1 ;

public class Settler extends Unit {
    public Settler(Tile position, double hp, String faction) {

        super(position, hp, 2, faction);
    }

    public void takeAction(Tile targetTile) {
        if (this.getPosition().equals(targetTile) && !targetTile.isCity()) {
            targetTile.buildCity();
            targetTile.removeUnit(this);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Settler)) {
            return false;
        }
        Settler otherSettler = (Settler) obj;
        return super.equals(otherSettler);
    }
}
