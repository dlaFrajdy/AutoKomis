package dataGenerator;


import initialGameResources.PartsResources;
import vechicle.Car;
import vechicle.Part;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class PartGenerator {

    enum PartNames {
        brakes(10),
        suspension(20),
        engine(100),
        carBody(50),
        gearbox(50);

        private final int value;

        PartNames(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private final static int percentageChanceForBrokenPart = 30;

    public static ArrayList<Part> GeneratePartSet(Car car) {

        return new ArrayList<>() {{
            add(GenerateSinglePart(car, PartNames.brakes));
            add(GenerateSinglePart(car, PartNames.suspension));
            add(GenerateSinglePart(car, PartNames.engine));
            add(GenerateSinglePart(car, PartNames.carBody));
            add(GenerateSinglePart(car, PartNames.gearbox));
        }};
    }

    private static Part GenerateSinglePart(Car car, PartNames part) {
        return new Part(part.name(), GetMaterialCost(car, part), part.getValue(), drawDamage());
    }

    private static double GetMaterialCost(Car car, PartNames part) {
        switch (part) {
            case brakes:
                if (PartsResources.brakesPriceList.containsKey(car.producer))
                    return PartsResources.brakesPriceList.get(car.producer);
                return PartsResources.brakesPriceList.get("OtherProducer");
            case suspension:
                if (PartsResources.suspensionsPriceList.containsKey(car.producer))
                    return PartsResources.suspensionsPriceList.get(car.producer);
                return PartsResources.suspensionsPriceList.get("OtherProducer");
            case engine:
                if (PartsResources.enginesPriceList.containsKey(car.producer))
                    return PartsResources.enginesPriceList.get(car.producer);
                return PartsResources.enginesPriceList.get("OtherProducer");
            case carBody:
                if (PartsResources.carBodiesPriceList.containsKey(car.producer))
                    return PartsResources.carBodiesPriceList.get(car.producer);
                return PartsResources.carBodiesPriceList.get("OtherProducer");
            case gearbox:
                if (PartsResources.gearboxesPriceList.containsKey(car.producer))
                    return PartsResources.gearboxesPriceList.get(car.producer);
                return PartsResources.gearboxesPriceList.get("OtherProducer");
            default:
                return 0;
        }

    }

    private static boolean drawDamage() {
        int rnd = ThreadLocalRandom.current().nextInt(10);
        return rnd < percentageChanceForBrokenPart / 10;
    }

}
