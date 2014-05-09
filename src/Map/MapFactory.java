package Map;

import java.util.Vector;

public class MapFactory {

  public MapFactory(){

  }
  public Map createMap(int numRooms){
    return new Map(numRooms);
  }

}