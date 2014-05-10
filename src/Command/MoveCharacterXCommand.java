package Command;

import PlayableCharacter.PlayableCharacter;

/**
 * Created by Hakan on 10.5.2014.
 */
public class MoveCharacterXCommand extends MoveCharacterCommand {
  private int x;
  private PlayableCharacter character;

  public MoveCharacterXCommand(int x, PlayableCharacter character) {
    super(x, 0, character);
  }
}