package model;

public class Joker extends PlayingCardAdapter {

    public Joker() {
        super(null, null);
    }

    @Override
    public Rank getRank() {
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
