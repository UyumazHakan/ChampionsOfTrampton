package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Hakan on 8.5.2014.
 */
public class ControlPanelController extends MenuController {


  public ControlPanelController(GameEngine gameEngine) {
    super(gameEngine);
  }

  public void actionPerformed(ActionEvent e) {
    String buttonText = ((JButton) e.getSource()).getText();
    if (buttonText.equals("UP"))
      gameEngine.stepUpHero();
    else if (buttonText.equals("DOWN"))
      gameEngine.stepDownHero();
    else if (buttonText.equals("LEFT"))
      gameEngine.stepLeftHero();
    else if (buttonText.equals("RIGHT"))
      gameEngine.stepRightHero();
    gameEngine.updateMapScreen();
    gameEngine.resetFocusToFrame();

  }

}
