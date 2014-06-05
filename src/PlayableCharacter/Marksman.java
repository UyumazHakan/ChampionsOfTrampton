package PlayableCharacter;

import Weapon.BowBehavior;
import Weapon.WeaponBehavior;

import javax.swing.*;

public class Marksman extends Hero {
  public Marksman(int x, int y, int roomNumber,int id) {
    super(x, y, roomNumber, new BowBehavior(),id,new ImageIcon("images/marksman.png"));
  }
}