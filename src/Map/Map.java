package Map;

import PlayableCharacter.PlayableCharacter;

import java.util.ArrayList;
import java.util.Random;

public class Map {
  private ArrayList<Room> rooms;
  private ArrayList<PlayableCharacter> characters;
  private Random random;

  public Map(int numRooms, ArrayList<PlayableCharacter> characters) {
    this.characters = characters;
    this.random = new Random();
    this.rooms = new ArrayList<Room>();
    createRooms(numRooms);
    createRoomConnections();
    addCharacters();
  }

  public Room getRoom(int roomNum) {
    return rooms.get(roomNum);
  }

  public int getNumRooms() {
    return rooms.size();
  }

  public ArrayList<PlayableCharacter> getCharacters() {
    return characters;
  }

  private void createRooms(int numRooms) {
    for (int i = 0; i < numRooms; i++) {
      int width = random.nextInt(10) + 10;
      int height = random.nextInt(10) + 10;
      rooms.add(new Room(width, height, i));
    }
  }

  private void createRoomConnections() {
    for (int i = 0; i < rooms.size(); i++)
      while (rooms.get(i).getNumDoors() < 2)
        createDoor(i);
  }

  //TODO Refactor
  private void createDoor(int roomNumber) {
    int otherRoomNumber = random.nextInt(rooms.size());
    if (otherRoomNumber == roomNumber)
      otherRoomNumber = (otherRoomNumber + 1) % rooms.size();
    int x1, x2, y1, y2;
    Room room1 = rooms.get(roomNumber);
    Room room2 = rooms.get(otherRoomNumber);
    x1 = random.nextInt(room1.getWidth() - 1);
    y1 = random.nextInt(room1.getHeight() - 1);
    x2 = random.nextInt(room2.getWidth() - 1);
    y2 = random.nextInt(room2.getHeight() - 1);
    Door door = new Door(x1, y1, x2, y2, roomNumber, otherRoomNumber);
    room1.addDoor(door);
    room2.addDoor(door);
  }

  public void update() {
    eraseCharacters();
    addCharacters();
  }

  private void addCharacters() {
    for (PlayableCharacter character : characters) {
      int roomNumber = character.getRoomNumber();
      Room room = rooms.get(roomNumber);
      room.addCharacter(character);
    }
  }

  public PlayableCharacter getCharacterAtLocation(int x, int y, int room) {
    return rooms.get(room).getCharacterAtLocation(x, y);
  }

  private void eraseCharacters() {
    for (Room room : rooms)
      room.eraseCharacters();
  }
}