package Controller;

import GUI.ControlPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Hakan on 8.5.2014.
 */
public class ControlPanelController extends MenuController {
  private ControlPanel controlPanel;

  public ControlPanelController(GameEngine gameEngine, ControlPanel controlPanel) {
    super(gameEngine);
    this.controlPanel=controlPanel;
  }

  public void actionPerformed(ActionEvent e) {
    String buttonText = ((JButton) e.getSource()).getText();
    System.out.println("-----"+gameEngine.getCurrentHeroTurn());
    controlPanel.changeTurn(gameEngine.getCurrentHeroTurn());
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
