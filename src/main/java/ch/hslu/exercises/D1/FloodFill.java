package ch.hslu.exercises.D1;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FloodFill {

    private static final List<Point> coordinatesOrder = new ArrayList<>();
    private static int colorPixelCounter = 0;
    private static int colorAreaCounter = 0;

    private Color getActualColor(int x, int y, Color[][] grid) {
        return grid[y][x];
    }

    private void colorPixel(int x, int y, Color fillColor, Color[][] grid) {
        colorPixelCounter++;
        grid[y][x] = fillColor;
    }

    public void colorArea(final int x, final int y, final Color fillColor, final Color outsideColor, Color[][] grid) {
        colorAreaCounter++;
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length) {
            return;
        }
        Color actualColor = getActualColor(x, y, grid);
        if ((actualColor != outsideColor) && (actualColor != fillColor)) {
            colorPixel(x, y, fillColor, grid);
            coordinatesOrder.add(new Point(x, y));
            colorArea(x + 1, y, fillColor, outsideColor, grid);
            colorArea(x, y - 1, fillColor, outsideColor, grid);
            colorArea(x - 1, y, fillColor, outsideColor, grid);
            colorArea(x, y + 1, fillColor, outsideColor, grid);
        }
    }

    public static void main(String[] args) {
        Color[][] grid = new Color[9][10];

        // Initialize the grid with black and white colors as per the provided image
        // Black is the outside color and white is the color we want to fill
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                grid[y][x] = Color.black; // Assuming the black cells represent the "outside" color
            }
        }

        // Define white areas
        Set<Point> whiteAreas = defineWhiteAreas(new HashSet<>());

        for (Point point : whiteAreas) {
            grid[point.y][point.x] = Color.white;
        }

        // reverse y, last is first, first is last
        for (int y = 0; y < grid.length / 2; y++) {
            Color[] temp = grid[y];
            grid[y] = grid[grid.length - y - 1];
            grid[grid.length - y - 1] = temp;
        }

        for (Color[] colors : grid) {
            for (int x = 0; x < grid[0].length; x++) {
                System.out.print(colors[x] == Color.white ? "⬜ " : "⬛ ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");

        // Start the flood fill algorithm
        FloodFill floodFill = new FloodFill();
        floodFill.colorArea(3, 7, Color.gray, Color.black, grid);

        System.out.println("Coordinates order:");
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (coordinatesOrder.contains(new Point(x, y))) {
                    System.out.printf("%02d ", coordinatesOrder.indexOf(new Point(x, y)));
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }

        System.out.println("Color pixel counter: " + colorPixelCounter);
        System.out.println("Color area counter: " + colorAreaCounter);
    }

    private static Set<Point> defineWhiteAreas(Set<Point> whiteAreas) {
        whiteAreas.add(new Point(1, 1));
        whiteAreas.add(new Point(1, 2));
        whiteAreas.add(new Point(1, 3));
        whiteAreas.add(new Point(1, 4));
        whiteAreas.add(new Point(1, 5));
        whiteAreas.add(new Point(1, 6));
        whiteAreas.add(new Point(1, 7));
        whiteAreas.add(new Point(1, 8));
        whiteAreas.add(new Point(2, 1));
        whiteAreas.add(new Point(2, 2));
        whiteAreas.add(new Point(2, 3));
        whiteAreas.add(new Point(2, 8));
        whiteAreas.add(new Point(3, 1));
        whiteAreas.add(new Point(3, 2));
        whiteAreas.add(new Point(3, 3));
        whiteAreas.add(new Point(3, 8));
        whiteAreas.add(new Point(4, 2));
        whiteAreas.add(new Point(4, 3));
        whiteAreas.add(new Point(4, 4));
        whiteAreas.add(new Point(4, 5));
        whiteAreas.add(new Point(4, 6));
        whiteAreas.add(new Point(4, 8));
        whiteAreas.add(new Point(5, 2));
        whiteAreas.add(new Point(5, 3));
        whiteAreas.add(new Point(5, 4));
        whiteAreas.add(new Point(5, 6));
        whiteAreas.add(new Point(5, 8));
        whiteAreas.add(new Point(6, 3));
        whiteAreas.add(new Point(6, 4));
        whiteAreas.add(new Point(6, 6));
        whiteAreas.add(new Point(6, 8));
        whiteAreas.add(new Point(7, 3));
        whiteAreas.add(new Point(7, 4));
        whiteAreas.add(new Point(7, 6));
        whiteAreas.add(new Point(7, 7));
        whiteAreas.add(new Point(7, 8));
        whiteAreas.add(new Point(8, 2));
        whiteAreas.add(new Point(8, 3));
        whiteAreas.add(new Point(8, 4));
        whiteAreas.add(new Point(9, 2));
        whiteAreas.add(new Point(9, 3));
        whiteAreas.add(new Point(9, 4));
        return whiteAreas;
    }
}

