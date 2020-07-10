package initialGameResources;

import human.Mechanic;

import java.util.ArrayList;

public class MechanicsResources {

    public enum MechanicNames {
        Janusz(100, 0, 0),
        Marian(60, 10, 0),
        Adrian(30, 20, 2);

        private final int repairPriceRate;
        private final int chanceForFailedRepair;
        private final int chanceToDestroyAnotherPart;

        MechanicNames(int repairPriceRate, int chanceForFailedRepair, int chanceToDestroyAnotherPart) {
            this.repairPriceRate = repairPriceRate;
            this.chanceForFailedRepair = chanceForFailedRepair;
            this.chanceToDestroyAnotherPart = chanceToDestroyAnotherPart;
        }

        public int getRepairPriceRate() {
            return repairPriceRate;
        }

        public int getChanceForFailedRepair() {
            return chanceForFailedRepair;
        }

        public int getChanceToDestroyAnotherPart() {
            return chanceToDestroyAnotherPart;
        }
    }

    public static ArrayList<Mechanic> availableMechanics = new ArrayList<>() {{
        add(new Mechanic("Janusz", 100, 0, 0));
        add(new Mechanic("Marian", 60, 10, 0));
        add(new Mechanic("Adrian", 30, 20, 2));
    }};
}
