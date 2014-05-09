package Map;

import java.util.ArrayList;

/**
 * Created by Hakan on 3.5.2014.
 */
public class Room {
  private ArrayList<Tower> towers;
  private ArrayList<Door> doors;
  private int width;
  private int height;
  public Room(int width, int height) {
    towers=new ArrayList<Tower>();
    doors=new ArrayList<Door>();
    this.width = width;
    this.height = height;
  }
  public void addCommonTower(int x,int y){
    towers.add(new CommonTower(x,y));
  }
  public void addDoor(Door door){
    doors.add(door);
  }
  public int getNumDoors(){
    return doors.size();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
