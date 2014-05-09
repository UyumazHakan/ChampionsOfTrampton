package GUI;

import Controller.GameEngine;
import Controller.PauseMenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hakan on 8.5.2014.
 */
public class PauseMenu extends Menu {
  private final int EXIT_HEIGHT = 50, EXIT_WIDTH = 80, EXIT_X = 10, EXIT_Y = 450;

  private JButton exit;

  public PauseMenu() {
    super();
    setBackground(Color.GREEN);
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
