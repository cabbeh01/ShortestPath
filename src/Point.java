import java.util.ArrayList;

public class Point implements Comparable<Point>{
    double x;
    double y;
    int id;
    private static int idCounter = 0;

    public double f = Double.MAX_VALUE;
    public double g = Double.MAX_VALUE;
    public double h;
    public double extraweight =0;

    public Point parent = null;

    ArrayList<Branch> neighboursEd;


    public Point(double x, double y){
        this.x = x;
        this.y = y;
        this.id = idCounter++;
        this.h = Math.sqrt(Math.pow(this.x-950,2)+Math.pow(this.y-950,2));
        this.neighboursEd=new ArrayList<>();
    }

    public void addBranch(double weight, Point p){
        Branch ed = new Branch(weight,p);
        neighboursEd.add(ed);
    }

    public void removeBranch(Point p){
        neighboursEd.removeIf(es -> es.node == p);
    }

    public double calculateHeuristicpoint(Point point){
        return this.h;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static class Branch {
        Branch(double weight, Point node){
            this.weight = weight + node.extraweight;
            this.node = node;
        }

        public double weight;
        public Point node;
    }

    @Override
    public int compareTo(Point n) {
        return Double.compare(this.f, n.f);
    }

}
