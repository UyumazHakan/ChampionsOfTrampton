package Command;

import PlayableCharacter.PlayableCharacter;

/**
 * Created by Hakan on 10.5.2014.
 */
public class SetLocationCommand implements Command {
  private int x, y;
  private PlayableCharacter character;

  public SetLocationCommand(int x, int y, PlayableCharacter character) {
    this.x = x;
    this.y = y;
    this.character = character;
  }

  @Override
  public void execute() {
    character.setLocation(x, y);
  }
  public void networkExecute() {
    character.setLocation(x, y);
  }
}