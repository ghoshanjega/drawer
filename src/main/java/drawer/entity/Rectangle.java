package drawer.entity;

public class Rectangle {
    private Line[] edges;
    private int x1, x2, y1, y2;

    public Rectangle(int _x1, int _x2, int _y1, int _y2) {
        if (Utils.allPositive(x1,x2,y1,y2)) {
            this.x1 = _x1;
            this.x2 = _x2;
            this.y1 = _y1;
            this.y2 = _y2;
            edges = new Line[]{
                    new Line(x1, x2, y1, y1),
                    new Line(x2, x2, y1, y2),
                    new Line(x2, x1, y2, y2),
                    new Line(x1, x1, y2, y1)

            };
        }
    }

    public Line[] getEdges() {
        return edges;
    }
}
