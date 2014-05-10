package Weapon;

import PlayableCharacter.PlayableCharacter;

public class Weapon {

  public PlayableCharacter owner;
  public WeaponBehavior behaviour;

  public Weapon(PlayableCharacter owner) {
    this.owner = owner;
  }

  public PlayableCharacter getOwner() {
    return owner;
  }

  public void setOwner(PlayableCharacter owner) {
    this.owner = owner;
  }

  public WeaponBehavior getBehaviour() {
    return behaviour;
  }

  public void setWeaponBehaviour(WeaponBehavior behaviour) {
    this.behaviour = behaviour;
  }
}