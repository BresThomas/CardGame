package controller;

import model.Deck;
import model.Player;
import model.PlayingCard;
import view.GameViewable;
import view.View;
import java.util.ArrayList;

import gameRules.GameEvaluator;

public class GameController {
    private enum GameState{
        AddingPlayer,
        CardsDealt,
        WinnerRevealed,
    };

    GameState gameState;
    Deck deck;
    private GameViewable view;
    private ArrayList<Player> playerNames;
    private ArrayList<Player> winners;
    private GameEvaluator gameEvaluator;

    public GameController(Deck deck,GameViewable _view, GameEvaluator _gameEvaluator) {
        this.deck = deck;
        this.view = _view;
        this.view.setController(this);
        this.gameState = GameState.AddingPlayer;
        this.playerNames = new ArrayList<>();
        this.winners = new ArrayList<>();
        this.gameEvaluator = _gameEvaluator;
    }

    public void run() {
        while (true) {
            switch (gameState) {
                case AddingPlayer:
                    view.promptPlayerNames();
                    break;

                case CardsDealt:
                    view.promptCardDealt();
                    break;

                case WinnerRevealed:
                    view.promptForNewGame();
                    break;

            }
        }
    }

    public void flipCards() {
        int i = 0;
        // Retourner les cartes
        for (Player player : playerNames) {
            PlayingCardAdapter card = player.getHand().getCards().get(0);
            card.flip();
            view.showCardForPlayer(i, player.getName(), card.getRank().toString(), card.getColor().toString());
            i++;
        }

        this.winners = evaluateWinners();
        displayWinner();
        rebuildDeck();
        this.gameState = GameState.WinnerRevealed;
    }

    public void startGame() {
        
        // Mélanger les cartes
        deck.shuffleDeck();

        // Distribuer une carte à chaque joueur
        for (Player player : playerNames) {
            player.drawCard(deck);
        }

        this.gameState = GameState.CardsDealt;
    }

    public ArrayList<Player> evaluateWinners() {
        return this.gameEvaluator.evaluateWinners(this.playerNames);
    }

    public void addPlayer(String playerName) {
        Player player = new Player(playerName);
        playerNames.add(player);
        view.showPlayerName(player);
    }

    public void rebuildDeck() {
        // Récupère toutes les cartes distribuées et les remet dans le paquet
        for (Player player : playerNames) {
            deck.returnCard(player.getHand().removeCard());
        }
    }

    public void displayWinner() {
        view.showWinners(winners);
    }

    public void restartGame() {

        // Vider la liste des joueurs
        playerNames.clear();

        // Vider la liste des gagnants
        winners.clear();

        // Redémarrer le jeu
        this.gameState = GameState.AddingPlayer;
    }
}