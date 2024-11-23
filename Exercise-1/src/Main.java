import java.util.*;
// Main class to run the Mars Rover simulation
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input grid size
            System.out.print("Enter grid size (width height): ");
            int width = scanner.nextInt();
            int height = scanner.nextInt();

            // Input starting position and direction
            System.out.print("Enter starting position and direction (x y direction): ");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String directionInput = scanner.next().toUpperCase();
            Direction startDirection;
            try {
                startDirection = Direction.valueOf(directionInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid direction! Use NORTH, EAST, SOUTH, or WEST.");
                return;
            }

            // Input obstacles
            System.out.print("Enter number of obstacles: ");
            int obstacleCount = scanner.nextInt();
            List<Point> obstacles = new ArrayList<>();
            if (obstacleCount > 0) {
                System.out.println("Enter obstacle positions (x y):");
                for (int i = 0; i < obstacleCount; i++) {
                    int ox = scanner.nextInt();
                    int oy = scanner.nextInt();
                    obstacles.add(new Point(ox, oy)); // Uses java.awt.Point
                }
            }

            // Create grid and rover
            Grid grid = new Grid(width, height, obstacles);
            MarsRover rover = new MarsRover(startX, startY, startDirection, grid);

            // Input and parse commands
            System.out.print("Enter commands (sequence of M L R): ");
            String commandString = scanner.next().toUpperCase();

            // Map commands to respective actions
            Map<Character, Command> commandMap = new HashMap<>();
            commandMap.put('M', new MoveCommand());
            commandMap.put('L', new TurnLeftCommand());
            commandMap.put('R', new TurnRightCommand());

            // Translate input commands
            List<Command> commands = new ArrayList<>();
            for (char c : commandString.toCharArray()) {
                if (commandMap.containsKey(c)) {
                    commands.add(commandMap.get(c));
                } else {
                    System.out.println("Invalid command: " + c);
                    return; // Exit on invalid command
                }
            }

            // Execute commands and print final state
            rover.executeCommands(commands);
            System.out.println("Final Position: (" + rover.getX() + ", " + rover.getY() + ", " + rover.getDirection() + ")");
            System.out.println(rover.getStatus());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please ensure all inputs are in the correct format.");
        } finally {
            // Close the scanner to prevent resource leaks
            scanner.close();
        }
    }
}
