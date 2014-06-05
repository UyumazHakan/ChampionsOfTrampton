package Command;

public class GainGoldCommand implements Command {
  @Override
  public void execute() {

  }

  @Override
  public void networkExecute() {
    execute();
  }
}