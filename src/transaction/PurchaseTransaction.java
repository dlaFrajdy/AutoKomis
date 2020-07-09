package transaction;

import human.Client;
import human.Person;
import vechicle.Car;

public class PurchaseTransaction extends Transaction{


    public PurchaseTransaction(double price, Car car) {
        this.price = price;
        this.car = car;
    }

    @Override
    public String toString(){
        return "Purchase transaction. Price: "+ price+" . Car: "+car;
    }
}
