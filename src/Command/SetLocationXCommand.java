package Command;

import PlayableCharacter.PlayableCharacter;

/**
 * Created by Hakan on 10.5.2014.
 */
public class SetLocationXCommand extends SetLocationCommand {

  public SetLocationXCommand(int x, PlayableCharacter character) {
    super(x, character.getY(), character);
  }
}
