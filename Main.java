import controller.GameController;
import model.Deck;
import view.View;

public class Main {
    public static void main(String[] args) {
        // Instancier la vue
        View gameView = new View();

        // Instancier un deck
        Deck deck = new Deck();

        // Instancier le contrôleur et transmettre la vue
        GameController gameController = new GameController(deck, gameView);

        // Lancer l'interaction
        gameController.run();
    }
}
