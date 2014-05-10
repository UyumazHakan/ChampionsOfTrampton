package Map;

import java.util.ArrayList;

public class MapFactory {

  public MapFactory() {

  }

  public Map createMap(int numRooms, ArrayList characters) {
    return new Map(numRooms, characters);
  }

}