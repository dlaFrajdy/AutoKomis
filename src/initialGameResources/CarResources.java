package initialGameResources;

import vechicle.Car;
import vechicle.PassengerCar;
import vechicle.TruckCar;

import java.util.*;

public class CarResources {
    public static List<Car> carDatabase = new ArrayList<>() {{
        add(new PassengerCar("Volkswagen", "Golf", "Silver", 8000.0, 320000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Volkswagen", "Golf GTI", "Black", 190000.0, 30000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Alfa Romeo", "Giulietta ", "Silver", 29900.0, 1920000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Ford", "EDGE", "Red", 95300.0, 131000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Alfa Romeo", "Giulia", "Silver", 99999.0, 33000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("BMW", "X6 M", "Silver", 279000.0, 240000, PassengerCar.carClassifications.premium));
        add(new PassengerCar("Ford", "Fiesta", "Black", 8000.0, 150000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Audi", "A3", "Silver", 29800.0, 170000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Ford", "Fiesta", "Yellow", 14900.0, 126000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Subaru", "Forester", "Silver", 28000.0, 124000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Kia", "Soul", "Silver", 18000.0, 170000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Hyundai", "Genesis", "Blue", 12000.0, 276000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Lexus", "RX350", "Black", 36000.0, 150000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Ram", "1500", "Silver", 54000.0, 128000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Alfa Romeo", "Mito", "Silver", 22000.0, 45000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Nissan", "Leaf", "White", 18000.0, 76000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Mercedes", "Sprinter", "Yellow", 9000.0, 540000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Polo", "Yellow", 23000.0, 76000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Passat", "Blue", 123000.0, 32000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Lincoln", "MKZ", "Silver", 134000.0, 46000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Range", "Rover", "Black", 28000.0, 220000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Bugatti", "Veyron", "Silver", 800000.0, 34000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Ford", "Fiesta", "Red", 5600.0, 345000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Seat", "Ibiza", "Grey", 9600.0, 270000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Touran", "Black", 28000.0, 210000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Sirocco", "Silver", 56000.0, 88000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Toyota", "Corolla", "White", 16500.0, 165000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Alfa Romeo", "159", "White", 4700.0, 340000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Audi", "A4 ALLRAOD", "White", 34000.0, 270000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("BMW", "E60", "Silver", 11000.0, 290000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Kia", "Sportage", "Black", 27600.0, 231000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Honda", "Accord", "Silver", 41000.0, 45000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Ford", "Mondeo", "Blue", 5600.0, 322000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Alfa Romeo", "159", "Blue", 15800.0, 146000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Audi", "RS 6", "Yellow", 78000.0, 860000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Sirocco", "Silver", 45000.0, 120000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Honda", "CVR", "Black", 28000.0, 120000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("BMW", "X1", "White", 11000.0, 287000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("BMW", "X4", "Red", 48000.0, 110000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Dodge", "Challenger", "Silver", 231000.0, 16000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Opel", "Combo", "Black", 4500.0, 390000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Fiat", "Grande Punto", "Grey", 7400.0, 280000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("BMW", "520d", "Silver", 38900.0, 190000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Mercedes", "CLA 250", "Blue", 52000.0, 99000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Opel", "Mokka", "Green", 18000.0, 12000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Mazda", "6", "Silver", 32000.0, 189000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Golf", "Red", 18000.0, 123000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Volvo", "V60", "Black", 8800.0, 290000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Opel", "Astra", "Red", 18000.0, 115000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Skoda", "Fabia", "Black", 12000.0, 138000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Nissan", "X-trail", "Silver", 16000.0, 320000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Renault", "Megane", "Blue", 6900.0, 355000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Audi", "A6", "Silver", 18000.0, 440000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Nissan", "GT-R", "Black", 45000.0, 220000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Renault", "Clio", "Red", 8800.0, 225000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Opel", "Insignia", "Grey", 34000.0, 122000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Volkswagen", "Passat", "Red", 51000.0, 190000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("BMW", "730D", "Green", 58000.0, 210000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Hyundai", "Tuscon", "Silver", 11000.0, 265000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volvo", "XC-60", "White", 18000.0, 120000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Toyota", "Avensis", "Blue", 8000.0, 273000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Audi", "Q7", "Black", 45400.0, 225000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Fiat", "500", "White", 8900.0, 111000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Ford", "Mustang", "Silver", 78000.0, 89000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Tiguan", "Yellow", 44000.0, 145000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Ford", "Kuga", "Silver", 7900.0, 189000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Bora", "Green", 8450.0, 315000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Audi", "Q3", "Silver", 42000.0, 189000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Toyota", "RAW4", "Yellow", 32000.0, 211000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Sharan", "Silver", 11900.0, 364000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Toyota", "Prius", "Black", 18900.0, 220000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Honda", "Civic", "Grey", 12000.0, 220000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Ford", "S-Max", "Blue", 13800.0, 180000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Audi", "R8", "Silver", 145000.0, 45000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Passat", "Silver", 44000.0, 120000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Audi", "S4", "Red", 42900.0, 135000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Kia", "Rio", "Black", 12000.0, 89000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Passat", "Grey", 5900.0, 420000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Mitsubishi", "Outlander", "Silver", 8000.0, 320000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Cupra", "290ST", "Grey", 52000.0, 120000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("BMW", "123d", "White", 12000.0, 220000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Peugeot", "508", "Blue", 14000.0, 210000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Hyundai", "i20", "Silver", 12000.0, 123000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Polo", "Black", 3000.0, 350000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Hyundai", "i40", "Green", 15600.0, 97000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Skoda", "Octavia", "Black", 14400.0, 187000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Audi", "A6", "Blue", 28000.0, 225000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Audi", "TT", "Purple", 69000.0, 89000, PassengerCar.carClassifications.premium));
        add(new PassengerCar("Ford", "V90", "Black", 44000.0, 124000, PassengerCar.carClassifications.premium));
        add(new PassengerCar("BMW", "X6", "Silver", 59000.0, 110000, PassengerCar.carClassifications.premium));
        add(new PassengerCar("Nissan", "Navara", "Grey", 32000.0, 68000, PassengerCar.carClassifications.premium));
        add(new PassengerCar("Dacia", "Duster", "Black", 14000.0, 110000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Opel", "Astra", "Blue", 3000.0, 345000, PassengerCar.carClassifications.budget));
        add(new PassengerCar("Volkswagen", "Jetta", "Silver", 12000.0, 225000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Jeep", "Cherokee", "Red", 68000.0, 78000, PassengerCar.carClassifications.premium));
        add(new PassengerCar("Volkswagen", "Passat", "White", 123000.0, 32000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Kia", "Optima", "Silver", 16500.0, 140000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Mini", "Cooper", "Grey", 28000.0, 79000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("BMW", "G20", "Blue", 78900.0, 77000, PassengerCar.carClassifications.premium));
        add(new PassengerCar("Ford", "Escape", "Black", 18000.0, 120000, PassengerCar.carClassifications.standard));
        add(new PassengerCar("Volkswagen", "Golf", "Silver", 5600.0, 420000, PassengerCar.carClassifications.standard));
        add(new TruckCar("Mercedes", "Vito", "Silver", 15600.0, 212000, 600));
        add(new TruckCar("Fiat", "Ducato", "Red", 35600.0, 145000, 1200));
        add(new TruckCar("Volkswagen", "Crafter", "White", 23200.0, 152000, 1600));
        add(new TruckCar("Peugeot", "Partner", "Black", 31000.0, 70000, 450));
        add(new TruckCar("Fiat", "Scudo", "Silver", 31900.0, 227000, 870));
        add(new TruckCar("Volkswagen", "Caravelle", "Yellow", 47000.0, 54000, 1800));
        add(new TruckCar("Renault", "Master", "White", 44600.0, 112000, 2600));
        add(new TruckCar("Iveco", "72C15", "Red", 23600.0, 412000, 3300));
        add(new TruckCar("Citroën", "Jumper", "White", 31500.0, 193000, 2100));
        add(new TruckCar("Opel", "Movano", "White", 57500.0, 210000, 1950));
        add(new TruckCar("Volkswagen", "Transporter", "Black", 8500.0, 593000, 1400));
        add(new TruckCar("Citroën", "Jumper", "White", 15000.0, 425000, 2100));
        add(new TruckCar("Renault", "Kangoo", "Red", 16500.0, 312000, 800));
        add(new TruckCar("Volkswagen", "Crafter", "Blue", 44300.0, 111000, 1600));
        add(new TruckCar("Fiat", "Ducato", "White", 28900.0, 195000, 1200));

    }};
    public static List<String> allCarProducers = getUniqueCarProducers();


    private static List<String> getUniqueCarProducers() {

        HashSet<String> temp = new HashSet<>();
        for (Car car : carDatabase) {
            temp.add(car.producer);
        }
        return new ArrayList<>(new HashSet<>(temp));
    }
}
