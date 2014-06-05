package PlayableCharacter;

import Weapon.FistBehavior;
import Weapon.WeaponBehavior;

public class Archmage extends Hero {
  public Archmage(int x, int y, int roomNumber,int id) {
    super(x, y, roomNumber, new FistBehavior(),id,null);
  }
}