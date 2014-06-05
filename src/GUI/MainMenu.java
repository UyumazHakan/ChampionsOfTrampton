package GUI;

import Controller.MainMenuController;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends Menu {
  private final int START_HEIGHT = 50, START_WIDTH = 80, START_X = 160, START_Y = 230;
  private final int EXIT_HEIGHT = 50, EXIT_WIDTH = 80, EXIT_X = 160, EXIT_Y = 300;
  private JButton exit;
  private JButton start;

  public MainMenu() {
    super();
    setBackground(Color.white);
    setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    initButtons();
    setButtonLocations();
    addButtons();
  }

  void setButtonLocations() {
    exit.setBounds(EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT);
    start.setBounds(START_X, START_Y, START_WIDTH, START_HEIGHT);
  }

  void initButtons() {
    start = new JButton("START");
    exit = new JButton("EXIT");
  }

  public void addControllers() {
    exit.addActionListener(new MainMenuController(gameEngine));
    start.addActionListener(new MainMenuController(gameEngine));
  }

  void addButtons() {
    add(exit);
    add(start);

  }


}