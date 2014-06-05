package GUI;

import Controller.PauseMenuController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Hakan on 8.5.2014.
 */
public class PauseMenu extends Menu {
  private final int EXIT_HEIGHT = 50, EXIT_WIDTH = 80, EXIT_X = 60, EXIT_Y = 225;

  private JButton exit;

  public PauseMenu() {
    super();
    setBackground(Color.white);
    setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
    initButtons();
    setButtonLocations();
    addButtons();
  }

  void setButtonLocations() {
    exit.setBounds(EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT);
  }

  void initButtons() {
    exit = new JButton("EXIT");

  }

  void addButtons() {
    add(exit);

  }

  @Override
  public void addControllers() {
    exit.addActionListener(new PauseMenuController(gameEngine));
  }


}
