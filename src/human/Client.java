package human;

import vechicle.Car;


import java.util.List;

public class Client extends Person{
    public String lastName;
    private double cash;
    public List<String> preferredCarProducers;
    public String preferredCarType;
    public boolean isAcceptDamagedVehicles;
    public boolean isAcceptDamagedSuspension;

    /*  "[..] niewielka grupa [klientów] akceptuje zakup uszkodzonego pojazdu, część zgodzi się na niesprawne zawieszenie [..]"
         Przyjąłem, że za uszkodzony pojazd rozumiemy uszkodzoną karoserię skoro uszkodzone zawieszenie to osobna kategoria.
    */

    public Client(String firstName, String lastName, double cash, List<String> preferredCarProducers, String preferredCarType, boolean isAcceptDamagedVehicles, boolean isAcceptDamagedSuspension) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cash = cash;
        this.preferredCarProducers = preferredCarProducers;
        this.preferredCarType = preferredCarType;
        this.isAcceptDamagedVehicles = isAcceptDamagedVehicles;
        this.isAcceptDamagedSuspension = isAcceptDamagedSuspension;
    }


    public boolean checkIfAcceptCar(Car car){
        if (!car.getClass().toString().contains(this.preferredCarType)) return false;
        if (this.preferredCarProducers.contains(car.producer)) return false;
        if(car.getBrokenPartsList().stream().anyMatch(o -> o.name.equals("suspension")) && !this.isAcceptDamagedSuspension) return false;
        return car.getBrokenPartsList().stream().filter(o -> o.name.equals("carBody")).findFirst().isEmpty() || this.isAcceptDamagedVehicles;
    }

    @Override
    public String toString() {
        return "Name: "+firstName + " " + lastName + ". Cash: " + cash + ". Preferred car producer: " + preferredCarProducers + ". Preferred car type" + preferredCarType + ". Accept damaged vehicles: " + isAcceptDamagedVehicles + ". Accept damaged suspension: " + isAcceptDamagedSuspension;
    }


}
