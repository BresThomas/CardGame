package model;

public enum Color {
    SPADES("Spades"),
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final String label;

    private Color(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
