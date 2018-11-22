import java.util.ArrayList;

public class FuzzySet {

    private ArrayList<MemberShipFunction> memberShipFunctions;
    private String name;


    public FuzzySet(String name) {
        this.name = name;
        memberShipFunctions = new ArrayList<>();

    }

    public void AddMemberShipFunction(MemberShipFunction ms){
        memberShipFunctions.add(ms);
    }


    public ArrayList<MemberShipFunction> getMemberShipFunctions() {
        return memberShipFunctions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<ReturnedFireStrength> getFiringStrength(double X){
        double firingStrength;
        ArrayList<ReturnedFireStrength> ans = new ArrayList<>();
        for(MemberShipFunction m: memberShipFunctions){
           firingStrength = m.getFiringStrength(X);
            if(firingStrength != 0.0) {
                ans.add(new ReturnedFireStrength(m.getName(), firingStrength, name));
            }
        }
        return ans;

    }

    @Override
    public String toString() {
        return "MemberShipFunctions : " + memberShipFunctions;
    }
}
