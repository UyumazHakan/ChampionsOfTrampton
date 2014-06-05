package PlayableCharacter;

import Weapon.WeaponBehavior;

import javax.swing.*;

public class Hero extends PlayableCharacter {
  private Hero target;
  private int maxTurn;
  private int presentTurn;
  private int id;
  private ImageIcon icon;

  public void setTarget(Hero target) {
    this.target = target;
  }

  public int getPresentTurn() {
    return presentTurn;
  }

  public ImageIcon getIcon() {
    return icon;
  }

  public Hero getTarget() {
    return target;
  }

  public Hero(int x, int y, int roomNumber, WeaponBehavior weaponBehavior,int id,ImageIcon icon) {
    super(x, y, roomNumber, weaponBehavior);
    maxTurn=20;
    presentTurn=20;
    this.id=id;
    this.icon=icon;


  }
  public void resetTurn(){
    presentTurn=maxTurn;
  }
  public void decreaseTurn(){
    presentTurn--;
  }


}