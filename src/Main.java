import Controller.GameEngine;
import GUI.GameScreen;

/**
 * Created by Hakan on 9.5.2014.
 */
public class Main {
  public static void main(String[] args){
    GameScreen gameScreen= new GameScreen();
    GameEngine gameEngine=new GameEngine(gameScreen);

  }
}
