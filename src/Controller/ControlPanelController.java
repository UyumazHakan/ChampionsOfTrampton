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
    this.controlPanel = controlPanel;
  }

  public void actionPerformed(ActionEvent e) {
    takeAction(((JButton) e.getSource()).getName());
    updateEngine();
    updateView();

  }

  private void updateView() {
    updateControlPanel();
    updateButtons();
  }

  private void updateControlPanel() {
    controlPanel.changeTurn(gameEngine.getCurrentHeroTurn());
    controlPanel.setTarget(gameEngine.getTargetIcon());
    controlPanel.setExperience(gameEngine.getCurrentHeroExperience());
  }

  private void updateEngine() {
    gameEngine.updateMapScreen();
    gameEngine.resetFocusToFrame();
    gameEngine.updateCurrentHero();
  }

  private void takeAction(String buttonText) {
    if (buttonText.equals("UP"))
      gameEngine.takeActionUp();
    else if (buttonText.equals("DOWN"))
      gameEngine.takeActionDown();
    else if (buttonText.equals("LEFT"))
      gameEngine.takeActionLeft();
    else if (buttonText.equals("RIGHT"))
      gameEngine.takeActionRight();
  }

  private void updateButtons() {
    updateDownButton();
    updateLeftButton();
    updateRightButton();
    updateUpButton();
  }

  private void updateUpButton() {
    if (gameEngine.haveNorthNeighbor())
      controlPanel.showUpAttack();
    else
      controlPanel.showUpMove();
  }

  private void updateDownButton() {
    if (gameEngine.haveSouthNeighbor())
      controlPanel.showDownAttack();
    else
      controlPanel.showDownMove();
  }

  private void updateLeftButton() {
    if (gameEngine.haveWestNeighbor())
      controlPanel.showLeftAttack();
    else
      controlPanel.showLeftMove();
  }

  private void updateRightButton() {
    if (gameEngine.haveEastNeighbor())
      controlPanel.showRightAttack();
    else
      controlPanel.showRightMove();
  }

}
