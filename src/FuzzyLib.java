import java.util.ArrayList;

public class FuzzyLib {

    ArrayList<FuzzySet> inputs;
    ArrayList<FuzzySet> output;

    public FuzzyLib() {
        inputs = new ArrayList<>();
        output = new ArrayList<>();
    }


    public void test(){
        ArrayList<Point> p = new ArrayList<>();
        p.add(new Point(0.0,0.0));
        p.add(new Point(15.0,1.0));
        p.add(new Point(30.0 , 0.0));

        FuzzySet fs = new FuzzySet("X1");
        fs.AddMemberShipFunction(new MemberShipFunction(p,"Low"));

        p.clear();
        p.add(new Point(15.0,0.0));
        p.add(new Point(30.0,1.0));
        p.add(new Point(40.0,1.0));
        p.add(new Point(50.0,0.0));
        fs.AddMemberShipFunction(new MemberShipFunction(p,"Medium"));

        p.clear();

        p.add(new Point(45.0,0.0));
        p.add(new Point(55.0,1.0));
        p.add(new Point(65.0,0.0));
        fs.AddMemberShipFunction(new MemberShipFunction(p,"High"));
        inputs.add(fs);


        System.out.println(inputs.get(0).getFiringStrength(18));

    }

}
