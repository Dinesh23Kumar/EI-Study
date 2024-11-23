public class MoveCommand implements Command {
    @Override
    public void execute(MarsRover rover) {
        rover.move(); // Calls the move method in MarsRover
    }
}
