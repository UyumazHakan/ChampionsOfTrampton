package PlayableCharacter;

import Weapon.KnifeBehavior;

import javax.swing.*;

public class Phantom extends Hero {
  public Phantom(int id) {
    super(new KnifeBehavior(), id, new ImageIcon("images/phantom.png"));
  }
}