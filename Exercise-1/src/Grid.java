import java.util.*;

public class Grid {
    private final int width, height;
    private final Set<Point> obstacles;

    public Grid(int width, int height, List<Point> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = new HashSet<>(obstacles);
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean hasObstacle(int x, int y) {
        return obstacles.contains(new Point(x, y));
    }
}
