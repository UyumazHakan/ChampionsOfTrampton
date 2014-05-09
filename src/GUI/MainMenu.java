package GUI;

import Controller.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Menu {
  private final int START_HEIGHT = 50, START_WIDTH = 80, START_X = 10, START_Y = 50;
  private final int EXIT_HEIGHT = 50, EXIT_WIDTH = 80, EXIT_X = 10, EXIT_Y = 450;
  private JButton exit;
  private JButton start;

  public MainMenu() {
    super();
    setBackground(Color.GREEN);
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
    exit.addActionListener(new ButtonHandler());
    start.addActionListener(new ButtonHandler());
  }

  void addButtons() {
    add(exit);
    add(start);

  }

  class ButtonHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      String buttonText = ((JButton) e.getSource()).getText();
      gameEngine.resetFocusToFrame();
      if (buttonText.equals("EXIT"))
        System.exit(1);
      else if (buttonText.equals("START"))
        gameEngine.startGame();
    }
  }
}