package Controller;

import Command.*;
import GUI.GameScreen;
import Map.Map;
import Map.MapFactory;
import Map.Room;
import PlayableCharacter.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class GameEngine {
  private final int NUMBER_OF_ROOMS = 10;
  private final int TARGET_KILL_EXPERIENCE = 5;
  private final int MURDERER_KILL_EXPERIENCE = 2;
  private final int INNOCENT_KILL_EXPERIENCE = -3;
  private final int GAME_FINISH_LIMIT = 12;
  private final int NUMBER_OF_PLAYERS = 5;
  private GameScreen screen;
  private Map map;
  private Hero playersHero;
  private ArrayList<Hero> heroes;
  private ArrayList<Hero> allHeroes;
  private int currentPlayerID = 0;

  public GameEngine(GameScreen screen) {
    heroes = new ArrayList<Hero>();
    initAllHeroes();
    addHeroes(NUMBER_OF_PLAYERS);
    playersHero = heroes.get(currentPlayerID);
    this.screen = screen;
    setScreenSettings();
    map = new MapFactory().createMap(NUMBER_OF_ROOMS, heroes);
    spawnHeroes();
    updateMapScreen();
    screen.getControlPanel().changeTurn(getCurrentHeroTurn());
    screen.getControlPanel().setTarget(getTargetIcon());
    screen.getControlPanel().setExperience(getCurrentHeroExperience());

  }

  private void initAllHeroes() {
    allHeroes = new ArrayList<Hero>();
    allHeroes.add(new Warlord(0));
    allHeroes.add(new Marksman(1));
    allHeroes.add(new Phantom(2));
    allHeroes.add(new Champion(3));
    allHeroes.add(new Invoker(4));
  }

  private void setScreenSettings() {
    screen.setVisible(true);
    screen.setDefaultCloseOperation(GameScreen.EXIT_ON_CLOSE);
    screen.setGameEngine(this);
    screen.addControllers();
  }

  private void addHeroes(int numHeroes) {
    for (int i = 0; i < numHeroes; i++)
      heroes.add(allHeroes.get(i));
    setTargets();

  }

  private void setTargets() {
    int numHeroes = heroes.size();
    for (int i = 0; i < numHeroes; i++) {
      setRandomTarget(heroes.get(i));
    }
  }

  private void setRandomTarget(Hero hero) {
    int numHeroes = heroes.size();
    Random random = new Random();
    Hero target = hero;
    while (target == hero) {
      target = heroes.get(random.nextInt(numHeroes));
      new ChangeTargetCommand(hero, target).networkExecute();
    }
  }

  private void spawnHeroes() {
    for (Hero hero : heroes) {
      new SpawnCommand(hero, map).networkExecute();
    }
  }

  public void startGame() {
    screen.showControlPanel();
    screen.hidePauseMenu();
    screen.hideMainMenu();
    screen.showMapScreen();

  }

  public void updateMapScreen() {
    map.update();
    int roomNumber = playersHero.getRoomNumber();
    Room room = map.getRoom(roomNumber);
    screen.setupRoom(room);
    System.out.println("herox:" + playersHero.getX() + " heroy:" + playersHero.getY() + " room:" + playersHero.getRoomNumber());
  }

  public void takeActionUp() {
    int x = playersHero.getX();
    int y = playersHero.getY();
    int room = playersHero.getRoomNumber();
    if (!haveNorthNeighbor())
      stepUpHero();
    else
      killCharacter(x, y - 1, room);
  }


  public void takeActionDown() {
    int x = playersHero.getX();
    int y = playersHero.getY();
    int room = playersHero.getRoomNumber();
    if (!haveSouthNeighbor())
      stepDownHero();
    else
      killCharacter(x, y + 1, room);
  }

  public void takeActionLeft() {
    int x = playersHero.getX();
    int y = playersHero.getY();
    int room = playersHero.getRoomNumber();
    if (!haveWestNeighbor())
      stepLeftHero();
    else
      killCharacter(x - 1, y, room);
  }

  public void takeActionRight() {
    int x = playersHero.getX();
    int y = playersHero.getY();
    int room = playersHero.getRoomNumber();
    if (!haveEastNeighbor())
      stepRightHero();
    else
      killCharacter(x + 1, y, room);
  }

  private void killCharacter(int x, int y, int room) {
    PlayableCharacter neighbor = map.getCharacterAtLocation(x, y, room);
    new KillCharacterCommand(playersHero, neighbor).networkExecute();
    new SpawnCommand(neighbor, map).networkExecute();
    gainExperience(neighbor);
    setRandomTarget(playersHero);
    setRandomTarget((Hero) neighbor);
  }

  private void gainExperience(PlayableCharacter neighbor) {
    if (playersHero.getTarget() == neighbor)
      new GainExperienceCommand(playersHero, TARGET_KILL_EXPERIENCE).networkExecute();
    else if (((Hero) neighbor).getTarget() == playersHero)
      new GainExperienceCommand(playersHero, MURDERER_KILL_EXPERIENCE).networkExecute();
    else
      new GainExperienceCommand(playersHero, INNOCENT_KILL_EXPERIENCE).networkExecute();
    screen.getControlPanel().setExperience(getCurrentHeroExperience());
    checkFinishedGame();
  }

  private void checkFinishedGame() {
    if (playersHero.getExperience() >= GAME_FINISH_LIMIT)
      new EndGameCommand(heroes, screen).networkExecute();
  }

  public boolean haveNorthNeighbor() {
    int x = playersHero.getX();
    int y = playersHero.getY();
    int room = playersHero.getRoomNumber();
    return map.getCharacterAtLocation(x, y - 1, room) != null;
  }

  public boolean haveSouthNeighbor() {
    int x = playersHero.getX();
    int y = playersHero.getY();
    int room = playersHero.getRoomNumber();
    return map.getCharacterAtLocation(x, y + 1, room) != null;
  }

  public boolean haveWestNeighbor() {
    int x = playersHero.getX();
    int y = playersHero.getY();
    int room = playersHero.getRoomNumber();
    return map.getCharacterAtLocation(x - 1, y, room) != null;
  }

  public boolean haveEastNeighbor() {
    int x = playersHero.getX();
    int y = playersHero.getY();
    int room = playersHero.getRoomNumber();
    return map.getCharacterAtLocation(x + 1, y, room) != null;
  }

  public void stepUpHero() {
    moveYCharacter(-1, playersHero);
  }

  public void stepDownHero() {
    moveYCharacter(1, playersHero);
  }

  public void stepLeftHero() {
    moveXCharacter(-1, playersHero);
  }

  public void stepRightHero() {
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
    else if (characterNewY > characterRoom.getHeight() - 1)
      new SetLocationYCommand(characterRoom.getHeight() - 1, character).networkExecute();
    else
      new MoveCharacterYCommand(y, character).networkExecute();
  }

  private void moveXCharacter(int x, Hero character) {
    Room characterRoom = map.getRoom(character.getRoomNumber());
    int characterNewX = character.getX() + x;
    if (characterNewX < 0)
      new SetLocationXCommand(0, character).networkExecute();
    else if (characterNewX > characterRoom.getWidth() - 1)
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

  public void updateCurrentHero() {
    if (playersHero.getPresentTurn() == 0) {
      playersHero.resetTurn();
      currentPlayerID = (currentPlayerID + 1) % heroes.size();
      playersHero = heroes.get(currentPlayerID);
      updateMapScreen();
    }
  }

  public int getCurrentHeroTurn() {
    return playersHero.getPresentTurn();
  }

  public ImageIcon getTargetIcon() {
    return playersHero.getTarget().getIcon();
  }

  public int getCurrentHeroExperience() {
    return playersHero.getExperience();
  }
}