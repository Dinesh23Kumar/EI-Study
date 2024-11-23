public class TurnLeftCommand implements Command {
    @Override
    public void execute(MarsRover rover) {
        rover.turnLeft(); // Calls the turnLeft method in MarsRover
    }
}
