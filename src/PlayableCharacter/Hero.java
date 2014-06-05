package PlayableCharacter;

import Weapon.WeaponBehavior;

import javax.swing.*;

public class Hero extends PlayableCharacter {
  private Hero target;
  private int maxTurn;
  private int presentTurn;
  private int id;
  private ImageIcon icon;
  private int experience;

  public Hero(WeaponBehavior weaponBehavior, int id, ImageIcon icon) {
    super(weaponBehavior);
    maxTurn = 20;
    presentTurn = 20;
    experience = 0;
    this.id = id;
    this.icon = icon;


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

  public void setTarget(Hero target) {
    this.target = target;
  }

  public void resetTurn() {
    presentTurn = maxTurn;
  }

  public void decreaseTurn() {
    presentTurn--;
  }

  public void addExperience(int newExperience) {
    this.experience += newExperience;
  }

  public int getExperience() {
    return experience;
  }
}