package PlayableCharacter;

import Weapon.AxeBehavior;

import javax.swing.*;

public class Warlord extends Hero {
  public Warlord(int id) {
    super(new AxeBehavior(), id, new ImageIcon("images/warlord.png"));
  }

  public String toString() {
    return "Warlord";
  }
}