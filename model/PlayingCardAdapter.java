package model;

class PlayingCardAdaptater implements PlayableCard {
    private CoolCard coolCard;
    
    public void flip() {
        coolCard.turnOver();
    }
} 