package Command;

import PlayableCharacter.PlayableCharacter;

/**
 * Created by UyumazHakan on 06.06.2014.
 */
public class ChangeRoomCommand implements Command {
  private PlayableCharacter character;
  private int newX, newY, newRoom;

  public ChangeRoomCommand(PlayableCharacter character, int newX, int newY, int newRoom) {
    this.character = character;
    this.newX = newX;
    this.newY = newY;
    this.newRoom = newRoom;
  }

  @Override
  public void execute() {
    character.changeRoom(newX, newY, newRoom);
  }

  public void networkExecute() {
    execute();
  }
}
