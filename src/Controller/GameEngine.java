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

import javax.swing.*;
import java.util.ArrayList;

public class GameEngine {
  private GameScreen screen;
  private Map map;
  private Hero playersHero;
  private ArrayList<Hero> characters;
  private int currentPlayerID;

  public GameEngine(GameScreen screen) {
    currentPlayerID=0;
    characters=new ArrayList<Hero>();
    addHeroes(3);
    playersHero=characters.get(currentPlayerID);
    this.screen = screen;
    screen.setVisible(true);
    screen.setDefaultCloseOperation(GameScreen.EXIT_ON_CLOSE);
    screen.setGameEngine(this);
    screen.addControllers();
    map = new MapFactory().createMap(10,characters);
    screen.getControlPanel().changeTurn(getCurrentHeroTurn());
    screen.getControlPanel().setTarget(getTargetIcon());

  }

  private void addHeroes(int numHeroes) {
    characters.add(new Warlord(5,5,5,0));
    characters.add(new Marksman(1,1,1,0));
    characters.add(new Phantom(2,2,2,0));
    for (int i=0;i<numHeroes;i++)
      characters.get(i).setTarget(characters.get((i+1)%numHeroes));

  }

  public void startGame() {
    screen.showControlPanel();
    screen.hidePauseMenu();
    screen.hideMainMenu();
    screen.showMapScreen();
    Room firstRoom = map.getRoom(playersHero.getRoomNumber());
    screen.setupRoom(firstRoom);

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
  private void moveCharacter(int x, int y, Hero character) {
    moveXCharacter(x, character);
    moveYCharacter(y, character);
  }

  private void moveYCharacter(int y, Hero character) {
    Room characterRoom = map.getRoom(character.getRoomNumber());
    int characterNewY = character.getY() + y;
    if (characterNewY < 0)
      new SetLocationYCommand(0, character).networkExecute();
    else if (characterNewY > characterRoom.getHeight()-1)
      new SetLocationYCommand(characterRoom.getHeight() - 1, character).networkExecute();
    else
      new MoveCharacterYCommand(y, character).networkExecute();
  }

  private void moveXCharacter(int x, Hero character) {
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
  public void updateCurrentHero(){
    if(playersHero.getPresentTurn()==0){
      playersHero.resetTurn();
      currentPlayerID=(currentPlayerID+1)%characters.size();
      playersHero=characters.get(currentPlayerID);
      updateMapScreen();
    }
  }
  public int getCurrentHeroTurn(){
    return playersHero.getPresentTurn();
  }
  public ImageIcon getTargetIcon(){
    return playersHero.getTarget().getIcon();
  }
}