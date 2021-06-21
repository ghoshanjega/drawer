package drawer.entity;

import java.util.Arrays;
import java.util.Objects;

public class Line {
    private int x1,x2,y1,y2;
    private Character mark = '*';
    private int length;
    private Point[] path;

    public Line(int x1, int x2, int y1, int y2) throws IllegalArgumentException{
        if (Utils.allPositive(x1,x2,y1,y2)) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.length = Math.max(Math.abs(x2-x1),Math.abs(y2-y1))+1;
            path = new Point[length];
            planPath();
        }
    }

    public Point[] getPath(){
        return this.path;
    }

    public Character getMark(){
        return this.mark;
    }

    private void planPath () {
        Point start = new Point(x1,y1);
        Point end = new Point(x2,y2);

        Point current = start;
        path[0] = start;
        for(int i = 1; i < length-1; i++){
            Point nextPoint = getNextPoint(current.getNeighbours(),end);
            current = nextPoint;
            path[i] = current;
        }
        path[length -1] = end;
    }

    private Point getNextPoint (int[][] neighbours, Point endpoint) {
        double[] heuristics = new double[neighbours.length];
        for(int i = 0; i < neighbours.length; i++){
            heuristics[i] = Utils.calculateDistanceBetweenPoints(neighbours[i][0],neighbours[i][1],endpoint.getPoints()[0],endpoint.getPoints()[1]);
        }
        int bestPathIndex = Utils.indexOfSmallest(heuristics);
        return new Point(neighbours[bestPathIndex][0],neighbours[bestPathIndex][1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return x1 == line.x1 && x2 == line.x2 && y1 == line.y1 && y2 == line.y2 && length == line.length && Objects.equals(mark, line.mark) && Arrays.equals(path, line.path);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(x1, x2, y1, y2, mark, length);
        result = 31 * result + Arrays.hashCode(path);
        return result;
    }

    public int getX1(){
        return x1;
    }
}
