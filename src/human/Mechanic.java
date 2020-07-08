package human;

public class Mechanic {
    public final String name;
    public final int repairPriceRate;    // % on the price of the part
    public final int chanceForFailedRepair; // %
    public final int chanceToDestroyAnotherPart; // %

    public Mechanic(String name, int repairPriceRate, int chanceForFailedRepair, int chanceToDestroyAnotherPart) {
        this.name = name;
        this.repairPriceRate = repairPriceRate;
        this.chanceForFailedRepair = chanceForFailedRepair;
        this.chanceToDestroyAnotherPart = chanceToDestroyAnotherPart;
    }

    @Override
    public String toString(){
        return name +". Repair price rate: "+ repairPriceRate +"%. Chance for failed repair: "+chanceForFailedRepair+"%. Chance to destroy another part: "+chanceToDestroyAnotherPart+"%.";
    }
}
