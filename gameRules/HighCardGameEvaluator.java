package gameRules;

import java.util.ArrayList;
import model.Player;

public class HighCardGameEvaluator implements GameEvaluator {
    @Override
    public ArrayList<Player> evaluateWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();
        int highestRankValue = -1; // Initialisation à une valeur qui ne correspond à aucune carte valide

        // Trouver la carte la plus forte dans la main des joueurs
        for (Player player : players) {
            if (!player.getHand().getCards().isEmpty()) {
                int currentRankValue = player.getHand().getCards().get(0).getRank().getValue();

                if (currentRankValue > highestRankValue) {
                    // Nouvelle carte la plus forte trouvée, réinitialiser la liste des gagnants
                    winners.clear();
                    winners.add(player);
                    highestRankValue = currentRankValue;
                } else if (currentRankValue == highestRankValue) {
                    // Ajouter un autre gagnant avec la même carte la plus forte
                    winners.add(player);
                }
            }
        }

        return winners;
    }
}
