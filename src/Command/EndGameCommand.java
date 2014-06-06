package Command;

import GUI.GameScreen;
import GUI.ScoreBoard;
import PlayableCharacter.Hero;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by UyumazHakan on 06.06.2014.
 */
public class EndGameCommand implements Command {
  private final int BOARD_X=100, BOARD_Y=50, BOARD_WIDTH = 200, BOARD_HEIGHT = 500;
  private ArrayList<Hero> sortedHeroes;
  private boolean[] usedHeroes;
  private GameScreen screen;
  public EndGameCommand(ArrayList<Hero> heroes, GameScreen screen) {
    this.screen=screen;
    sortedHeroes=new ArrayList<Hero>();
    initUsedHeroes(heroes.size());
    for(int i=0;i<heroes.size();i++)
      sortedHeroes.add(getMostExperienced(heroes));
  }

  private void initUsedHeroes(int size) {
    usedHeroes=new boolean[size];
    for(int i=0;i<size;i++)
      usedHeroes[i]=false;
  }

  private Hero getMostExperienced(ArrayList<Hero> heroes) {
    Hero mostExperiencedHero=null;
    for(int i=0;i<heroes.size();i++) {
      if (!usedHeroes[i]) {
        mostExperiencedHero = heroes.get(i);
        break;
      }
    }

    for(int i=1;i<heroes.size();i++) {
      if (!usedHeroes[i] && mostExperiencedHero.getExperience() < heroes.get(i).getExperience()) {
        mostExperiencedHero = heroes.get(i);
        usedHeroes[i]=true;
      }
    }
    return mostExperiencedHero;

  }

  @Override
  public void execute() {
    ScoreBoard board=new ScoreBoard(sortedHeroes);
    board.setBounds(BOARD_X,BOARD_Y,BOARD_WIDTH,BOARD_HEIGHT);
    screen.add(board);
    board.setVisible(true);
    screen.toggleControlPanel();
    screen.toggleMapScreen();
  }

  @Override
  public void networkExecute() {
    execute();
  }
}
