public class ReturnedFireStrength {

    private String Name;
    private double firingStrength;
    private String forInput;
    public ReturnedFireStrength(String name, double firingStrength, String forInput) {
        Name = name;
        this.firingStrength = firingStrength;
        this.forInput = forInput;
    }

    public String getName() {
        return Name;
    }

    public double getFiringStrength() {
        return firingStrength;
    }

    @Override
    public String toString() {
        return "Name: " + Name + " : " + firingStrength +" strength for input " + forInput ;
    }
}
