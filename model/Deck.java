package model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<PlayingCardAdapter> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    public void initializeDeck() {
        for (Color color : Color.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new PlayingCard(rank, color));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public PlayingCardAdapter drawCard() {
        if (!cards.isEmpty()) {
            PlayingCardAdapter drawnCard = cards.remove(0);
            drawnCard.flip();
            return drawnCard;
        } else {
            System.out.println("Le deck est vide. Impossible de piocher.");
            return null;
        }
    }

    public void returnCard(PlayingCardAdapter card) {
        cards.add(card);
    }
}
