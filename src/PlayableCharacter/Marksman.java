package PlayableCharacter;

import Weapon.BowBehavior;

import javax.swing.*;

public class Marksman extends Hero {
  public Marksman(int id) {
    super(new BowBehavior(), id, new ImageIcon("images/marksman.png"));
  }
}