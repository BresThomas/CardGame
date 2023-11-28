package controller;

import model.Deck;
import model.Player;
import view.View;
import java.util.ArrayList;

public class GameController {
    private enum GameState{
        AddingPlayer,
        CardsDealt,
        WinnerRevealed,
    };

    GameState gameState;
    Deck deck;
    View view;
    private ArrayList<Player> playerNames;
    private ArrayList<Player> winners;

    public GameController(Deck deck, View view) {
        this.deck = deck;
        this.view = view;
        this.view.setController(this);
        this.gameState = GameState.AddingPlayer;
        this.playerNames = new ArrayList<>();
    }

    public void run() {
        while (true) {
            switch (gameState) {
                case AddingPlayer:
                    promptPlayerNames();
                    break;
            
                case CardsDealt:
                    view.showCardDealt();
                    break;

                case WinnerRevealed:
                    view.showWinners(winners);
                    return;
                    
            }
        }
    }
    
    public void startGame() {

        // Mélanger les cartes
        deck.shuffleDeck();

        // Distribuer une carte à chaque joueur
        for (Player player : playerNames) {
            player.drawCard(deck);
        }

        // Retourner les cartes
        for (Player player : playerNames) {
            player.getHand().getCards().get(0).flip();
        }

        this.gameState = GameState.CardsDealt;

        // Évaluer les gagnants
        winners = evaluateWinners();

        // Reconstituer le deck
        for (Player player : playerNames) {
            deck.returnCard(player.getHand().getCards().get(0));
            player.getHand().getCards().clear();
        }

        this.gameState = GameState.WinnerRevealed;

    }

    private ArrayList<Player> evaluateWinners() {
        ArrayList<Player> winners = new ArrayList<>();
        
        int highestRankValue = -1; // Initialisation à une valeur qui ne correspond à aucune carte valide
    
        // Trouver la carte la plus forte dans la main des joueurs
        for (Player player : playerNames) {
            if (player.getHand().getCards().size() > 0) {
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

    public void addPlayer(String playerName) {
        Player player = new Player(playerName);
        playerNames.add(player);
    }

    public void promptPlayerNames() {
        view.promptPlayerNames(); 
    }
}