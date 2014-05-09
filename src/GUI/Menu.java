package GUI;

import Controller.GameEngine;

import javax.swing.*;

/**
 * Created by Hakan on 9.5.2014.
 */
public abstract class Menu extends JPanel {
  GameEngine gameEngine;

  public Menu() {
    setLayout(null);
  }

  public void setGameEngine(GameEngine gameEngine){
    this.gameEngine=gameEngine;
  }

  abstract void setButtonLocations();

  abstract void initButtons();

  abstract void addButtons();
}
