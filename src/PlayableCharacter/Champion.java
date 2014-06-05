package PlayableCharacter;

import Weapon.SwordBehavior;
import Weapon.WeaponBehavior;

public class Champion extends Hero {
  public Champion(int x, int y, int roomNumber,int id) {
    super(x, y, roomNumber, new SwordBehavior(),id,null);
  }
}