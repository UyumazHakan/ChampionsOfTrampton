package PlayableCharacter;

import Weapon.SwordBehavior;
import Weapon.WeaponBehavior;

public class Minion extends PlayableCharacter {
  public Minion(WeaponBehavior weaponBehavior) {
    super(new SwordBehavior());
  }
}