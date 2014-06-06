package GUI;

import PlayableCharacter.Hero;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by UyumazHakan on 06.06.2014.
 */
public class ScoreBoard extends JPanel {
  private final int SCORE_HEIGHT = 50, SCORE_WIDTH = 200, SCORE_X = 60, FIRST_SCORE_Y = 30, SCORE_VERTICAL_GAP=80;
  private ArrayList<Hero> heroes;

  public ScoreBoard(ArrayList<Hero> heroes) {
    this.heroes = heroes;
    setLayout(null);
    setBackground(Color.white);
    setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    addScores();
  }

  private void addScores() {
    for(int i=0;i<heroes.size();i++){
      Hero hero=heroes.get(i);
      int experience=hero.getExperience();
      JLabel label=new JLabel(i+". "+hero+" - "+experience);
      label.setBounds(SCORE_X,FIRST_SCORE_Y+SCORE_VERTICAL_GAP*i,SCORE_WIDTH,SCORE_HEIGHT);
      add(label);

    }
  }
}
