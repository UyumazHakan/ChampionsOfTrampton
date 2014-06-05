package PlayableCharacter;

import Weapon.FistBehavior;
import Weapon.WeaponBehavior;

public class Invoker extends Hero {
  public Invoker(int x, int y, int roomNumber,int id) {
    super(x, y, roomNumber, new FistBehavior(),id,null);
  }
}