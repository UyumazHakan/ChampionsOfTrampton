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
        addDoor(i);
  }

  private void addDoor(int roomNumber) {
    int otherRoomNumber = random.nextInt(rooms.size());
    if (otherRoomNumber == roomNumber)
      otherRoomNumber = (otherRoomNumber + 1) % rooms.size();
    Room room1 = rooms.get(roomNumber);
    Room room2 = rooms.get(otherRoomNumber);
    Door door = createDoor(roomNumber, otherRoomNumber, room1, room2);
    room1.addDoor(door);
    room2.addDoor(door);
  }

  private Door createDoor(int roomNumber, int otherRoomNumber, Room room1, Room room2) {
    int x1, x2, y1, y2;
    x1 = random.nextInt(room1.getWidth() - 1);
    y1 = random.nextInt(room1.getHeight() - 1);
    x2 = random.nextInt(room2.getWidth() - 1);
    y2 = random.nextInt(room2.getHeight() - 1);
    return new Door(x1, y1, x2, y2, roomNumber, otherRoomNumber);
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