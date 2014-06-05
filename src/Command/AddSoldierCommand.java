package Command;

public class AddSoldierCommand implements Command {
  @Override
  public void execute() {

  }

  @Override
  public void networkExecute() {
    execute();
  }
}