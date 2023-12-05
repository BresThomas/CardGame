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

    public PlayingCard removeCard() {
        return cards.remove(0);
    }
}

