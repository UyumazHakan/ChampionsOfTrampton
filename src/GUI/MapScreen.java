package GUI;

import Controller.GameEngine;
import Map.Door;
import Map.Room;
import Map.Tower;
import PlayableCharacter.PlayableCharacter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MapScreen extends JPanel {
  private final ImageIcon floorImage = new ImageIcon("images/floor.png");
  private final ImageIcon heroImage = new ImageIcon("images/hero.png");
  private final ImageIcon towerImage = new ImageIcon("images/tower.png");
  private final ImageIcon doorImage = new ImageIcon("images/door.png");
  private JLabel[][] tiles;
  private GameEngine gameEngine;
  private int mapWidth;
  private int mapHeight;

  public MapScreen() {
    setLayout(null);
    setBackground(Color.RED);
    tiles=new JLabel[0][0];
  }

  public void setGameEngine(GameEngine gameEngine) {
    this.gameEngine = gameEngine;
  }

  public void setupNewRoom(Room room) {
    reset();
    tiles = new JLabel[room.getWidth()][room.getHeight()];

    setupFloors();
    setupDoors(room.getDoors(), room.getRoomNumber());
    setupTowers(room.getTowers());
    setupCharacters(room.getCharacters());
    reset();
    drawRoom();

  }

  private void setupFloors() {

    for (int i = 0; i < tiles.length; i++)
      for (int j = 0; j < tiles[0].length; j++)
        tiles[i][j] = new JLabel(floorImage);
  }
  private void setupCharacters(ArrayList<PlayableCharacter> characters) {
    for (PlayableCharacter character : characters) {
      int x = character.getX();
      int y = character.getY();
      tiles[x][y] = new JLabel(heroImage);
      System.out.println("x: "+x+" y:"+y);
    }
  }
  private void setupDoors(ArrayList<Door> doors, int roomNumber) {
    for (Door door : doors) {
      int x = door.getXForRoom(roomNumber);
      int y = door.getYForRoom(roomNumber);
      tiles[x][y] = new JLabel(doorImage);
    }
  }

  private void setupTowers(ArrayList<Tower> towers) {
    for (Tower tower : towers) {
      int x = tower.getX();
      int y = tower.getY();
      tiles[x][y] = new JLabel(towerImage);
    }
  }

  private void drawRoom() {
    int tileWidth = getWidth() / tiles.length;
    int tileHeight = getHeight() / tiles[0].length;
    for (int i = 0; i < tiles.length; i++) {
      for (int j = 0; j < tiles[0].length; j++) {
        JLabel tile = tiles[i][j];
        add(tile);
        tile.setBounds(tileWidth * i, tileHeight * j, tileWidth, tileHeight);
      }
    }
  }
  private void reset(){
    for (int i = 0; i < tiles.length; i++) {
      for (int j = 0; j < tiles[0].length; j++) {
        JLabel tile = tiles[i][j];
        if(tile!=null) remove(tile);
      }
    }
  }

}