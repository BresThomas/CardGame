package view;

import controller.GameController;
import model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    GameController gc;
    Scanner scanner = new Scanner(System.in);
    
    public void promptPlayerNames() {
        System.out.println("Entrez les noms des joueurs. Sinon appuyez sur Entrée pour continuer.");
        String nextLine = scanner.nextLine();
        if (nextLine.isEmpty()) {
            gc.startGame();
        } else {
            gc.addPlayer(nextLine);
        }
    }
    
    public void promptCardDealt() {
        System.out.println("Si vous voulez distribuer les cartes, écrivez quelque chose : ");
        String nextLine = scanner.nextLine();
        if (!nextLine.isEmpty()) {
            gc.flipCards();
        }
    }
    
    public void promptWinners() {
        System.out.println("Si vous voulez afficher les gagnants, écrivez quelque chose : ");
        String nextLine = scanner.nextLine();
        if (!nextLine.isEmpty()) {
            gc.displayWinner();
        }
    }
    
    public void setController(GameController gc) {
        this.gc = gc;
    }

    public void showPlayerName(Player player) {
        System.out.println("Joueur : " + player.getName());
    }
    
    public void showFaceDownCardForPlayer(int playerIndex, String Name) {
        System.out.println("Carte face cachée pour " + Name);
    }
    
    public void showCardForPlayer(int playerIndex, String Name, String rank, String suit) {
        System.out.println("Carte pour " + Name + " : " + rank + " de " + suit);
    }

    public void showWinners(ArrayList<Player> winners){
        // Afficher les gagnants
        if (!winners.isEmpty()) {
            System.out.println("Les gagnants sont :");
            for (Player winner : winners) {
                System.out.println(winner.getName());
            }
        } else {
            System.out.println("Aucun gagnant.");
        }
    }
}
