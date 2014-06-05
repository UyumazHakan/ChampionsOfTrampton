package PlayableCharacter;

import Weapon.*;

public class Brigand extends Hero {
  public Brigand(int x, int y, int roomNumber,int id) {
    super(x, y, roomNumber, new KnifeBehavior(),id,null);
  }
}