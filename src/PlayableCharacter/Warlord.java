package PlayableCharacter;

import Weapon.AxeBehavior;
import Weapon.WeaponBehavior;

import javax.swing.*;

public class Warlord extends Hero {
  public Warlord(int x, int y, int roomNumber,int id) {
    super(x, y, roomNumber, new AxeBehavior(),id,new ImageIcon("images/warlord.png"));
  }
}