package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Hakan on 10.5.2014.
 */
public class MainMenuController extends MenuController {
  public MainMenuController(GameEngine gameEngine) {
    super(gameEngine);
  }

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