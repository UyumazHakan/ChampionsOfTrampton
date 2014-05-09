package PlayableCharacter;

import Weapon.KnifeBehavior;
import Weapon.WeaponBehavior;

public class Phantom extends Hero {
  public Phantom(int x, int y, int roomNumber, WeaponBehavior weaponBehavior) {
    super(x, y, roomNumber, new KnifeBehavior());
  }
}