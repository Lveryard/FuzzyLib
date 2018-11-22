import java.util.ArrayList;

public class Rule {

    private ArrayList<String> inputs;
    private ArrayList<String> output;
    private int operator;
    private Boolean fired = true;

    static final int AND = 0, OR = 1;

    public Rule(ArrayList<String> inputs, ArrayList<String> output) {
        this.inputs = new ArrayList<>(inputs);
        this.output = new ArrayList<>(output);
    }

    public boolean RuleFire(ArrayList<ArrayList<ReturnedFireStrength>> in){
        boolean ans;
        ArrayList<ArrayList<String>> fireRules = new ArrayList<>();
        for(int i = 0; i < in.size(); i++){

        }


        if(operator == AND){
//          ans = andRule(fireRules);

        }else {
//            ans = orRule(fireRules);
        }

        return false;
    }

    private boolean orRule(ArrayList<String> in){
        for(int j =0; j < inputs.size(); j++){
            if(in.equals(inputs.get(j))){
                return true;
            }
        }

        return false;
    }

    private boolean andRule(ArrayList<String> in){
        System.out.println("input "+in);

        for(int j = 0; j < inputs.size(); j++){
            System.out.println(inputs.get(j));

            if(!in.equals(inputs.get(j))){
                return false;
            }
        }
        return true;
    }

    public boolean partOf(String name, int rule){
        return inputs.get(rule).equals(name);
    }



    public void setOperator(int operator) {
        this.operator = operator;
    }

    public Boolean getFired() {
        return fired;
    }

    public void setFired(Boolean fired) {
        this.fired = fired;
    }

    @Override
    public String toString() {
        return " Input: " + inputs + ", output: " + output;
    }
}
