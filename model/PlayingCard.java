package model;

public class PlayingCard implements PlayableCard {
    private final Rank rank;
    private final Color color;
    private boolean faceUp;

    public PlayingCard(Rank rank, Color color) {
        this.rank = rank;
        this.color = color;
        this.faceUp = false;
    }

    public Rank getRank() {
        return rank;
    }

    public Color getColor() {
        return color;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void flip() {
        faceUp = !faceUp;
    }

    @Override
    public String toString() {
        return faceUp ? rank.getLabel() + " of " + color.getLabel() : "Face Down";
    }
}
