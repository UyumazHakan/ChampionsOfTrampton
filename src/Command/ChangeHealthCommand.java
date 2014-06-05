package Command;

public class ChangeHealthCommand implements Command {
  @Override
  public void execute() {

  }

  @Override
  public void networkExecute() {
    execute();
  }
}