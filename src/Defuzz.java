import java.util.ArrayList;

public class Defuzz {

    public Defuzz() {

    }


    public double Centriod(ArrayList<Rule> firedRules , ArrayList<ArrayList<ReturnedFireStrength>> rfs, ArrayList<FuzzySet> inputsFuzzy, ArrayList<FuzzySet> outputFuzzy){
        System.out.println("CENTRIOD");
        ArrayList<ReturnedFireStrength> oneListRFs = new ArrayList();
        for(ArrayList<ReturnedFireStrength> r: rfs){
            oneListRFs.addAll(r);
        }
        // sum fireStrength * centreOfMass / sum fireStrengths

        double top = 0, bottom = 0;
        double fireX1 = 0, fireX2 = 0;
        Rule thisRule;
        double outputCentreOFmass = 0, FireStrength = 0;


        for(int i =0; i < firedRules.size(); i++){
            thisRule = firedRules.get(i);
            for(int j = 0 ; j < oneListRFs.size();j++){
//                if(oneListRFs.get(j).getForInput().equals("X1") && oneListRFs.get(j).getName().equals(firedRules.get(i).getOutput().get(0))){
//                    System.out.println("For X1");
//                    outputCentreOFmass = outputFuzzy.get(0).getCOMfor(firedRules.get(i).getOutput().get(0));
//                    FireStrength = oneListRFs.get(i).getFiringStrength();
//
//                    System.out.println(oneListRFs.get(j));
//                    System.out.println(firedRules.get(i));
//                    System.out.println();
//                }
//
//
//                if(oneListRFs.get(j).getForInput().equals("X2") && oneListRFs.get(j).getName().equals(firedRules.get(i).getOutput().get(0))){
//                    System.out.println("FOR X2");
//                    outputCentreOFmass = outputFuzzy.get(0).getCOMfor(firedRules.get(i).getOutput().get(0));
//                    FireStrength = oneListRFs.get(i).getFiringStrength();
//
//                    System.out.println(oneListRFs.get(j));
//                    System.out.println(firedRules.get(i));
//                    System.out.println();
//                }

                if(oneListRFs.get(j).getForInput().equals("X1") && oneListRFs.get(j).getName().equals(thisRule.getInputs().get(0))){
                    System.out.println("");
                    System.out.println(oneListRFs.get(j));
                    System.out.println(thisRule);
                    fireX1 = oneListRFs.get(j).getFiringStrength();
                    outputCentreOFmass = outputFuzzy.get(0).getCOMfor(thisRule.getOutput().get(0));
                }

                if(oneListRFs.get(j).getForInput().equals("X2") && oneListRFs.get(j).getName().equals(thisRule.getInputs().get(1))){
                    System.out.println("");
                    System.out.println(oneListRFs.get(j));
                    System.out.println(thisRule);
                    fireX2 = oneListRFs.get(j).getFiringStrength();
                }


            }
            System.out.println(fireX1);
            System.out.println(fireX2);
            FireStrength = Math.min(fireX1,fireX2);

            top += (outputCentreOFmass * FireStrength);
            bottom += FireStrength;

        }
        double ans = top/bottom;

        return ans;
    }

}
