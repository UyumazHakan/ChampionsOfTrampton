package GUI;

import Controller.ControlPanelController;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends Menu {
  private int upHeight = 80, upWidth = 50, upX = 120, upY = 10;
  private int downHeight = 80, downWidth = 50, downX = 120, downY = 110;
  private int leftHeight = 50, leftWidth = 80, leftX = 20, leftY = 75;
  private int rightHeight = 50, rightWidth = 80, rightX = 190, rightY = 75;
  private int targetHeight = 100, targetWidth = 100, targetX = 500, targetY = 75;
  private int turnHeight = 50, turnWidth = 80, turnX = 300, turnY = 70;
  private int panelWidth, panelHeight;
  private JButton up;
  private JButton down;
  private JButton left;
  private JButton right;
  private JButton upAttack;
  private JButton downAttack;
  private JButton leftAttack;
  private JButton rightAttack;
  private JLabel turn;
  private JLabel target;

  public ControlPanel(int width, int height) {
    this.panelHeight = height;
    this.panelWidth = width;
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
    add(target);
  }

  private void setLabelLocations() {
    turn.setBounds(turnX, turnY, turnWidth, turnHeight);
    target.setBounds(targetX, targetY, targetWidth, targetHeight);
  }

  private void initLabels() {
    turn = new JLabel();
    target = new JLabel();
  }

  void setButtonLocations() {
    up.setBounds(upX, upY, upWidth, upHeight);
    down.setBounds(downX, downY, downWidth, downHeight);
    left.setBounds(leftX, leftY, leftWidth, leftHeight);
    right.setBounds(rightX, rightY, rightWidth, rightHeight);
    upAttack.setBounds(upX, upY, upWidth, upHeight);
    downAttack.setBounds(downX, downY, downWidth, downHeight);
    leftAttack.setBounds(leftX, leftY, leftWidth, leftHeight);
    rightAttack.setBounds(rightX, rightY, rightWidth, rightHeight);
  }

  void initButtons() {
    up = new JButton("UP");
    down = new JButton("DOWN");
    left = new JButton("LEFT");
    right = new JButton("RIGHT");
    upAttack = new JButton("ATTACK");
    downAttack = new JButton("ATTACK");
    leftAttack = new JButton("ATTACK");
    rightAttack = new JButton("ATTACK");
    up.setName("UP");
    down.setName("DOWN");
    left.setName("LEFT");
    right.setName("RIGHT");
    upAttack.setName("UP");
    downAttack.setName("DOWN");
    leftAttack.setName("LEFT");
    rightAttack.setName("RIGHT");

  }

  public void addControllers() {
    up.addActionListener(new ControlPanelController(gameEngine, this));
    down.addActionListener(new ControlPanelController(gameEngine, this));
    left.addActionListener(new ControlPanelController(gameEngine, this));
    right.addActionListener(new ControlPanelController(gameEngine, this));
    upAttack.addActionListener(new ControlPanelController(gameEngine, this));
    downAttack.addActionListener(new ControlPanelController(gameEngine, this));
    leftAttack.addActionListener(new ControlPanelController(gameEngine, this));
    rightAttack.addActionListener(new ControlPanelController(gameEngine, this));
  }

  void addButtons() {
    add(up);
    add(down);
    add(left);
    add(right);
    add(upAttack);
    add(downAttack);
    add(leftAttack);
    add(rightAttack);
  }

  public void changeTurn(int numTurn) {
    turn.setText("" + numTurn);
  }

  public void setTarget(ImageIcon icon) {
    this.target.setIcon(icon);
  }

  public void showUpAttack() {
    up.setVisible(false);
    upAttack.setVisible(true);
  }

  public void showDownAttack() {
    down.setVisible(false);
    downAttack.setVisible(true);
  }

  public void showLeftAttack() {
    left.setVisible(false);
    leftAttack.setVisible(true);
  }

  public void showRightAttack() {
    right.setVisible(false);
    rightAttack.setVisible(true);
  }

  public void showUpMove() {
    up.setVisible(true);
    upAttack.setVisible(false);
  }

  public void showDownMove() {
    down.setVisible(true);
    downAttack.setVisible(false);
  }

  public void showLeftMove() {
    left.setVisible(true);
    leftAttack.setVisible(false);
  }

  public void showRightMove() {
    right.setVisible(true);
    rightAttack.setVisible(false);
  }
}