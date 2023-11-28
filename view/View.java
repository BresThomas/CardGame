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
        String playerName = scanner.nextLine();
        if (playerName.isEmpty()) {
            gc.startGame();
        } else {
            gc.addPlayer(playerName);
        }
    }
    
    public void showCardDealt() {
        System.out.println("Cartes distribuées.");
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

    public void setController(GameController gc) {
        this.gc = gc;
    }
}
