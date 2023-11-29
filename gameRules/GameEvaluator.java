package gameRules;

import java.util.List;

import model.Player;

public interface GameEvaluator {
    Player evaluateWinners(List<Player> players);
}
