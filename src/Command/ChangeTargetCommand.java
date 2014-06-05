package Command;

import PlayableCharacter.Hero;

/**
 * Created by UyumazHakan on 06.06.2014.
 */
public class ChangeTargetCommand implements Command {
  private Hero hero;
  private Hero newTarget;

  public ChangeTargetCommand(Hero hero, Hero newTarget) {
    this.hero = hero;
    this.newTarget = newTarget;
  }

  @Override
  public void execute() {
    hero.setTarget(newTarget);
  }

  @Override
  public void networkExecute() {
    execute();
  }
}
