package Command;

import PlayableCharacter.PlayableCharacter;

/**
 * Created by Hakan on 10.5.2014.
 */
public class SetLocationYCommand extends SetLocationCommand {
  public SetLocationYCommand(int y, PlayableCharacter character) {
    super(character.getX(), y, character);
  }
}
