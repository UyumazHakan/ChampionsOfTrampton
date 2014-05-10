package Command;

import PlayableCharacter.PlayableCharacter;

public class MoveCharacterCommand implements Command {
  private int x, y;
  private PlayableCharacter character;

  public MoveCharacterCommand(int x, int y, PlayableCharacter character) {
    this.x = x;
    this.y = y;
    this.character = character;
  }

  @Override
  public void execute() {
    character.move(x, y);
  }
  public void networkExecute() {
    character.move(x, y);
  }
}