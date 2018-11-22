import java.util.ArrayList;

public class ReturnedFireStrength {

    private String Name;
    private double firingStrength;
    private String forInput;
    private ArrayList<Double> OutputCOM;
    public ReturnedFireStrength(String name, double firingStrength, String forInput) {
        Name = name;
        this.firingStrength = firingStrength;
        this.forInput = forInput;
        OutputCOM = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }


    public ArrayList<Double> getOutputCOM() {
        return OutputCOM;
    }

    public void setOutputCOM(ArrayList<Double> outputCOM) {
        OutputCOM = outputCOM;
    }

    public double getFiringStrength() {
        return firingStrength;
    }

    public String getForInput() {
        return forInput;
    }

    @Override
    public String toString() {
        return "Name: " + Name + " : " + firingStrength +" strength for input " + forInput ;
    }
}
