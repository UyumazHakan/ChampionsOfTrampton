package PlayableCharacter;

import Condition.HealthStatus;
import Condition.HealthyCondition;
import Weapon.Weapon;
import Weapon.WeaponBehavior;

public class PlayableCharacter {

  private Weapon weapon;
  private HealthStatus healthStatus;
  private int x, y, roomNumber;


  public PlayableCharacter(WeaponBehavior weaponBehavior) {
    this.weapon = new Weapon(this);
    this.healthStatus = new HealthyCondition();

  }

  public void changeWeaponBehavior(WeaponBehavior weaponBehavior) {
    this.weapon.setWeaponBehaviour(weaponBehavior);
  }

  public void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  public void moveX(int dx) {
    this.x += dx;
  }

  public void moveY(int dy) {
    this.y += dy;
  }

  public void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void changeRoom(int x, int y, int roomNumber) {
    this.x = x;
    this.y = y;
    this.roomNumber = roomNumber;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getRoomNumber() {
    return roomNumber;
  }
}