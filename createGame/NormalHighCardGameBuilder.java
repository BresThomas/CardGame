package createGame;

public class NormalHighCardGameBuilder implements GameBuilder {
    public Game getGame() {
        return new Game(DeckFactory.makeDeck(DeckType.Normal),
                        EvaluatorFactory.makeEvaluator(EvaluatorType.High));
    }
}   
