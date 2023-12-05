package model;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void drawCard(Deck deck) {
        PlayingCard drawnCard = deck.drawCard();
        if (drawnCard != null) {
            hand.addCard(drawnCard);
            // System.out.println(name + " pioche une carte : " + drawnCard);
        } else {
            System.out.println("Impossible de piocher, le deck est vide.");
        }
    }

    public PlayingCard playCard() {
        return hand.removeCard();
        // deck.returnCard(card);
        //System.out.println(name + " joue une carte : " + card);
    }

    public void showHand() {
        System.out.println(name + " a en main : " + hand.getCards());
    }
}
