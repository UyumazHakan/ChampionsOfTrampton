package Command;

import Map.Map;
import Map.Room;
import PlayableCharacter.PlayableCharacter;

import java.util.Random;

/**
 * Created by UyumazHakan on 06.06.2014.
 */
public class SpawnCommand implements Command {
  private PlayableCharacter character;
  private Map map;

  public SpawnCommand(PlayableCharacter character, Map map) {
    this.character = character;
    this.map = map;
  }

  @Override
  public void execute() {
    Random random = new Random();
    int numRooms = map.getNumRooms();
    int spawnRoom = random.nextInt(numRooms - 1);
    Room room = map.getRoom(spawnRoom);
    int spawnX = random.nextInt(room.getWidth() - 1);
    int spawnY = random.nextInt(room.getHeight() - 1);
    character.changeRoom(spawnX, spawnY, spawnRoom);
  }

  public void networkExecute() {
    execute();
  }
}
