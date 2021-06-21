package drawer;

import drawer.command.*;
import drawer.entity.Canvas;
import drawer.entity.Line;
import drawer.entity.Point;
import drawer.entity.Rectangle;
import org.reflections.Reflections;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

public class Application {
    private static Canvas canvas;
    private static Scanner scanner;
    private static SwitchBoard switchBoard;

    public static void main(String[] args) {
        start(System.in, args);
    }

    public static void start(InputStream input, String[] args) {
        scanner = new Scanner(input);
        switchBoard = new SwitchBoard();
        Reflections reflections = new Reflections("drawer");

        Set<Class<? extends Command>> implementedCommand = reflections.getSubTypesOf(Command.class);
        for (Class<? extends Command> aClass : implementedCommand) {
            System.out.println(aClass);
        }

        System.out.println("Enter command:");

        while (true) {
            process(scanner.nextLine());
            System.out.println("Enter command:");
        }

    }

    private static void process(String commandLine) {
        Command command = null;

        try {
            command = switchBoard.inferCommandType(commandLine);
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (command instanceof QuitProgramCommand) {
                command.print();
                quit();
            }

            if (command instanceof CreateCanvasCommand) {
                CreateCanvasCommand createCommand = (CreateCanvasCommand) command;
                command.print();
                canvas = new Canvas(createCommand.getWidth(), createCommand.getHeight());

                canvas.printCanvas();
                return;
            }

            if (command instanceof LineCommand) {
                LineCommand cmd = (LineCommand) command;
                cmd.print();
                Line newLine = new Line(cmd.getX1(), cmd.getX2(), cmd.getY1(), cmd.getY2());
                drawLine(newLine);
                canvas.printCanvas();
            }

            if (command instanceof RectangleCommand) {
                RectangleCommand cmd = (RectangleCommand) command;
                cmd.print();
                Rectangle newRectangle = new Rectangle(cmd.getX1(), cmd.getX2(), cmd.getY1(), cmd.getY2());
                drawRectangle(newRectangle);
                canvas.printCanvas();
            }

            if (command instanceof BucketFillCommand) {
                BucketFillCommand cmd = (BucketFillCommand) command;
                cmd.print();
                canvas.bucketFill(cmd.getX(),cmd.getY(),cmd.getColor());
                canvas.printCanvas();
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void drawLine(Line newLine) {
        Point[] path = newLine.getPath();
        for (Point point : path) {
            canvas.addPixel(point, newLine.getMark());
        }
    }

    private static void drawRectangle(Rectangle newRectangle) {
        for (Line edge : newRectangle.getEdges()) {
            drawLine(edge);
        }
    }

    private static void quit() {
        scanner.close();
        System.exit(0);
    }
}
