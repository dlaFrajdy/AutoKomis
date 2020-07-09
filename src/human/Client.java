package human;

import java.security.PrivateKey;
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

    public double getCash(){
        return cash;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + cash + " " + preferredCarProducers + " " + preferredCarType + " " + isAcceptDamagedVehicles + " " + isAcceptDamagedSuspension;
    }


}
