package PlayableCharacter;

import Weapon.SwordBehavior;

import javax.swing.*;

public class Champion extends Hero {
  public Champion(int id) {
    super(new SwordBehavior(), id, new ImageIcon("images/champion.png"));
  }

  public String toString() {
    return "Champion";
  }
}