/**
 * Created by yeolep on 7/28/2016.
 */
public class Hand {
    //int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    int CardsInHand[] = {1, 2, 3, 4, 5};
    int count = 0;
    int sameSuit = 0;
    int color;
    int i;

    public static void main(String[] args) {

        //String[] Hands = {"Straight flush", "Four of a kind", "Full house", "Flush", "Straight", "Three of a kind", "Two pair", "One pair", "High card"};
    }

    public int returnHand() {
        for (i = 0; i < 5; i++) {
            if (CardsInHand[i] == CardsInHand[i + 1]) {
                count++;
            }
        }
        for (i = 0; i < 5; i++) {
            if (isSuitSame()) {
                sameSuit++;
            }
        }
        return sameSuit;
    }

    public boolean isSuitSame() {
        return true;
    }

    public String display() {
        if (count == 5 && sameSuit == 5) {
            return " Straight Flush ";
        } else if (count == 5) {
            return "Straight ";
        } else {
            return "High Card ";
        }
    }
}