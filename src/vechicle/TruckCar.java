package vechicle;

public class TruckCar extends Car{

    public int cargoSpace;

    public TruckCar(String producer, String model, String color, double value, int mileage, int cargoSpace) {
        super(producer, model, color, value, mileage);
        this.cargoSpace = cargoSpace;
    }
}
