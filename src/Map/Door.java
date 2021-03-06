package Map;

import Command.ChangeRoomCommand;
import PlayableCharacter.PlayableCharacter;

/**
 * Created by Hakan on 3.5.2014.
 */
public class Door {
  int x1, y1, x2, y2;
  int room1, room2;

  public Door(int x1, int y1, int x2, int y2, int room1, int room2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.room1 = room1;
    this.room2 = room2;
  }

  public void enterDoor(PlayableCharacter character, int roomNumber) {
    if (roomNumber == room1)
      new ChangeRoomCommand(character, x2, y2, room2).networkExecute();
    else if (roomNumber == room2)
      new ChangeRoomCommand(character, x1, y1, room1).networkExecute();
  }

  public int getXForRoom(int roomNumber) {
    if (roomNumber == room1)
      return x1;
    else if (roomNumber == room2)
      return x2;
    else
      return -1;
  }

  public int getYForRoom(int roomNumber) {
    if (roomNumber == room1)
      return y1;
    else if (roomNumber == room2)
      return y2;
    else
      return -1;
  }
}
