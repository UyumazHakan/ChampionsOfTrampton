package Command;

import PlayableCharacter.Hero;
import PlayableCharacter.PlayableCharacter;

/**
 * Created by UyumazHakan on 05.06.2014.
 */
public class KillCharacterCommand implements Command {
  private PlayableCharacter killer;
  private PlayableCharacter victim;

  public KillCharacterCommand(PlayableCharacter killer, PlayableCharacter victim) {
    this.killer = killer;
    this.victim = victim;
  }

  @Override
  public void execute() {
    ((Hero) killer).decreaseTurn();
  }

  public void networkExecute() {
    execute();
  }
}
