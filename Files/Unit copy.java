package assignment1 ;

public abstract class Unit {
    private Tile position;
    private double hp;
    private int movingRange;
    private String faction;

    public Unit(Tile position, double hp, int movingRange, String faction) {
        this.position = position;
        this.hp = hp;
        this.movingRange = movingRange;
        this.faction = faction;

        boolean addedSuccessfully = position.addUnit(this);
        if (!addedSuccessfully) {
            throw new IllegalArgumentException();
        }
    }
    public final Tile getPosition() {

        return position;
    }

    public final double getHP() {

        return hp;
    }

    public final String getFaction() {

        return faction;
    }



    public boolean moveTo(Tile targetTile) {
        double distance = Tile.getDistance(this.position, targetTile);

        if (distance > this.movingRange) {
            return false;
        }

        if (targetTile.addUnit(this)) {
            this.position.removeUnit(this);
            this.position = targetTile;
            return true;
        }

        return false;
    }


    public void receiveDamage(double damage) {
        if (damage > 0) {
            if (position.isCity()) {
                damage *= 0.9;
            }
            this.hp -= damage;
        } else {
            return ;
        }


        if (hp <= 0) {
            position.removeUnit(this);
        }
    }

    public abstract void takeAction(Tile targetTile);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Unit)) {
            return false;
        }

        Unit otherUnit = (Unit) obj;

        boolean isSameX = this.position.getX()==(otherUnit.position.getX());
        boolean isSameY = this.position.getY()==(otherUnit.position.getY());
        boolean isSameFaction = this.faction.equals(otherUnit.faction);
        boolean isSameHealth = Math.pow(this.hp - otherUnit.hp, 2) < 0.001;

        return isSameX && isSameY && isSameFaction && isSameHealth;
    }
}
