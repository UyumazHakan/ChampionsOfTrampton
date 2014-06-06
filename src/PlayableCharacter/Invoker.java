package PlayableCharacter;

import Weapon.FistBehavior;

import javax.swing.*;

public class Invoker extends Hero {
  public Invoker(int id) {
    super(new FistBehavior(), id, new ImageIcon("images/invoker.png"));
  }
  public String toString(){
    return "Invoker";
  }
}