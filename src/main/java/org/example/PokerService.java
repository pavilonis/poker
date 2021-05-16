package org.example;

import org.example.model.Card;
import org.example.model.CombinationType;
import org.example.model.Hand;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

public class PokerService {

   public Player processGame(String line) {
      List<Card> cards = parseCards(line);
      return findWinner(cards);
   }

   public static List<Card> parseCards(String line) {
      return Stream.of(line.split(" "))
            .map(Card::new)
            .collect(toList());
   }

   private Player findWinner(List<Card> cards) {
      List<Card> player1Cards = cards.subList(0, 5);
      List<Card> player2Cards = cards.subList(5, 10);

      Hand player1Hand = resolveHand(player1Cards);
      Hand player2Hand = resolveHand(player2Cards);
      int result = player1Hand.compareTo(player2Hand);
      if (result == 0) {
         return null;
      }
      return result > 0 ? Player.A : Player.B;
   }

   private Hand resolveHand(List<Card> cards) {
      List<Card> sortedCards = new ArrayList<>(cards);
      cards.sort(naturalOrder());
      return Stream.of(CombinationType.values())
            .map(CombinationType::getHandResolver)
            .map(resolver -> resolver.apply(sortedCards))
            .filter(Objects::nonNull)
            .findFirst()
            .orElseThrow();
   }
}
