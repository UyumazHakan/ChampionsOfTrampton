package Controller;

import Command.MoveCharacterXCommand;
import Command.MoveCharacterYCommand;
import Command.SetLocationXCommand;
import Command.SetLocationYCommand;
import GUI.GameScreen;
import Map.Map;
import Map.MapFactory;
import Map.Room;
import PlayableCharacter.*;

import java.util.ArrayList;

public class GameEngine {
  private GameScreen screen;
  private Map map;
  private Hero playersHero;
  ArrayList<PlayableCharacter> characters;

  public GameEngine(GameScreen screen) {
    characters=new ArrayList<PlayableCharacter>();
    this.playersHero=new Brigand(2,2,1);
    characters.add(playersHero);
    this.screen = screen;
    screen.setVisible(true);
    screen.setDefaultCloseOperation(GameScreen.EXIT_ON_CLOSE);
    screen.setGameEngine(this);
    screen.addControllers();
    map = new MapFactory().createMap(10,characters);

  }

  public void startGame() {
    screen.showControlPanel();
    screen.hidePauseMenu();
    screen.hideMainMenu();
    screen.showMapScreen();
    Room tryRoom = map.getRoom(1);
    screen.setupRoom(tryRoom);

  }
  public void updateMapScreen(){


    map.update();
      int roomNumber = playersHero.getRoomNumber();
      Room room =  map.getRoom(roomNumber);
    screen.setupRoom(room);
    System.out.println("herox:"+playersHero.getX()+" heroy:"+playersHero.getY()+" room:"+playersHero.getRoomNumber());
  }
  public void stepUpHero(){
    moveYCharacter(-1, playersHero);
  }
  public void stepDownHero(){
    moveYCharacter(1,playersHero);
  }
  public void stepLeftHero(){
    moveXCharacter(-1, playersHero);
  }
  public void stepRightHero(){
    moveXCharacter(1, playersHero);
  }
  private void moveCharacter(int x, int y, PlayableCharacter character) {
    moveXCharacter(x, character);
    moveYCharacter(y, character);
  }

  private void moveYCharacter(int y, PlayableCharacter character) {
    Room characterRoom = map.getRoom(character.getRoomNumber());
    int characterNewY = character.getY() + y;
    if (characterNewY < 0)
      new SetLocationYCommand(0, character).networkExecute();
    else if (characterNewY > characterRoom.getHeight()-1)
      new SetLocationYCommand(characterRoom.getHeight() - 1, character).networkExecute();
    else
      new MoveCharacterYCommand(y, character).networkExecute();
  }

  private void moveXCharacter(int x, PlayableCharacter character) {
    Room characterRoom = map.getRoom(character.getRoomNumber());
    int characterNewX = character.getX() + x;
    if (characterNewX < 0)
      new SetLocationXCommand(0, character).networkExecute();
    else if (characterNewX > characterRoom.getWidth()-1)
      new SetLocationXCommand(characterRoom.getWidth() - 1, character).networkExecute();
    else
      new MoveCharacterXCommand(x, character).networkExecute();
  }

  public void togglePauseGame() {
    screen.toggleControlPanel();
    screen.togglePauseMenu();
  }

  public void resetFocusToFrame() {
    screen.requestFocusInWindow();
  }
}