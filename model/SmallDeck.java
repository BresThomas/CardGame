package model;

public class SmallDeck implements Deck {
    
    public DeckType makeDeck() {
        Deck myDeck = DeckFactory.makeDeck(DeckType.Small);
        return DeckType.Small
    }
}