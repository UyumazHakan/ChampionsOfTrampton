package Command;

import PlayableCharacter.Hero;

public class GainExperienceCommand implements Command {
  private Hero hero;
  private int experienceAmount;

  public GainExperienceCommand(Hero hero, int experienceAmount) {
    this.hero = hero;
    this.experienceAmount = experienceAmount;
    System.out.println(hero + "  " + experienceAmount);
  }

  @Override
  public void execute() {
    hero.addExperience(experienceAmount);
  }

  public void networkExecute() {
    execute();
  }
}