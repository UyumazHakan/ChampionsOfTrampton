package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Hakan on 8.5.2014.
 */
public class KeyboardController extends KeyAdapter {
  private GameEngine gameEngine;

  public KeyboardController(GameEngine gameEngine) {
    this.gameEngine = gameEngine;

  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
      gameEngine.togglePauseGame();
    }
  }

}
