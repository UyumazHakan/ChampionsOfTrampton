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

  public PlayableCharacter getCharacterAtLocation(int x, int y) {
    for (PlayableCharacter character : characters)
      if (character.getX() == x && character.getY() == y)
        return character;
    return null;
  }

  public void eraseCharacters() {
    teleportAllCharacters();
    characters.clear();
  }

  private void teleportAllCharacters() {
    for (PlayableCharacter character : characters) {
      for (Door door : doors) {
        boolean isSameX = door.getXForRoom(roomNumber) == character.getX();
        boolean isSameY = door.getYForRoom(roomNumber) == character.getY();
        if (isSameX && isSameY) {
          door.enterDoor(character, roomNumber);
        }
      }
    }
  }

  public void addCharacter(PlayableCharacter newCharacter) {
    characters.add(newCharacter);
  }
}
