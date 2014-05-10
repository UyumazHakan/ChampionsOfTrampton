package PlayableCharacter;

import Weapon.*;

public class Brigand extends Hero {
  public Brigand(int x, int y, int roomNumber) {
    super(x, y, roomNumber, new KnifeBehavior());
  }
}