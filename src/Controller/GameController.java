package Controller;

import GUI.GameScreen;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Hakan on 8.5.2014.
 */
public class GameController extends KeyAdapter {
  private GameScreen screen;
  public GameController(){
    System.out.println("Imp");
  }

  public void keyPressed(KeyEvent e) {
    System.out.println("YESY");
    if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
    {

      System.exit(1);
    }
  }

}
