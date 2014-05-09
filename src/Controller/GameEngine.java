package Controller;

import Controller.GameController;
import GUI.GameScreen;

import java.util.Vector;

public class GameEngine {
  private GameScreen screen;
 public GameEngine(GameScreen screen){
   this.screen=screen;
   screen.setVisible(true);
   screen.setDefaultCloseOperation(GameScreen.EXIT_ON_CLOSE);
   screen.setEngine(this);
 }
  public void startGame(){
    screen.showControlPanel();
    screen.hidePauseMenu();
    screen.hideMainMenu();

  }
  public void togglePauseGame(){
    screen.toggleControlPanel();
    screen.togglePauseMenu();
  }
  public void resetFocusToFrame(){
    screen.requestFocusInWindow();
  }
}