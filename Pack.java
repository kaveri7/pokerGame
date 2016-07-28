public class Pack {
    Card[] cards;
    Joker[] jokers;
    private final int NUMOFSUITS = 4;
    private final int NUMOFCARDSINASUIT = 13;
    Pack (int numOfJokers){
        String suit = "";
        for (int suitIter = 1; suitIter <= NUMOFSUITS; suitIter++) {
            if (suitIter == 1) suit = "Club";
            if (suitIter == 2) suit = "Diamond";
            if (suitIter == 3) suit = "Heart";
            if (suitIter == 4) suit = "Spade";
            for (int pip = 1; pip <= NUMOFCARDSINASUIT; pip++) {
                cards[suitIter * pip] = new Card(suit, pip);
            }
        }
        for (int jokerIter = 1; jokerIter <= numOfJokers; jokerIter++){
            jokers[jokerIter] = new Joker();
        }
    }
}