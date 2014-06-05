package PlayableCharacter;

import Weapon.FistBehavior;
import Weapon.WeaponBehavior;

public class Sage extends Hero {
  public Sage(int x, int y, int roomNumber,int id) {
    super(x, y, roomNumber, new FistBehavior(),id,null);
  }
}