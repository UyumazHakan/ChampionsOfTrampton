package Map;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Map {
  private ArrayList<Room> rooms;
  private     Random random;

  public void Map(int numRooms){
    random=new Random();
    createRooms(numRooms);
    createRoomConnections();
  }
  private void createRooms(int numRooms){
    for(int i=0;i<numRooms;i++){
      int width=random.nextInt(10)+10;
      int height=random.nextInt(10)+10;
      rooms.add(new Room(width,height));
    }
  }
  private void createRoomConnections(){
    for(int i=0;i<rooms.size();i++)
      while(rooms.get(i).getNumDoors()<2)
        createDoor(i);
  }
  private void createDoor(int roomNumber){
    int otherRoomNumber = random.nextInt(rooms.size());
    Room room1=rooms.get(roomNumber);
    Room room2=rooms.get(otherRoomNumber);
    int x1=random.nextInt(room1.getWidth());
    int y1=random.nextInt(room1.getHeight());
    int x2=random.nextInt(room2.getWidth());
    int y2=random.nextInt(room2.getHeight());
    Door door=new Door(x1,y1,x2,y2,roomNumber,otherRoomNumber);
    room1.addDoor(door);
    room2.addDoor(door);
  }
}