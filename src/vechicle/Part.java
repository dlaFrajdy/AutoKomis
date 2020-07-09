package vechicle;

public class Part {
    public String name;
    public double materialsCost;
    public double increaseCarValueRate;
    public boolean isBroke;

    public Part(String name, double materialsCost, double increaseCarValueRate, boolean isBroke) {
        this.name = name;
        this.materialsCost = materialsCost;
        this.increaseCarValueRate = increaseCarValueRate;
        this.isBroke = isBroke;
    }

    @Override
    public String toString(){
        String call;
        if(isBroke)
            call = " broken";
        else
        call = "ok";
        return name+" "+ call;
    }
}
