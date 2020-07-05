package vechicle;

public class PassengerCar extends Car {
    public enum carClassifications {
        budget,
        standard,
        premium
    }

    public carClassifications classification;

    public PassengerCar(String producer, String model, String color, double value, int mileage, carClassifications classification) {
        super(producer, model, color, value, mileage);
        this.classification = classification;
    }
}
