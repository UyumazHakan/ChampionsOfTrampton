package GUI;

import Controller.GameEngine;

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
    exit.addActionListener(new ButtonHandler());
  }

  void addButtons() {
    add(exit);

  }

  class ButtonHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      String buttonText = ((JButton) e.getSource()).getText();
      gameEngine.resetFocusToFrame();
      if (buttonText.equals("EXIT"))
        System.exit(1);
    }
  }
}
