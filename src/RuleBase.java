import java.util.ArrayList;

public class RuleBase {

    ArrayList<Rule> rules;
    int Operator;
    static final int AND = Rule.AND, OR = Rule.OR;

    public RuleBase(ArrayList<Rule> rules, int op) {
        this.rules = rules;
        this.Operator = op;
        for(Rule r: rules){
            r.setOperator(Operator);
        }
    }

    public ArrayList<Rule> WhichRuleAnd(ArrayList<ArrayList<ReturnedFireStrength>> rfs){
        ArrayList<Rule> firedRules = new ArrayList<>();
        ArrayList<Rule> couldFire = new ArrayList<>();
        int counter = 0;
        while(counter < rfs.size()){
            int whichFire = 0;
            while(whichFire < rfs.get(counter).size()){
                for(Rule r: rules){
                    System.out.println(r + " = "+ rfs.get(counter).get(whichFire).getName() + " @ pos " +counter);
                    if(r.getFired() && r.partOf(rfs.get(counter).get(whichFire).getName(), counter)){
                        System.out.println(true);
                        couldFire.add(r);
                    }else{
                        System.out.println(true);
                    }
                    System.out.println();
                }

                whichFire++;
            }
            for(Rule r: rules){
                if(!couldFire.contains(r)){
                    r.setFired(false);
                }
            }
            couldFire.clear();
            counter++;
        }
        for(Rule r: rules){
            if(r.getFired()){
                firedRules.add(r);
            }
        }
        System.out.println(firedRules);

        return firedRules;
    }

}
