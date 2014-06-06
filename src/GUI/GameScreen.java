package GUI;

import Controller.GameEngine;
import Controller.KeyboardController;
import Map.Room;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {
  private ControlPanel controlPanel;
  private PauseMenu pauseMenu;
  private MainMenu mainMenu;
  private MapScreen mapScreen;
  private int screenWidth;
  private int screenHeight;
  private int controlPanelWidth, controlPanelY;
  private int controlPanelHeight = 200, controlPanelX = 0;
  private int pauseMenuX, pauseMenuY, pauseMenuWidth = 200, pauseMenuHeight = 500;
  private int mainMenuX, mainMenuY, mainMenuWidth = 400, mainMenuHeight = 500;
  private int mapScreenX = 0, mapScreenY = 0, mapScreenWidth, mapScreenHeight;
  private GameEngine gameEngine;

  public GameScreen() {
    setLayout(null);
    setUndecorated(true);
    setFocusable(true);
    requestFocusInWindow();

    setAllSizes();
    createPanels();
    addPanels();
  }

  public void setGameEngine(GameEngine gameEngine) {
    mainMenu.setGameEngine(gameEngine);
    pauseMenu.setGameEngine(gameEngine);
    controlPanel.setGameEngine(gameEngine);
    mapScreen.setGameEngine(gameEngine);
    this.gameEngine = gameEngine;
  }

  public void addControllers() {
    addKeyListener(new KeyboardController(gameEngine));
    mainMenu.addControllers();
    controlPanel.addControllers();
    pauseMenu.addControllers();
  }

  private void addPanels() {
    addControlPanel();
    addPauseMenu();
    addMainMenu();
    addMapScreen();
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

  public void showMapScreen() {
    mapScreen.setVisible(true);
  }

  public void hideMapScreen() {
    mapScreen.setVisible(false);
  }

  public void toggleMapScreen() {
    mapScreen.setVisible(!mapScreen.isVisible());
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

  private void addMapScreen() {
    add(mapScreen);
    mapScreen.setBounds(mapScreenX, mapScreenY, mapScreenWidth, mapScreenHeight);
    mapScreen.setVisible(false);
  }

  private void createPanels() {
    pauseMenu = new PauseMenu();
    controlPanel = new ControlPanel();
    mapScreen = new MapScreen();
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
    mapScreenWidth = screenWidth;
    mapScreenHeight = screenHeight - controlPanelHeight;
  }

  public void setupRoom(Room room) {
    mapScreen.setupNewRoom(room);
  }

  private Dimension getResolution() {
    return new Dimension(800, 600);

  }

  public ControlPanel getControlPanel() {
    return controlPanel;
  }
}