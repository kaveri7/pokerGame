
public class Deck {
    Pack[] packs;
    Deck(int numOfPacks, int numOfJokersInEachPack){
        for(int i = 0; i < numOfPacks; i++){
            packs[i] = new Pack(numOfJokersInEachPack);
        }
    }
}
