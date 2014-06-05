package Command;

import PlayableCharacter.Hero;

/**
 * Created by Hakan on 10.5.2014.
 */
public class MoveCharacterXCommand extends MoveCharacterCommand {
  private int x;
  private Hero character;

  public MoveCharacterXCommand(int x, Hero character) {
    super(x, 0, character);
  }
}