package PlayableCharacter;

import Weapon.WeaponBehavior;

import java.util.Vector;

public class Hero extends PlayableCharacter {

  public Integer newAttr;

    public Vector  myWeapon;

  public Hero(int x, int y, int roomNumber, WeaponBehavior weaponBehavior) {
    super(x, y, roomNumber, weaponBehavior);
  }

  public void newOperation() {
  }

}