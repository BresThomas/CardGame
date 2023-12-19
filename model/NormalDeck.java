package model;

public class NormalDeck implements Deck {
    
    public DeckType makeDeck() {
        Deck myDeck = DeckFactory.makeDeck(DeckType.Normal);
        return DeckType.Normal
    }
}