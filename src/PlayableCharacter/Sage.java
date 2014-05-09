package PlayableCharacter;

import Weapon.FistBehavior;
import Weapon.WeaponBehavior;

public class Sage extends Hero {
  public Sage(int x, int y, int roomNumber, WeaponBehavior weaponBehavior) {
    super(x, y, roomNumber, new FistBehavior());
  }
}