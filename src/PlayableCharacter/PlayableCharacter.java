package PlayableCharacter;

import Condition.*;
import Weapon.*;

public class PlayableCharacter {

  private Weapon weapon;
  private HealthStatus healthStatus;
  private int x,y, roomNumber;

  public PlayableCharacter(int x, int y, int roomNumber,
                           WeaponBehavior weaponBehavior) {
    this.x = x;
    this.y = y;
    this.roomNumber = roomNumber;
    this.weapon=new Weapon(this);
    this.healthStatus=new HealthyCondition();

  }
  public void changeWeaponBehavior(WeaponBehavior weaponBehavior){
    this.weapon.setWeaponBehaviour(weaponBehavior);
  }
  public void move(int dx,int dy){
    this.x+=dx;
    this.y+=dy;
  }
  public void setLocation(int x,int y){
    this.x=x;
    this.y=y;
  }
  public void changeRoom(int x,int y, int roomNumber){
    this.x=x;
    this.y=y;
    this.roomNumber=roomNumber;
  }
}