package Controller;

import java.awt.event.ActionListener;

/**
 * Created by Hakan on 10.5.2014.
 */
public abstract class MenuController implements ActionListener {
  protected GameEngine gameEngine;

  public MenuController(GameEngine gameEngine) {
    this.gameEngine = gameEngine;
  }
}
