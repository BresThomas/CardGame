package view;

import java.util.ArrayList;

import controller.GameController;
import model.Player;

public interface GameViewable {
    void setController(GameController controller);

    void promptPlayerNames();
    void showPlayerName(Player player);

    void showFaceDownCardForPlayer(int playerIndex, String name);

    void promptCardDealt();
    void showCardForPlayer(int playerIndex, String name, String rank, String suit);
   void showWinners(ArrayList<Player> winnersName);

    void promptForNewGame();
}
