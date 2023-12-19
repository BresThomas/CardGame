package createGame;

public class DeckFactory {
    public static Deck makeDeck(DeckType type) {
        switch (type) {
            case Normal:
                return new NormalDeck();
            case Small:
                return new SmallDeck();
            case Test:
                return new TestDeck();
        }

        // fallback
        return new NormalDeck();
    }
}