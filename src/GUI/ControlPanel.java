package GUI;

import Controller.ControlPanelController;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends Menu {
  private int upHeight = 80, upWidth = 50, upX = 120, upY = 10;
  private int downHeight = 80, downWidth = 50, downX = 120, downY = 110;
  private int leftHeight = 50, leftWidth = 80, leftX = 20, leftY = 75;
  private int rightHeight = 50, rightWidth = 80, rightX = 190, rightY = 75;
  private int attackHeight = 50, attackWidth = 50, attackX, attackY = 75;
  private int turnHeight = 50, turnWidth = 80, turnX = 300, turnY = 75;
  private int panelWidth, panelHeight;
  private JButton up;
  private JButton down;
  private JButton left;
  private JButton right;
  private JButton attack;
  private JLabel turn;

  public ControlPanel(int width, int height) {
    this.panelHeight = height;
    this.panelWidth = width;
    this.attackX = panelWidth - 70;
    setLayout(null);
    setBackground(Color.white);
    initButtons();
    initLabels();
    setButtonLocations();
    setLabelLocations();
    addButtons();
    addLabels();
  }

  private void addLabels() {
    add(turn);
  }

  private void setLabelLocations() {
    turn.setBounds(turnX,turnY,turnWidth,turnHeight);
  }

  private void initLabels() {
    turn=new JLabel();
  }

  void setButtonLocations() {
    up.setBounds(upX, upY, upWidth, upHeight);
    down.setBounds(downX, downY, downWidth, downHeight);
    left.setBounds(leftX, leftY, leftWidth, leftHeight);
    right.setBounds(rightX, rightY, rightWidth, rightHeight);
    attack.setBounds(attackX, attackY, attackWidth, attackHeight);
  }

  void initButtons() {
    up = new JButton("UP");
    down = new JButton("DOWN");
    left = new JButton("LEFT");
    right = new JButton("RIGHT");
    attack = new JButton("ATTACK");

  }

  public void addControllers() {
    up.addActionListener(new ControlPanelController(gameEngine,this));
    down.addActionListener(new ControlPanelController(gameEngine,this));
    left.addActionListener(new ControlPanelController(gameEngine,this));
    right.addActionListener(new ControlPanelController(gameEngine,this));
    attack.addActionListener(new ControlPanelController(gameEngine,this));
  }

  void addButtons() {
    add(up);
    add(down);
    add(left);
    add(right);
    add(attack);
  }
  public void changeTurn(int numTurn){
    turn.setText(""+numTurn);
  }

}