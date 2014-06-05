package PlayableCharacter;

import Weapon.WeaponBehavior;

public class Hero extends PlayableCharacter {
  private PlayableCharacter target;
  private int maxTurn;
  private int presentTurn;

  public void setTarget(PlayableCharacter target) {
    this.target = target;
  }

  public int getPresentTurn() {
    return presentTurn;
  }

  public Hero(int x, int y, int roomNumber, WeaponBehavior weaponBehavior) {
    super(x, y, roomNumber, weaponBehavior);
    maxTurn=5;
    presentTurn=5;

  }
  public void resetTurn(){
    presentTurn=maxTurn;
  }
  public void decreaseTurn(){
    presentTurn--;
  }


}