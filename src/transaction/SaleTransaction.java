package transaction;

import human.Client;
import vechicle.Car;

public class SaleTransaction extends Transaction {
    private Client client;


    public SaleTransaction(Client client, double price, Car car) {
        this.client = client;
        this.price = price;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Sale transaction. Seller: " + client.firstName + " " + client.lastName + ". Price: " + price + " . Car: " + car;
    }
}
