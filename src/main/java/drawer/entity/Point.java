package drawer.entity;

import java.util.Objects;

public class Point {
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int[][] getNeighbours() {
        int[][] neighbours = new int[8][2];
        neighbours[0] = new int[] { x-1, y-1};
        neighbours[1] = new int[] { x, y-1};
        neighbours[2] = new int[] { x+1, y-1};
        neighbours[3] = new int[] { x+1, y};
        neighbours[4] = new int[] { x+1, y+1};
        neighbours[5] = new int[] { x, y+1};
        neighbours[6] = new int[] { x-1, y+1};
        neighbours[7] = new int[] { x-1, y};
        return neighbours;
    }

    public int[] getPoints(){
        return new int[] {x ,y};
    }

    public int getX () {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
