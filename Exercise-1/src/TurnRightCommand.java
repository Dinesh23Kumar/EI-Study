public class TurnRightCommand implements Command {
    @Override
    public void execute(MarsRover rover) {
        rover.turnRight(); // Correctly calls the turnRight method in MarsRover
    }
}
