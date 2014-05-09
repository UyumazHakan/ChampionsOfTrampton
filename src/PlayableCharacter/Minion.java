package PlayableCharacter;

import Weapon.WeaponBehavior;

public class Minion extends PlayableCharacter {
  public Minion(int x, int y, int roomNumber, WeaponBehavior weaponBehavior) {
    super(x, y, roomNumber, weaponBehavior);
  }
}