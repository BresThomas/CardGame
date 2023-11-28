package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<PlayingCard> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    public void addCard(PlayingCard card) {
        cards.add(card);
    }

    public void removeCard(PlayingCard card) {
        cards.remove(card);
    }
}

