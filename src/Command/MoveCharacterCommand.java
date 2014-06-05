package Command;

import PlayableCharacter.Hero;

public class MoveCharacterCommand implements Command {
  private int x, y;
  private Hero character;

  public MoveCharacterCommand(int x, int y, PlayableCharacter.Hero character) {
    this.x = x;
    this.y = y;
    this.character = character;
  }

  @Override
  public void execute() {
    character.move(x, y);
    character.decreaseTurn();
  }

  public void networkExecute() {
    execute();
  }
}