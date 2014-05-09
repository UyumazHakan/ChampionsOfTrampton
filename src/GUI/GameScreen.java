package GUI;

import Controller.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameScreen extends JFrame {
  private ControlPanel controlPanel;
  private PauseMenu pauseMenu;
  private MainMenu mainMenu;
  private int screenWidth;
  private int screenHeight;
  private int controlPanelWidth, controlPanelY;
  private int controlPanelHeight = 200, controlPanelX = 0;
  private int pauseMenuX, pauseMenuY, pauseMenuWidth = 200, pauseMenuHeight = 500;
  private int mainMenuX, mainMenuY, mainMenuWidth = 400, mainMenuHeight = 500;
  private GameEngine engine;

  public void setEngine(GameEngine engine) {
    mainMenu.setGameEngine(engine);
    pauseMenu.setGameEngine(engine);
    controlPanel.setGameEngine(engine);
    this.engine = engine;
  }

  public GameScreen() {
    setLayout(null);
    setUndecorated(false);
    addKeyListener(new GameController());
    setAllSizes();
    createPanels();
    addControlPanel();
    addPauseMenu();
    addMainMenu();
    setFocusable(true);
    requestFocusInWindow();

  }
  public void showControlPanel() {
    controlPanel.setVisible(true);
  }
  public void hideControlPanel() {
    controlPanel.setVisible(false);
  }
  public void toggleControlPanel() {
    controlPanel.setVisible(!controlPanel.isVisible());
  }
  public void showMainMenu() {
    mainMenu.setVisible(true);
  }
  public void hideMainMenu() {
    mainMenu.setVisible(false);
  }
  public void toggleMainMenu() {
    mainMenu.setVisible(!mainMenu.isVisible());
  }
  public void showPauseMenu() {
    pauseMenu.setVisible(true);
  }
  public void hidePauseMenu() {
    pauseMenu.setVisible(false);
  }
  public void togglePauseMenu() {
    pauseMenu.setVisible(!pauseMenu.isVisible());
  }

  private void addControlPanel() {
    add(controlPanel);
    controlPanel.setBounds(controlPanelX, controlPanelY, controlPanelWidth, controlPanelHeight);
    controlPanel.setVisible(false);
  }

  private void addPauseMenu() {
    add(pauseMenu);
    pauseMenu.setBounds(pauseMenuX, pauseMenuY, pauseMenuWidth, pauseMenuHeight);
    pauseMenu.setVisible(false);
  }

  private void addMainMenu() {
    add(mainMenu);
    mainMenu.setBounds(mainMenuX, mainMenuY, mainMenuWidth, mainMenuHeight);
    mainMenu.setVisible(true);
  }

  private void createPanels() {
    pauseMenu = new PauseMenu();
    controlPanel = new ControlPanel(controlPanelWidth, controlPanelHeight);
    mainMenu = new MainMenu();
  }

  private void setAllSizes() {
    Dimension size = getResolution();
    screenWidth = (int) size.getWidth();
    screenHeight = (int) size.getHeight();
    setSize(screenWidth, screenHeight);
    controlPanelWidth = screenWidth;
    controlPanelY = screenHeight - controlPanelHeight;
    pauseMenuX = (screenWidth - pauseMenuWidth) / 2;
    pauseMenuY = (screenHeight - pauseMenuHeight) / 2;
    mainMenuX = (screenWidth - mainMenuWidth) / 2;
    mainMenuY = (screenHeight - mainMenuHeight) / 2;


  }

  private Dimension getResolution() {
    return new Dimension(800, 600);

  }

  class GameController extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        engine.togglePauseGame();
      }
    }
  }

}