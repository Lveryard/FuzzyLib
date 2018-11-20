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

    public void getFiringStrength(double X){

        for(MemberShipFunction m: memberShipFunctions){
            m.getFiringStrength(X);
            m.ge
        }

    }
}
