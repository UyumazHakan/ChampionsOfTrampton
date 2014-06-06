package Command;

import PlayableCharacter.Hero;
import PlayableCharacter.PlayableCharacter;

/**
 * Created by UyumazHakan on 05.06.2014.
 */
public class KillCharacterCommand implements Command {
  private Hero killer;
  private Hero victim;

  public KillCharacterCommand(Hero killer, Hero victim) {
    this.killer = killer;
    this.victim = victim;
  }

  @Override
  public void execute() {
    killer.decreaseTurn();
  }

  public void networkExecute() {
    execute();
  }
}
