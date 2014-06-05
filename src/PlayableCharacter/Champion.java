package PlayableCharacter;

import Weapon.SwordBehavior;

public class Champion extends Hero {
  public Champion(int id) {
    super(new SwordBehavior(), id, null);
  }
}