import java.util.ArrayList;

public class MemberShipFunction {

    String name;
    ArrayList<Point> points;

    public MemberShipFunction(ArrayList<Point> points, String Name){
        this.name = Name;
        this.points = points;
    }

    public MemberShipFunction(ArrayList<Double> x, ArrayList<Double> y, String Name) {
        this.name = Name;
        this.points = new ArrayList<>();
        int size = Math.min(x.size(),y.size());
        for(int i = 0 ; i < size; i++){
            points.add(new Point(x.get(i), y.get(i)));
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nName: " + name);
        sb.append("Points { ");
        for(Point p: points){
            sb.append(p);
        }
        sb.append("}");
        return sb.toString();
    }
}
