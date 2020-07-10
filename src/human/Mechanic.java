package human;

public class Mechanic extends Person {
    public final int repairPriceRate;    // % on the price of the part
    public final int chanceForFailedRepair; // %
    public final int chanceToDestroyAnotherPart; // %

    public Mechanic(String firstName, int repairPriceRate, int chanceForFailedRepair, int chanceToDestroyAnotherPart) {
        this.firstName = firstName;
        this.repairPriceRate = repairPriceRate;
        this.chanceForFailedRepair = chanceForFailedRepair;
        this.chanceToDestroyAnotherPart = chanceToDestroyAnotherPart;
    }

    @Override
    public String toString() {
        return firstName + ". Repair price rate: " + repairPriceRate + "%. Chance for failed repair: " + chanceForFailedRepair + "%. Chance to destroy another part: " + chanceToDestroyAnotherPart + "%.";
    }
}
