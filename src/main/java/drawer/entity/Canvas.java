package drawer.entity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Canvas {
    private char[][] canvas= null;
    private int height;
    private int width;

    public Canvas (int width, int height) throws IllegalArgumentException {
        if (width > 0 && height > 0){
            canvas = new char[height][width];
            this.height = height;
            this.width = width;
            createEmptyCanvas();
        }
        else throw new IllegalArgumentException("Canvas width and height should be positive integers");
    }

    private void createEmptyCanvas () {
        Arrays.stream(canvas).forEach(chars -> Arrays.fill(chars, ' '));
    }

    public String printCanvas () {
        String horizontal = new String(new char[this.width+2]).replace("\0", "-");
        StringBuilder builder = new StringBuilder();
        builder.append(horizontal).append("\n");
        for (int i = 0; i < this.height; i++) {
            builder.append('|');
            for (int j = 0; j < this.width; j++) {
                builder.append(canvas[i][j]);
            }
            builder.append('|');
            builder.append("\n");
        }
        builder.append(horizontal);
        System.out.println(builder.toString());
        return builder.toString();
    }

    public void addPixel (Point point, char c){
        int x = point.getX();
        int y = point.getY();
        if ( validCoordinate(x,y)){
            canvas[y][x] = c;
        }
    }

    private boolean validCoordinate(int x, int y){
        if ( x >= 0 && y >= 0 && y < height && x < width){
            return true;
        }
        return false;
    }

    public void bucketFill (int x, int y, char color) throws IllegalArgumentException{
        if (!validCoordinate(x,y)){
            throw new IllegalArgumentException("Bucket fill must be performed within the canvas coordinated");
        }
        int vis[][] = new int[height][width];
        Arrays.stream(vis).forEach(chars -> Arrays.fill(chars, 0));
        Queue<Point> obj = new LinkedList<>();
        Point pq=new Point(x,y);
        obj.add(pq);
        vis[y][x] = 1;
        while (!obj.isEmpty())
        {
            // Extracting front pair
            Point coord = obj.peek();
            int x1 = coord.getX();
            int y1 = coord.getY();
            char preColor = canvas[y1][x1];

            canvas[y1][x1] = color;

            // Poping front pair of queue
            obj.remove();

            // For Upside Pixel or Cell
            if (validCoordinate(x1, y1-1) && vis[y1 - 1][x1] == 0 && canvas[y1-1][x1] == preColor)
            {
                Point p=new Point(x1, y1 - 1);
                obj.add(p);
                vis[y1-1][x1] = 1;
            }

            // For Right side Pixel or Cell
            if (validCoordinate(x1+1, y1) && vis[y1][x1 + 1] == 0 && canvas[y1][x1 + 1] == preColor)
            {
                Point p=new Point(x1 +1,y1);
                obj.add(p);
                vis[y1][x1 + 1] = 1;
            }

            // For Downside Pixel or Cell
            if (validCoordinate(x1, y1+1) && vis[y1 + 1][x1] == 0 && canvas[y1 + 1][x1] == preColor)
            {
                Point p=new Point(x1,y1+1);
                obj.add(p);
                vis[y1+ 1][x1] = 1;
            }


            // For Left side Pixel or Cell
            if (validCoordinate(x1-1, y1 ) && vis[y1][x1 - 1] == 0 && canvas[y1][x1 - 1] == preColor)
            {
                Point p=new Point(x1-1,y1);
                obj.add(p);
                vis[y1][x1-1] = 1;
            }


        }
    }
}

