package Map;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Map {
  private ArrayList<Room> rooms;
  private     Random random;

  public Map(int numRooms){
    random=new Random();
    rooms=new ArrayList<Room>();
    createRooms(numRooms);
    createRoomConnections();
  }
  public Room getRoom(int roomNum){
    return rooms.get(roomNum);
  }
  private void createRooms(int numRooms){
    for(int i=0;i<numRooms;i++){
      int width=random.nextInt(10)+10;
      int height=random.nextInt(10)+10;
      rooms.add(new Room(width,height,i));
    }
  }
  private void createRoomConnections(){
    for(int i=0;i<rooms.size();i++)
      while(rooms.get(i).getNumDoors()<2)
        createDoor(i);
  }
  private void createDoor(int roomNumber){
    int otherRoomNumber = random.nextInt(rooms.size());
    int x1=0,x2=0,y1=0,y2=0;
    Room room1=rooms.get(roomNumber);
    Room room2=rooms.get(otherRoomNumber);
    switch(random.nextInt(4)){
      case 0:
        x1=0;
        y1=random.nextInt(room1.getHeight());
        break;
      case 1:
        x1=0;
        y1=random.nextInt(room1.getHeight());
        break;
      case 2:
        x1=room1.getWidth()-1;
        y1=random.nextInt(room1.getHeight());
        break;
      case 3:
        x1=random.nextInt(room1.getWidth());
        y1=room1.getHeight()-1;
        break;
    }
    switch(random.nextInt(4)){
      case 0:
        x2=0;
        y2=random.nextInt(room2.getHeight());
        break;
      case 1:
        x2=0;
        y2=random.nextInt(room2.getHeight());
        break;
      case 2:
        x2=room2.getWidth()-1;
        y2=random.nextInt(room2.getHeight());
        break;
      case 3:
        x2=random.nextInt(room2.getWidth());
        y2=room1.getHeight()-1;
        break;
    }
    Door door=new Door(x1,y1,x2,y2,roomNumber,otherRoomNumber);
    room1.addDoor(door);
    room2.addDoor(door);
  }
}