package model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<PlayingCardAdapter> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public List<PlayingCardAdapter> getCards() {
        return cards;
    }

    public void addCard(PlayingCardAdapter card) {
        cards.add(card);
    }

    public PlayingCardAdapter removeCard() {
        return cards.remove(0);
    }
}

