package assignment1 ;

public abstract class MilitaryUnit extends Unit {
    private double attackDamage;
    private int attackRange;
    private int armor;

    public MilitaryUnit(Tile position, double hp, int movingRange, String faction, 
                        double attackDamage, int attackRange, int armor) {
        super(position, hp, movingRange, faction);
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.armor = armor;
    }

    public void takeAction(Tile targetTile) {
        if (Tile.getDistance(this.getPosition(), targetTile) < this.attackRange) {
            Unit enemy = targetTile.selectWeakEnemy(this.getFaction());
            if (enemy != null) {
                double damageToDeal = this.attackDamage;
                if (this.getPosition().isImproved()) {
                    damageToDeal *= 1.05;
                }
                enemy.receiveDamage(damageToDeal);
            }
        }
    }

    public void receiveDamage(double damage) {
        double multiplier = 100.0 / (100.0 + this.armor);
        super.receiveDamage(damage * multiplier);
    }

}

