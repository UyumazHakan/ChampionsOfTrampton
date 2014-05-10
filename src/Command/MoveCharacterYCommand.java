package Command;

import PlayableCharacter.PlayableCharacter;

/**
 * Created by Hakan on 10.5.2014.
 */
public class MoveCharacterYCommand extends MoveCharacterCommand {
  private int y;
  private PlayableCharacter character;

  public MoveCharacterYCommand(int y, PlayableCharacter character) {
    super(0, y, character);
  }
}