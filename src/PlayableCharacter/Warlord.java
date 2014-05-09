package PlayableCharacter;

import Weapon.AxeBehavior;
import Weapon.WeaponBehavior;

public class Warlord extends Hero {
  public Warlord(int x, int y, int roomNumber, WeaponBehavior weaponBehavior) {
    super(x, y, roomNumber, new AxeBehavior());
  }
}