package assignment1 ;

public class Worker extends Unit {
    private int numJobs;

    public Worker(Tile position, double hp, String faction) {
        super(position, hp, 2, faction);
        this.numJobs = 0;
    }

    public void takeAction(Tile tile) {
        if (this.getPosition().equals(tile) && !tile.isImproved()) {
            tile.buildImprovement();
            numJobs++;
            if (numJobs >= 10) {
                tile.removeUnit(this);
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Worker)) {
            return false;
        }
        Worker otherWorker = (Worker) obj;
        return super.equals(obj) && this.numJobs == otherWorker.numJobs;
    }
}
