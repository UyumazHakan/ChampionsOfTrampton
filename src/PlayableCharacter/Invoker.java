package PlayableCharacter;

import Weapon.FistBehavior;

public class Invoker extends Hero {
  public Invoker(int id) {
    super(new FistBehavior(), id, null);
  }
}