package pl.sda.distance_calculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

public class Point3D extends Point {
    private Integer z;

    public Point3D(Integer x,Integer y,Integer z){
        super(x,y);
        this.z=z;
    }
    public Point3D() {
        super();
        this.z = 0;
    }

    @Override
    public String toString() {
        return "[" + super.getX() + ", " + super.getY() + ", " + z + "]";
    }

    public void decrementZ() {
        this.z--;
    }

    public void incrementZ() {
        this.z++;
    }
}
