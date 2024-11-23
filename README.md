The Mars Rover Simulation is a grid-based navigation system designed to simulate the movement of a Mars Rover. 
The Rover can move forward, turn left, or turn right, while avoiding obstacles and staying within grid boundaries.
Built with Object-Oriented Programming principles and modern design patterns, the project ensures flexibility, scalability, and clean architecture.
Key features include:
Command-based navigation (M, L, R) using the Command Pattern.
Obstacle detection to prevent collisions.
Boundary constraints to keep the Rover within the grid.
Status reports detailing the Rover's final position and direction.

├── src
│   ├── Main.java             # Entry point for the simulation
│   ├── MarsRover.java        # Defines Rover behavior
│   ├── Command.java          # Command interface
│   ├── MoveCommand.java      # Command to move the Rover
│   ├── TurnLeftCommand.java  # Command to turn Rover left
│   ├── TurnRightCommand.java # Command to turn Rover right
│   ├── Direction.java        # Enum for Rover directions (N, S, E, W)
│   ├── Grid.java             # Grid representation with obstacle management
│   ├── Point.java            # Represents coordinates and obstacles
│   └── README.md             # Documentation
