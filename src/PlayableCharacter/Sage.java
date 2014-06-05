package PlayableCharacter;

import Weapon.FistBehavior;

public class Sage extends Hero {
  public Sage(int id) {
    super(new FistBehavior(), id, null);
  }
}