package vechicle;

import human.Mechanic;

public class Repair {
    private double price;
    private Part part;
    private Part destroyedPart;
    private Mechanic mechanic;
    private boolean isFailed;


    public Repair(double price, Part part, Part destroyedPart, Mechanic mechanic, boolean isFailed) {
        this.price = price;
        this.part = part;
        this.destroyedPart = destroyedPart;
        this.mechanic = mechanic;
        this.isFailed = isFailed;

    }

    @Override
    public String toString() {
        return "Repair cost: " + price + ". Part: " + part + ". Mechanic: " + mechanic.firstName + ". Is failed: " + isFailed + ". Destroyed another part:" + destroyedPart;
    }
}
