package GUI;

import Controller.ControlPanelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends Menu {
  private int upHeight = 80, upWidth = 50, upX = 120, upY = 10;
  private int downHeight = 80, downWidth = 50, downX = 120, downY = 110;
  private int leftHeight = 50, leftWidth = 80, leftX = 20, leftY = 75;
  private int rightHeight = 50, rightWidth = 80, rightX = 190, rightY = 75;
  private int attackHeight = 50, attackWidth = 50, attackX, attackY = 75;
  private int panelWidth, panelHeight;
  private JButton up;
  private JButton down;
  private JButton left;
  private JButton right;
  private JButton attack;

  public ControlPanel(int width, int height) {
    this.panelHeight = height;
    this.panelWidth = width;
    this.attackX = panelWidth - 70;
    setLayout(null);
    setBackground(Color.BLACK);
    initButtons();
    setButtonLocations();
    addButtons();
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
    up.addActionListener(new ControlPanelController(gameEngine));
    down.addActionListener(new ControlPanelController(gameEngine));
    left.addActionListener(new ControlPanelController(gameEngine));
    right.addActionListener(new ControlPanelController(gameEngine));
    attack.addActionListener(new ControlPanelController(gameEngine));
  }

  void addButtons() {
    add(up);
    add(down);
    add(left);
    add(right);
    add(attack);
  }

}