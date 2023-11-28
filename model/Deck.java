package model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<PlayingCard> cards;

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

    public PlayingCard drawCard() {
        if (!cards.isEmpty()) {
            PlayingCard drawnCard = cards.remove(0);
            drawnCard.flip();
            return drawnCard;
        } else {
            System.out.println("Le deck est vide. Impossible de piocher.");
            return null;
        }
    }

    public void returnCard(PlayingCard card) {
        card.flip();
        cards.add(card);
    }
}
