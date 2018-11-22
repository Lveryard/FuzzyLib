import java.util.ArrayList;

public class Defuzz {

    public Defuzz() {

    }


    public double Centriod(ArrayList<Rule> firedRules , ArrayList<ArrayList<ReturnedFireStrength>> rfs, ArrayList<FuzzySet> inputsFuzzy, ArrayList<FuzzySet> outputFuzzy){
        System.out.println("CENTRIOD");
        System.out.println(firedRules);
        System.out.println(rfs);
        ArrayList<ReturnedFireStrength> oneListRFs = new ArrayList();
        for(ArrayList<ReturnedFireStrength> r: rfs){
            oneListRFs.addAll(r);
        }
        System.out.println(oneListRFs);
        System.out.println(inputsFuzzy);
        System.out.println(outputFuzzy);
        // sum fireStrength * centreOfMass / sum fireStrengths

        double top = 0, bottom = 0;
        int which;
        Rule thisRule;
        double outputCentreOFmass = 0, FireStrength = 0;



        for(int i =0; i < firedRules.size(); i++){
            thisRule = firedRules.get(i);
            for(int j = 0 ; j < oneListRFs.size();j++){
                if(oneListRFs.get(j).getName().equals(firedRules.get(i).getOutput().get(0))){
                    outputCentreOFmass = outputFuzzy.get(0).getCOMfor(firedRules.get(i).getOutput().get(0));
                    FireStrength = oneListRFs.get(i).getFiringStrength();

                    System.out.println(oneListRFs.get(j));
                    System.out.println(firedRules.get(i));
                }
            }
            top += (outputCentreOFmass * FireStrength);
            bottom += FireStrength;

        }
        double ans = top/bottom;

        return ans;
    }

}
