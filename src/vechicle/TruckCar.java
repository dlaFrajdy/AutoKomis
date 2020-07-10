package vechicle;

public class TruckCar extends Car {

    public int cargoSpace;

    public TruckCar(String producer, String model, String color, double value, int mileage, int cargoSpace) {
        super(producer, model, color, value, mileage);
        this.cargoSpace = cargoSpace;
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + color + " " + value + "zł " + mileage + "km" + partList + "cargo space: " + cargoSpace;
    }
}
