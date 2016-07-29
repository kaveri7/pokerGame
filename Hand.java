import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    final int cardsInOneHand = 5;
    Card[] cards;

    public Hand(){
        Deck myDeck = new Deck(1,0);
        myDeck.shuffle();
        cards = new Card[cardsInOneHand];
        for(int i = 0; i < cardsInOneHand; i++){
            cards[i] = myDeck.cards[i];
        }
    }
    public String toString(){
        String myCards = "";
        for(int i = 0; i < cardsInOneHand; i++){
            myCards += cards[i] + "\n";
        }
        return myCards;
    }
    public static void main(String[] args) {
        Hand myHand = new Hand();
        System.out.println(myHand);
        System.out.println(myHand.display());
    }

    public String display() {
        if (isSuitSameForAll5Cards() && isAllCardsNextToEachOther() && isFirstCardTen()) {
            return "Royal Flush";
        } else if (isSuitSameForAll5Cards() && isAllCardsNextToEachOther()) {
            return "Straight flush";
        } else if (maxCountOfSamePip() == 4){
            return "Four of a kind";
        } else if (maxCountOfSamePip() == 3 && isTwoPair()){
            return "Full House";
        } else if (isSuitSameForAll5Cards()){
            return "Flush";
        } else if (isAllCardsNextToEachOther()) {
            return "Straight";
        } else if (maxCountOfSamePip() == 3){
            return "3 of a kind";
        } else if (isTwoPair()){
            return "Two pair";
        } else if (maxCountOfSamePip() == 2){
            return "One pair";
        } else{
            return "High card ";
        }
    }

    public boolean isSuitSameForAll5Cards() {
        for(int i = 0; i < cardsInOneHand - 1; i++) {
            if (!cards[i].isSuitSame(cards[i + 1])) {
                return false;
            }
        }
        return true;
    }
    public boolean isAllCardsNextToEachOther(){
            Card[] sortedCards = sortCards();
            for(int i = 0; i < cardsInOneHand - 1; i++){
                if(i == 0 && sortedCards[i].getPip() == "A" && sortedCards[i+1].getPip() == "T") continue;
                if(sortedCards[i].compareTo(sortedCards[i+1]) != -1) return false;
            }
            return true;
    }
    public boolean isFirstCardTen(){
        Card[] sortedCards = sortCards();
        if(sortedCards[1].getPip() == "T") return true;
        return false;
    }
    public Card[] sortCards(){
        ArrayList<Card> cardsList = new ArrayList<>();
        for(Card card : cards) {
            cardsList.add(card);
        }
        Collections.sort(cardsList);
        Card[] cards1 = new Card[cardsInOneHand];
        cards1 = cardsList.toArray(cards1);
        return cards1;
    }
    public int maxCountOfSamePip(){
        int count = 1;
        int maxcount = 1;
        Card[] sortedCards = sortCards();
        for(int i = 0; i < cardsInOneHand - 1; i++){
            if(sortedCards[i].compareTo(sortedCards[i+1]) == 0){
                count++;
            }
            else{
                if(count > maxcount) maxcount = count;
                count = 1;
            }
        }
        return maxcount;
    }
    public boolean isTwoPair(){
        int count = 1;
        int maxCount = 1;
        int numOfPairs = 0;
        Card[] sortedCards = sortCards();
        for(int i = 0; i < cardsInOneHand - 1; i++){
            if(sortedCards[i].compareTo(sortedCards[i+1]) == 0){
                count++;
                numOfPairs++;
            }
            else{
                if(count > maxCount) maxCount = count;
                count = 1;
            }
        }
        return (numOfPairs >= 2);
    }
}