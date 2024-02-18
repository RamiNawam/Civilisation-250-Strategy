package assignment1 ;

public class ListOfUnits {

    private Unit[] units;
    private int size;

    public ListOfUnits() {
        this.units = new Unit[0];  
        this.size = 0;
    }

    public int getSize() {

        return size;
    }

    public Unit[] getList() {
        Unit[] currentUnits = new Unit[size];
        for (int i = 0; i < this.size; i++) {
            currentUnits[i] = this.units[i];
        }
        return currentUnits;
    }

    public Unit getUnit(int index) {
        if (!(index >= 0 && index < this.size)) {
            throw new IndexOutOfBoundsException();
        }
        return units[index];
    }

    public void addUnit(Unit unit) {
        Unit[] newArray = new Unit[size + 1];
        for (int i = 0; i < size; i++) {
            newArray[i] = units[i];
        }
        newArray[size] = unit;
        units = newArray;
        size++;

    }

    public int indexOf(Unit unit) {
        for (int i = 0; i < size; i++) {
            if (units[i].equals(unit)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeUnit(Unit unit) {
        int index = indexOf(unit);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            units[i] = units[i + 1];
        }
        size--;
        Unit[] updatedArray = new Unit[size];
        for (int i = 0; i < size; i++) {
            updatedArray[i] = units[i];
        }
        units = updatedArray;
        return true;
    }
    
    public MilitaryUnit[] getArmy() {
        int count = 0; 
        for (int i = 0; i < size; i++) {
            if (units[i] instanceof MilitaryUnit) {
                count++;
            }
        }
        MilitaryUnit[] army = new MilitaryUnit[count];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (units[i] instanceof MilitaryUnit) {
                army[index++] = (MilitaryUnit) units[i];
            }
        }
        return army;
    }

}
