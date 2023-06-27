package leetcode.practice2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author akarande
 * 950. Reveal Cards In Increasing Order
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 * Reference: https://www.youtube.com/watch?v=17hn4bnoOD0
 **/
public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck == null || deck.length < 2) return deck;
        Arrays.sort(deck);
        if(deck.length == 2) return deck;
        List<Integer> list = new ArrayList<>();
        list.add(deck[deck.length - 1]);
        for(int i = deck.length - 2; i >= 0; i--) {
            // Move the last card to the front of the deck.
            int front = list.remove(list.size() - 1);
            list.add(0, front);
            // Add the next biggest card to the deck.
            list.add(0, deck[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        RevealCardsInIncreasingOrder revealCardsInIncreasingOrder = new RevealCardsInIncreasingOrder();
        int deck[] = {17,13,11,2,3,5,7};
        int[] ans = revealCardsInIncreasingOrder.deckRevealedIncreasing(deck);
        Arrays.stream(ans).forEach(e -> System.out.print(e + " "));
    }
}
