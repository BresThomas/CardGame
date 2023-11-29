package gameRules;

import java.util.ArrayList;
import java.util.List;
import model.Player;

public class HighCardGameEvaluator implements GameEvaluator {
    @Override
    public Player evaluateWinners(List<Player> players) {
        List<Player> winners = new ArrayList<>();
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

        // Vous devrez décider comment gérer le cas où il y a plusieurs gagnants
        // Pour l'instant, nous renvoyons le premier gagnant trouvé
        return winners.isEmpty() ? null : winners.get(0);
    }
}
