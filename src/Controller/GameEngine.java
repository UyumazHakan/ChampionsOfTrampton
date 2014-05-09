package Controller;

import GUI.GameScreen;
import Map.MapFactory;
import Map.Room;

public class GameEngine {
  private GameScreen screen;
 public GameEngine(GameScreen screen){
   this.screen=screen;
   screen.setVisible(true);
   screen.setDefaultCloseOperation(GameScreen.EXIT_ON_CLOSE);
   screen.setGameEngine(this);
   screen.addControllers();
 }

  public void startGame(){
    screen.showControlPanel();
    screen.hidePauseMenu();
    screen.hideMainMenu();
    screen.showMapScreen();
    Room tryRoom=new MapFactory().createMap(10).getRoom(1);
    screen.setupRoom(tryRoom);

  }
  public void togglePauseGame(){
    screen.toggleControlPanel();
    screen.togglePauseMenu();
  }
  public void resetFocusToFrame(){
    screen.requestFocusInWindow();
  }
}