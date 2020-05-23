package pl.sda.distance_calculator;
public class DistanceCalculator {
    public double calculateDistance(Point p1, Point p2){
        if(p1.getClass().getName().equals(p2.getClass().getName())){
            if(p1.getClass().getSimpleName().equals("Point")){
                return Math.sqrt(Math.pow(p2.getX() - p1.getX(),2) + Math.pow(p2.getY() - p1.getY(),2));
            } else {
                return  Math.sqrt(Math.pow(p2.getX() - p1.getX(),2) +
                        Math.pow(p2.getY() - p1.getY(),2) +
                        Math.pow(((Point3D)p2).getZ() - ((Point3D) p1).getZ(),2));
            }
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        DistanceCalculator dc = new DistanceCalculator();
        System.out.println(dc.calculateDistance(new Point(2,3), new Point(0,1)));
        System.out.println(dc.calculateDistance(new Point3D(2,3,0), new Point3D()));
        System.out.println(dc.calculateDistance(new Point3D(2,3,0), new Point(3,2)));
        System.out.println(dc.calculateDistance(new Point(2,3), new Point3D(1,3,2)));
    }
}