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
    public String getColor(){
        if(suit == "spade" || suit == "club") return "black";
        return "red";
    }
    public String getPip(){
        if(pip == 1) return "A";
        if(pip == 11) return "J";
        if(pip == 12) return "Q";
        if(pip == 13) return "K";
        return "" + pip;
    }
    public String compare(Card anotherCard){
        if(compareSuit(anotherCard) == "same") {
            return "same suit and " + comparePip(anotherCard);
        }
        return compareColor(anotherCard) + " color and " + comparePip(anotherCard);
    }
    public String comparePip(Card anotherCard){
        if(anotherCard.pip > this.pip) return "Greater";
        if(anotherCard.pip < this.pip) return "Lesser";
        return "equal";
    }
    public String compareSuit(Card anotherCard){
        if(anotherCard.suit == this.suit) return "same";
        return "different";
    }
    public String compareColor(Card anotherCard){
        if(anotherCard.getColor() == this.getColor()) return "same";
        return "different";
    }
}
