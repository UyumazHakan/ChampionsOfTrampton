package Command;

public class EraseConditionCommand implements Command {
  @Override
  public void execute() {

  }

  @Override
  public void networkExecute() {
    execute();
  }
}