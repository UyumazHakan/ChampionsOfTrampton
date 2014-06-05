package PlayableCharacter;

import Weapon.KnifeBehavior;
import Weapon.WeaponBehavior;

import javax.swing.*;

public class Phantom extends Hero {
  public Phantom(int x, int y, int roomNumber,int id) {
    super(x, y, roomNumber, new KnifeBehavior(),id,new ImageIcon("images/phantom.png"));
  }
}