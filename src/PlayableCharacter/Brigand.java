package PlayableCharacter;

import Weapon.KnifeBehavior;

public class Brigand extends Hero {
  public Brigand(int id) {
    super(new KnifeBehavior(), id, null);
  }

  public String toString(){
    return "Brigand";
  }
}