import java.util.List;
public class MarsRover {
    private int x, y;
    private Direction direction;
    private final Grid grid;

    public MarsRover(int x, int y, Direction direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void executeCommands(List<Command> commands) {
        for (Command command : commands) {
            command.execute(this);
        }
    }

    public void move() {
        int newX = x + direction.dx;
        int newY = y + direction.dy;
        if (grid.isWithinBounds(newX, newY) && !grid.hasObstacle(newX, newY)) {
            x = newX;
            y = newY;
        } else {
            System.out.println("Obstacle or boundary detected. Stopping move.");
        }
    }

    public void turnLeft() {
        this.direction = direction.left();
    }

    public void turnRight() {
        this.direction = direction.right();
    }

    public String getStatus() {
        return String.format("Rover is at (%d, %d) facing %s.", x, y, direction);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
