import java.util.ArrayList;

public class FuzzyLib {

    ArrayList<FuzzySet> inputs;
    ArrayList<FuzzySet> output;
    ArrayList<ArrayList<ReturnedFireStrength>> RFS;

    public FuzzyLib() {
        inputs = new ArrayList<>();
        output = new ArrayList<>();
        RFS = new ArrayList<>();
    }


    public void test(){
        // _______________________ MembershipFunctions _______________________

        ArrayList<Point> p = new ArrayList<>();
        FuzzySet fs = new FuzzySet("X1");

        p.add(new Point(0.0,0.0));
        p.add(new Point(15.0,1.0));
        p.add(new Point(30.0 , 0.0));
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

        System.out.println(fs);
        fs = new FuzzySet("X2");
        p.clear();
        p.add(new Point(0.0,0.0));
        p.add(new Point(15.0,1.0));
        p.add(new Point(30.0 , 0.0));
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

        fs = new FuzzySet("Y2");

        p.clear();
        p.add(new Point(5.0,0.0));
        p.add(new Point(10.0,1.0));
        p.add(new Point(15.0,0.0));
        fs.AddMemberShipFunction(new MemberShipFunction(p,"Low"));

        p.clear();
        p.add(new Point(15.0,0.0));
        p.add(new Point(20.0,1.0));
        p.add(new Point(25.0,0.0));
        fs.AddMemberShipFunction(new MemberShipFunction(p,"Medium"));

        p.clear();
        p.add(new Point(25.0,0.0));
        p.add(new Point(30.0,1.0));
        p.add(new Point(35.0,0.0));
        fs.AddMemberShipFunction(new MemberShipFunction(p,"High"));

        output.add(fs);


        System.out.println(inputs);
        // _______________________ RULES _______________________
        ArrayList<Rule> rules = new ArrayList<>();
        ArrayList<String> inputRules = new ArrayList<>();
        ArrayList<String> outputRules = new ArrayList<>();

        inputRules.add("Low");
        inputRules.add("Low");
        outputRules.add("Low");
        rules.add(new Rule(inputRules, outputRules));
        inputRules.clear();
        outputRules.clear();

        inputRules.add("Low");
        inputRules.add("Medium");
        outputRules.add("Low");
        rules.add(new Rule(inputRules, outputRules));
        inputRules.clear();
        outputRules.clear();

        inputRules.add("Low");
        inputRules.add("High");
        outputRules.add("Medium");
        rules.add(new Rule(inputRules, outputRules));
        inputRules.clear();
        outputRules.clear();

        inputRules.add("Medium");
        inputRules.add("Low");
        outputRules.add("Low");
        rules.add(new Rule(inputRules, outputRules));
        inputRules.clear();
        outputRules.clear();

        inputRules.add("Medium");
        inputRules.add("Medium");
        outputRules.add("Medium");
        rules.add(new Rule(inputRules, outputRules));
        inputRules.clear();
        outputRules.clear();

        inputRules.add("Medium");
        inputRules.add("High");
        outputRules.add("High");
        rules.add(new Rule(inputRules, outputRules));
        inputRules.clear();
        outputRules.clear();

        inputRules.add("High");
        inputRules.add("Low");
        outputRules.add("Medium");
        rules.add(new Rule(inputRules, outputRules));
        inputRules.clear();
        outputRules.clear();

        inputRules.add("High");
        inputRules.add("Medium");
        outputRules.add("High");
        rules.add(new Rule(inputRules, outputRules));
        inputRules.clear();
        outputRules.clear();

        inputRules.add("High");
        inputRules.add("High");
        outputRules.add("High");
        rules.add(new Rule(inputRules, outputRules));
        inputRules.clear();
        outputRules.clear();

        RuleBase ruleBase = new RuleBase(rules, RuleBase.AND);

        int X1 = 18, X2 = 47;

        RFS.add(inputs.get(0).getFiringStrength(X1));
        RFS.add(inputs.get(1).getFiringStrength(X2));
        System.out.println(RFS);

        ArrayList<Rule> Fired =  new ArrayList<>();
        Fired.addAll(ruleBase.WhichRuleAnd(RFS));

        Defuzz d = new Defuzz();
        d.Centriod(Fired,RFS,inputs, output);


    }


}
