package PlayableCharacter;

import Weapon.FistBehavior;

public class Archmage extends Hero {
  public Archmage(int id) {
    super(new FistBehavior(), id, null);
  }

  public String toString() {
    return "Archmage";
  }
}