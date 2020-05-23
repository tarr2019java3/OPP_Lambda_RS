package pl.sda.distance_calculator;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor

@Data


public class Point {
    private Integer x;
    private Integer y;
    public Point(){
        this.x=0;
        this.x=0;
    }

    public void incrementX() {
        this.x ++;
    }
    public void incrementY() {
        this.y++;
    }
    public void decrementY() {
        this.y--;
    }
    public void decrementX() {
        this.x--;
    }

    @Override
    public String toString() {
        return "[" + x +  ", " + y + "]";
    }
}
