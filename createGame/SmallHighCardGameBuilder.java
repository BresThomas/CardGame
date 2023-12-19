package createGame;

public class SmallHighCardGameBuilder implements GameBuilder {
    public Game getGame() {
        return new Game(DeckFactory.makeDeck(DeckType.Small),
                        EvaluatorFactory.makeEvaluator(EvaluatorType.High));
    }
}   