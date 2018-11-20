import java.util.ArrayList;

public class Rule {

    ArrayList<String> inputs;
    ArrayList<String> output;
    int operator;
    static int AND = 0, OR = 1;

    public Rule(ArrayList<String> inputs, ArrayList<String> output, int operator) {
        this.inputs = inputs;
        this.output = output;
        this.operator = operator;
    }

    public boolean RuleFire(ArrayList<String> in){
        boolean ans;

        if(operator == AND){
            ans = andRule(in);
        }else {
            ans = orRule(in);
        }

        return ans;
    }

    private boolean orRule(ArrayList<String> in){
        for(String i : in){
            for(int j =0; j < inputs.size(); j++){
                if(i.equals(inputs.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean andRule(ArrayList<String> in){
        for(String i: in){
            for(int j = 0; j < inputs.size(); j++){
                if(!i.equals(inputs.get(j))){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
