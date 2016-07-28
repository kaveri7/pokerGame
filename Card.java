class Card {
    String suit;            //can have value such as club, diamond,
    int pip;
    public String toString(){
        return "" + pip + suit;
    }
    public Card(String suit, int pip){
        this.suit = suit;
        this.pip = pip;
    }
    public String compare(Card anotherCard){
        return "Greater";
    }
}
