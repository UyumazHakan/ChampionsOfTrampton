package Command;

import PlayableCharacter.Hero;

/**
 * Created by Hakan on 10.5.2014.
 */
public class MoveCharacterYCommand extends MoveCharacterCommand {
  private int y;
  private Hero character;

  public MoveCharacterYCommand(int y, Hero character) {
    super(0, y, character);
  }
}