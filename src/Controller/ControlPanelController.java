package Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hakan on 8.5.2014.
 */
public class ControlPanelController extends MenuController {


  public ControlPanelController(GameEngine gameEngine) {
    super(gameEngine);
  }

  public void actionPerformed(ActionEvent e) {
      String buttonText = ((JButton) e.getSource()).getText();
      gameEngine.resetFocusToFrame();
    }

}
