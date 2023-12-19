package model;

public class TestDeck implements Deck {

    public DeckType makeDeck() {
        Deck myDeck = DeckFactory.makeDeck(DeckType.Test);
        return DeckType.Test
    }
}