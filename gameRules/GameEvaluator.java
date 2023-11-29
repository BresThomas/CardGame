package gameRules;

import java.util.ArrayList;

import model.Player;

public interface GameEvaluator {
    ArrayList<Player> evaluateWinners(ArrayList<Player> players);
}
