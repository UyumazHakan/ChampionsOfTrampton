package Controller;

import GUI.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hakan on 10.5.2014.
 */
public class PauseMenuController extends MenuController {
  public PauseMenuController(GameEngine gameEngine) {
    super(gameEngine);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String buttonText = ((JButton) e.getSource()).getText();
    gameEngine.resetFocusToFrame();
    if (buttonText.equals("EXIT"))
      System.exit(1);
  }
}
