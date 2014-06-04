package Map;

import PlayableCharacter.PlayableCharacter;

import java.util.ArrayList;

/**
 * Created by Hakan on 3.5.2014.
 */
public class Room {
  private ArrayList<Tower> towers;
  private ArrayList<PlayableCharacter> characters;

  private ArrayList<Door> doors;
  private int width;
  private int height;
  private int roomNumber;

  public Room(int width, int height, int roomNumber) {
    this.characters = new ArrayList<PlayableCharacter>();
    this.towers = new ArrayList<Tower>();
    this.doors = new ArrayList<Door>();
    this.width = width;
    this.height = height;
    this.roomNumber = roomNumber;
  }

  public ArrayList<Tower> getTowers() {
    return towers;
  }

  public ArrayList<Door> getDoors() {
    return doors;
  }

  public ArrayList<PlayableCharacter> getCharacters() {
    return characters;
  }

  public int getRoomNumber() {
    return roomNumber;
  }

  public void addCommonTower(int x, int y) {
    towers.add(new CommonTower(x, y));
  }

  public void addDoor(Door door) {
    doors.add(door);
  }

  public int getNumDoors() {
    return doors.size();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void eraseCharacters() {
    for (PlayableCharacter character : characters) {
      for (Door door : doors) {
        boolean isSameX = door.getXForRoom(roomNumber) == character.getX();
        boolean isSameY = door.getYForRoom(roomNumber) == character.getY();
        if (isSameX && isSameY) {
          door.enterDoor(character, roomNumber);
        }
      }
    }
    characters.clear();
  }

  public void addCharacter(PlayableCharacter newCharacter) {
    characters.add(newCharacter);
  }
}
