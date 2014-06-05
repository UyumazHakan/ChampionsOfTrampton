package GUI;

import Controller.GameEngine;
import Map.Door;
import Map.Room;
import Map.Tower;
import PlayableCharacter.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MapScreen extends JPanel {
  private  ImageIcon floorImage = new ImageIcon("images/floor.png");
  private  ImageIcon towerImage = new ImageIcon("images/tower.png");
  private  ImageIcon doorImage = new ImageIcon("images/door.png");
  private JLabel[][] tiles;
  private GameEngine gameEngine;
  private int mapWidth;
  private int mapHeight;
    private Room room;

  public MapScreen() {
    setLayout(null);
    setBackground(Color.RED);
    tiles=new JLabel[0][0];
  }

  public void setGameEngine(GameEngine gameEngine) {
    this.gameEngine = gameEngine;
  }

  public void setupNewRoom(Room room) {
      this.room=room;
    reset();
    tiles = new JLabel[room.getWidth()][room.getHeight()];
      setSizeOfImages();
    setupFloors();
    setupDoors(room.getDoors(), room.getRoomNumber());
    setupTowers(room.getTowers());
    setupCharacters(room.getCharacters());
    reset();
    drawRoom();


  }

    private void setSizeOfImages() {
        floorImage = new ImageIcon(getResizedImage(floorImage.getImage()));
        doorImage = new ImageIcon((getResizedImage(doorImage.getImage())));
    }

    private Image getResizedImage(Image imageToResized) {
        Image img = imageToResized;
        int tileWidth = getWidth() / tiles.length;
        int tileHeight = getHeight() / tiles[0].length;
        return img.getScaledInstance(tileWidth, tileHeight,  Image.SCALE_SMOOTH);
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
      ImageIcon heroIcon=((Hero)character).getIcon();
      heroIcon=new ImageIcon(getResizedImage(heroIcon.getImage()));
      tiles[x][y] = new JLabel(heroIcon);
      System.out.println("x: "+x+" y:"+y);
    }
  }
  private void setupDoors(ArrayList<Door> doors, int roomNumber) {
    for (Door door : doors) {
      int x = door.getXForRoom(roomNumber);
      int y = door.getYForRoom(roomNumber);
      try {
          tiles[x][y] = new JLabel(doorImage);
      }catch (Exception e){
          System.out.println(x +"-"+tiles.length+"-"+room.getWidth()+" "+y+"-"+tiles[0].length+"-"+room.getHeight());
      }
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
      System.out.println(tileWidth);
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