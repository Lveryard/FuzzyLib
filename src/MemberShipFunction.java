import java.util.ArrayList;

public class MemberShipFunction {

    private String name;
    private ArrayList<Point> points;
    private double LargestX, SmallestX;

    // Only For triangles and Trapezoids

    public MemberShipFunction(ArrayList<Point> points, String Name){
        this.name = Name;
        this.points = points;
        setLargestSmallestX();
    }

    public MemberShipFunction(ArrayList<Double> x, ArrayList<Double> y, String Name) {
        this.name = Name;
        this.points = new ArrayList<>();
        int size = Math.min(x.size(),y.size());
        for(int i = 0 ; i < size; i++){
            points.add(new Point(x.get(i), y.get(i)));
        }
        setLargestSmallestX();
    }


    private void setLargestSmallestX() {
       if(points == null || points.size() == 0){
           return;
       }
       double smallestX = Double.MAX_VALUE;
       double largestX = Double.MIN_VALUE;
       for(Point p : points){
           if(p.X > largestX) {
               largestX = p.X;
           }
           if(p.X < smallestX){
               smallestX = p.X;
           }
       }
       this.LargestX = largestX;
       this.SmallestX = smallestX;
    }

    public double getFiringStrength(double X){
        if(X > LargestX || X < SmallestX){
            return 0.0;
        }
        double ans;
        int[] index = BetweenPoints(X);
        if( points.get(index[0]).Y > points.get(index[1]).Y ){
            ans = FallingFire(X,index);
        }else {
           ans = RisingFire(X,index);
        }

        return ans;
    }

    private double RisingFire(double x, int[] index){
        // (X-a)/(b-a) // a is index 0, b is index 1
        double ans;
        ans = ( x - points.get(index[0]).X ) / ( points.get(index[1]).X - points.get(index[0]).X );
        return ans;
    }

    private double FallingFire(double x, int[] index){
        // (b-X)/(b-a) // a is index 0 , b is index 1
        double ans;
        ans = ( points.get(index[1]).X - x ) / ( points.get(index[1]).X - points.get(index[0]).X );
        return ans;
    }

    private int[] BetweenPoints(double x){
        // returns the index of the points that x is between
        int[] index = {0,0};
        for (int i = 0; i <  points.size()-1; i++){
            if(x > points.get(i).X && x < points.get(i+1).X){
                index[0] = i;
                index[1] = i+1;
            }
        }
        return index;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nName: " + name);
        sb.append("Points { \n");
        for(Point p: points){
            sb.append(p + " ");
        }
        sb.append("\n}");
        return sb.toString();
    }
}
