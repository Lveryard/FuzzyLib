public class ReturnedFireStrength {

    private String Name;
    private double firingStrength;

    public ReturnedFireStrength(String name, double firingStrength) {
        Name = name;
        this.firingStrength = firingStrength;
    }

    public String getName() {
        return Name;
    }

    public double getFiringStrength() {
        return firingStrength;
    }

    @Override
    public String toString() {
        return "Name: " + Name + " : " + firingStrength +" strength.";
    }
}
