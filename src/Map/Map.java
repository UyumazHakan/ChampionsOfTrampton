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
    int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
    Room room1 = rooms.get(roomNumber);
    Room room2 = rooms.get(otherRoomNumber);
    switch (random.nextInt(4)) {
      case 0:
        x1 = 0;
        y1 = random.nextInt(room1.getHeight() - 1);
        break;
      case 1:
        x1 = random.nextInt(room1.getWidth() - 1);
        y1 = 0;
        break;
      case 2:
        x1 = room1.getWidth() - 1;
        y1 = random.nextInt(room1.getHeight() - 1);
        break;
      case 3:
        x1 = random.nextInt(room1.getWidth() - 1);
        y1 = room1.getHeight() - 1;
        break;
    }
    switch (random.nextInt(4)) {
      case 0:
        x2 = 0;
        y2 = random.nextInt(room2.getHeight() - 1);
        break;
      case 1:
        x2 = random.nextInt(room2.getWidth() - 1);
        y2 = 0;
        break;
      case 2:
        x2 = room2.getWidth() - 1;
        y2 = random.nextInt(room2.getHeight() - 1);
        break;
      case 3:
        x2 = random.nextInt(room2.getWidth() - 1);
        y2 = room1.getHeight() - 1;
        break;
    }
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

  private void eraseCharacters() {
    for (Room room : rooms)
      room.eraseCharacters();
  }
}